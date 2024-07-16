const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelHasRelation } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'portfolioDetail';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'fullName',
    'about',
    'website',
    'phone',
    'email',
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
      index: 'fullName',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'about',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'website',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'phone',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'email',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'portfolioId',
      custom: {
        options: async (value, { req }) => {
          await isModelHasRelation(value, 'portfolio', 'detail')

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
