const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'itemPesanan';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'kuantitas',
    'catatan',
    'pesananId',
    'menuId',
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
      changeValue: (x) => parseInt(x, 10),
      index: 'kuantitas',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'catatan',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'pesananId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'pesanan')

          req.scarlet.body.pesananId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'menuId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'menu')

          req.scarlet.body.menuId = parseInt(value);
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
