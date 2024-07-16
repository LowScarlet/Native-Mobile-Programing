const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'menu';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'kode',
    'nama',
    'deskripsi',
    'harga',
    'kategori',
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
      index: 'kode',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'nama',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'deskripsi',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseFloat(x),
      index: 'harga',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'kategori',
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
