const db = require('./database');

const create = async (model, data) => {
  return db[model].create({ data });
};

const getAll = async (model) => {
  return db[model].findMany();
};

const getById = async (model, id) => {
  return db[model].findUnique({ where: { id: Number(id) } });
};

const update = async (model, id, data) => {
  return db[model].update({
    where: { id: Number(id) },
    data,
  });
};

const remove = async (model, id) => {
  return db[model].delete({ where: { id: Number(id) } });
};

module.exports = {
  create,
  getAll,
  getById,
  update,
  remove,
};
