const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'portfolioWork';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'name',
    'description',
    'isActive',
    'companyId',
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
      index: 'name',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'description',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => (x === 'true'),
      index: 'isActive',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'companyId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'company')

          req.scarlet.body.companyId = parseInt(value);
        },
      },
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
