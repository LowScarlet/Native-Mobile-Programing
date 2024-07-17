const { ValidateSchemaModel, ValidateSchemaCustom, ValidateSchemaDefault, isModelFound } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'stok';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'jumlah',
    'kategoriId',
  ];

  const model = {
    ...ValidateSchemaModel({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'id',
    }),

    ...ValidateSchemaCustom({
      ...configSchema,
      index: 'kategoriId',
      custom: {
        options: async (value, { req }) => {
          await isModelFound(value, 'kategori');

          req.scarlet.body.kategoriId = parseInt(value);
        },
      },
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'jumlah',
    }),
  };

  const input = (x) => generateValidationObject(x, inputField, model);

  return { input, model };
};

module.exports = {
  table,
  ModelSchema,
};
