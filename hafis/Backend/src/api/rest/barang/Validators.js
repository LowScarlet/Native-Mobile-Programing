const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'barang';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'nama',
    'deskripsi',
    'kategoriId',
    'lokasiId',
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
      index: 'nama',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'deskripsi',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'kategoriId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'kategoriBarang')

          req.scarlet.body.kategoriId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'lokasiId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'lokasi')

          req.scarlet.body.lokasiId = parseInt(value);
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
