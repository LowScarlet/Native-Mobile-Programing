const { ValidateSchemaModel, ValidateSchemaDefault, ValidateSchemaCustom } = require('../../utils/ValidateSchema');
const db = require('../../utils/database');
const generateValidationObject = require('../../utils/generateValidationObject');

const table = 'penulis';

const ModelSchema = (options) => {
  const { checkIn, errorIf } = options;
  const configSchema = { checkIn, errorIf, dbModel: db[table] };

  const inputField = [
    'kode',
    'nama',
    'tanggalLahir',
    'biografi',
    'kewarganegaraan',
    'penghargaan',
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
      index: 'tanggalLahir',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'biografi',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'kewarganegaraan',
    }),

    ...ValidateSchemaDefault({
      ...configSchema,
      index: 'penghargaan',
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
