const db = require("./database");

const isModelHasRelation = async (value, mainModel, targetModel) => {
  const customParam = {
    where: { id: parseInt(value) }, select: {
      [targetModel]: true
    }
  }

  const main = await db[mainModel].findUnique(customParam);

  if (!main) throw new Error('validations.model.data-not-found');
  if (main[targetModel]) throw new Error('validations.model.data-has-relation');
}

const isModelFound = async (value, mainModel) => {
  const customParam = {
    where: { id: parseInt(value) }
  }

  const main = await db[mainModel].findUnique(customParam);

  if (!main) throw new Error('validations.model.data-not-found');
}

const ValidateSchemaDefault = ({ index, changeValue, checkIn, other }) => ({
  [index]: {
    in: checkIn,
    custom: {
      options: async (value, { req }) => {
        for (let i = 0; i < checkIn.length; i += 1) {
          req.scarlet[checkIn[i]] = req.scarlet[checkIn[i]] || {};
          req.scarlet[checkIn[i]][index] = changeValue ? changeValue(value) : value;
        }
      }
    },
    ...other
  }
});

const ValidateSchemaModel = ({ index, errorIf, changeValue, checkIn, dbModel, other }) => ({
  [index]: {
    in: checkIn,
    custom: {
      options: async (value, { req }) => {
        const model = await dbModel.findUnique({ where: { [index]: changeValue ? changeValue(value) : value } });
        if (errorIf === 'notExist') {
          if (!model) throw new Error('validations.model.data-not-found');
        } else if (errorIf === 'exist') {
          if (model) throw new Error('validations.model.data-found');
        }
        for (let i = 0; i < checkIn.length; i += 1) {
          req.scarlet[checkIn[i]] = req.scarlet[checkIn[i]] || {};
          req.scarlet[checkIn[i]][index] = changeValue ? changeValue(value) : value;
        }
      }
    },
    ...other
  }
});

const ValidateSchemaCustom = ({ index, checkIn, custom, other }) => ({
  [index]: {
    in: checkIn,
    custom,
    ...other
  }
});

module.exports = {
  isModelFound,
  isModelHasRelation,
  ValidateSchemaDefault,
  ValidateSchemaModel,
  ValidateSchemaCustom
};
