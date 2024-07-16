const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'reservasi';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'tanggal',
    'waktu',
    'catatan',
    'konsumenId',
    'mejaId',
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
      index: 'waktu',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'catatan',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'konsumenId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'konsumen')

          req.scarlet.body.konsumenId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'mejaId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'meja')

          req.scarlet.body.mejaId = parseInt(value);
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
