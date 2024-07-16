const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'pemesanan';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'tanggal',
    'jumlah',
    'status',
    'pelangganId',
    'galonId',
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
      index: 'tanggal',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'jumlah',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'status',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'pelangganId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'pelanggan')

          req.scarlet.body.pelangganId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'galonId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'galon')

          req.scarlet.body.galonId = parseInt(value);
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
