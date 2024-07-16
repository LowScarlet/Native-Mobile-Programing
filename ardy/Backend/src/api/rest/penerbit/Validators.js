const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'penerbit';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'kode',
    'nama',
    'lokasi',
    'tahunBerdiri',
    'emailKontak',
    'nomorTelepon',
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

    ...ValidateSchemaModel({
      ...configSchema,
      index: 'nama',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'lokasi',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      changeValue: (x) => parseInt(x, 10),
      index: 'tahunBerdiri',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'emailKontak',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'nomorTelepon',
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
