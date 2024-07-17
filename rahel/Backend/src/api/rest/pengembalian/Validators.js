const { ValidateSchemaModel, ValidateSchemaCustom, ValidateSchemaDefault, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'pengembalian';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'waktuPengembalian',
    'harga',
    'pencatatanId',
    'stokId',
    'metodePembayaranId',
    'petugasId',
  ];

  const model = {
    ...ValidateSchemaModel({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'id',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'pencatatanId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'pencatatan');

          req.scarlet.body.pencatatanId = parseInt(value);
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

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'metodePembayaranId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'metodePembayaran');

          req.scarlet.body.metodePembayaranId = parseInt(value);
        },
      },
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

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'waktuPengembalian',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseFloat(x),
      index: 'harga',
    }),
  };

  const input = (x) => generateValidationObject(x, inputField, model);

  return { input, model };
};

module.exports = {
  table,
  ModelSchema,
};
