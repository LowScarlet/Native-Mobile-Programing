const { ValidateSchemaModel, ValidateSchemaCustom, ValidateSchemaDefault } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'kategori';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'nama',
    'kapasitas',
  ];

  const model = {
    ...ValidateSchemaModel({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'id',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'nama',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'kapasitas',
    }),
  };

  const input = (x) => generateValidationObject(x, inputField, model);

  return { input, model };
};

module.exports = {
  table,
  ModelSchema,
};
