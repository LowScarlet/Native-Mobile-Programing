const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom, isModelFound, isModelHasRelation } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'pengantaran';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'tanggal',
    'status',
    'karyawanId',
    'pemesananId',
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
      index: 'status',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'karyawanId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'karyawan')

          req.scarlet.body.karyawanId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'pemesananId',
      custom: {
        options: async (value, { req }) => {
          await isModelHasRelation(value, 'pemesanan', 'pengantaran')

          req.scarlet.body.pemesananId = parseInt(value);
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
