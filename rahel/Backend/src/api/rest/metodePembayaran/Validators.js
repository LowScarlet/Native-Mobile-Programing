const { ValidateSchemaModel, ValidateSchemaCustom, ValidateSchemaDefault } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'metodePembayaran';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'tipe',
    'keterangan',
  ];

  const model = {
    ...ValidateSchemaModel({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'id',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'tipe',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'keterangan',
    }),
  };

  const input = (x) => generateValidationObject(x, inputField, model);

  return { input, model };
};

module.exports = {
  table,
  ModelSchema,
};
