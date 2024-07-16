const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'peminjaman';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'tanggalPinjam',
    'tanggalKembali',
    'tanggalJatuhTempo',
    'status',
    'denda',
    'bukuId',
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
      index: 'tanggalJatuhTempo',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'tanggalPinjam',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'tanggalKembali',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'status',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseFloat(x),
      index: 'denda',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'bukuId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'buku')

          req.scarlet.body.bukuId = parseInt(value);
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
