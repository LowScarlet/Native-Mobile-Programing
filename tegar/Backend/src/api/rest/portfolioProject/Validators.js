const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'portfolioProject';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'title',
    'content',
    'link',
    'startYear',
    'portfolioId',
  ];

  // *** //
  const model = {
    ...ValidateSchemaModel({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'id',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'title',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'content',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'link',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'startYear',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'portfolioId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'portfolio')

          req.scarlet.body.portfolioId = parseInt(value);
        },
      },
    }),
  };

  const input = (x) => generateValidationObject(x, inputField, model)

  return { input, model }
  // *** //
};

module.exports = {
  table,
  ModelSchema,
};
