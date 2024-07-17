const { checkSchema } = require("express-validator");
const SchemaValidatorHandler = require("./SchemaValidatorHandler");

function CreateValidator(ModelSchema) {
  const { input } = ModelSchema({ checkIn: ['body'], errorIf: 'exist' });

  return [
    SchemaValidatorHandler([checkSchema(input(false))])
  ];
}

function ReadValidator(ModelSchema) {
  const { model } = ModelSchema({ checkIn: ['params'], errorIf: 'notExist' });

  const input = {
    id: { ...model.id, exists: { errorMessage: 'validations.required', } }
  };

  return SchemaValidatorHandler([checkSchema(input)]);
}

function UpdateValidator(ModelSchema) {
  const { input } = ModelSchema({ checkIn: ['body'], errorIf: 'exist' });

  return [
    SchemaValidatorHandler([checkSchema(input(true))])
  ];
}

function DeleteValidator(ModelSchema) {
  return SchemaValidatorHandler([]);
}

module.exports = {
  CreateValidator,
  ReadValidator,
  UpdateValidator,
  DeleteValidator,
};