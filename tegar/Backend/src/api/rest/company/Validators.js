const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'company';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'name',
    'description',
    'location',
    'website',
    'industry',
  ];

  // *** //
  const model = {
    ...ValidateSchemaModel({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'id',
    }),

    ...ValidateSchemaModel({
      ...configSchema,
      index: 'name',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'description',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'location',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'website',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'industry',
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
