const { ValidateSchemaModel, ValidateSchemaCustom, ValidateSchemaDefault, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'pencatatan';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'nama',
    'nomorHp',
    'jumlah',
    'mulaiSewa',
    'petugasId',
    'lokasiId',
    'stokId',
  ];

  const model = {
    ...ValidateSchemaModel({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'id',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'petugasId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'petugas');

          req.scarlet.body.petugasId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'lokasiId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'lokasi');

          req.scarlet.body.lokasiId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'stokId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'stok');

          req.scarlet.body.stokId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'nama',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'nomorHp',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'jumlah',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'mulaiSewa',
    }),
  };

  const input = (x) => generateValidationObject(x, inputField, model);

  return { input, model };
};

module.exports = {
  table,
  ModelSchema,
};
