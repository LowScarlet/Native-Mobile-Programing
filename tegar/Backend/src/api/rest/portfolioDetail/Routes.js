const { Router } = require('express');

const { create, getAll, getById, update, remove } = require("../../utils/crud");
const { table, ModelSchema } = require('./Validators');
const { CreateValidator, ReadValidator, UpdateValidator, DeleteValidator } = require('../../utils/Validators');

const router = Router();

router.post('/', [
  CreateValidator(ModelSchema)
], async (req, res, next) => {
  try {
    const { scarlet } = req;
    const { body } = scarlet;

    const data = await create(table, body);

    res.json(data);
  } catch (err) {
    next(err);
  }
});

router.get('/', [
  //
], async (req, res, next) => {
  try {
    const data = await getAll(table);

    res.json(data);
  } catch (err) {
    next(err);
  }
});

router.get('/:id', [
  ReadValidator(ModelSchema)
], async (req, res, next) => {
  try {
    const { scarlet } = req;
    const { params } = scarlet;
    const { id } = params;

    const data = await getById(table, id);

    res.json(data);
  } catch (err) {
    next(err);
  }
});

router.put('/:id', [
  ReadValidator(ModelSchema),
  UpdateValidator(ModelSchema)
], async (req, res, next) => {
  try {
    const { scarlet } = req;
    const { body, params } = scarlet;
    const { id } = params;

    const data = await update(table, id, body);

    res.json(data);
  } catch (err) {
    next(err);
  }
});

router.delete('/:id', [
  ReadValidator(ModelSchema),
  DeleteValidator(ModelSchema)
], async (req, res, next) => {
  try {
    const { scarlet } = req;
    const { params } = scarlet;
    const { id } = params;

    const data = await remove(table, id);

    res.json(data);
  } catch (err) {
    next(err);
  }
});

module.exports = router;