function generateValidationObject(isOptional, params, model) {
  const validationObject = {};

  params.forEach(param => {
    validationObject[param] = {
      ...model[param],
      ...(isOptional ? { optional: true } : { notEmpty: { errorMessage: 'validations.required' }})
    };
  });

  return validationObject;
}

module.exports = generateValidationObject;