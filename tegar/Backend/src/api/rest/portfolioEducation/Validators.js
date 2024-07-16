const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'portfolioEducation';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'score',
    'startYear',
    'endYear',
    'isActive',
    'institutionId',
    'departmentId',
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
      changeValue: (x) => parseFloat(x),
      index: 'score',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'startYear',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'endYear',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => (x === 'true'),
      index: 'isActive',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'institutionId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'institution')

          req.scarlet.body.institutionId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'departmentId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'department')

          req.scarlet.body.departmentId = parseInt(value);
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
