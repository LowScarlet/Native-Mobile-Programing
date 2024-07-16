const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'pesanan';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'catatan',
    'jumlahTotal',
    'tanggal',
    'konsumenId',
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
      index: 'catatan',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseFloat(x),
      index: 'jumlahTotal',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'tanggal',
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
  };

  const input = (x) => generateValidationObject(x, inputField, model)

  return { input, model }
  // *** //
};

module.exports = {
  table,
  ModelSchema,
};
