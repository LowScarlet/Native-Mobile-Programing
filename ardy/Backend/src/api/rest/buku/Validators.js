const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'buku';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'kode',
    'judul',
    'tahunTerbit',
    'halaman',
    'deskripsi',
    'bahasa',
    'penulisId',
    'kategoriId',
    'penerbitId',
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
      index: 'judul',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'tahunTerbit',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'halaman',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'deskripsi',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'bahasa',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'penulisId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'penulis')

          req.scarlet.body.penulisId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'kategoriId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'kategori')

          req.scarlet.body.kategoriId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'penerbitId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'penerbit')

          req.scarlet.body.penerbitId = parseInt(value);
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
