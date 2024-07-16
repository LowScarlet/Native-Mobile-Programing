const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'institution';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'name',
    'description',
    'accreditation',
    'website',
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
      index: 'accreditation',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'website',
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
