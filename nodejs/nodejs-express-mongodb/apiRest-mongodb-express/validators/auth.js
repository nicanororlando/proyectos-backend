const { check } = require("express-validator");
const validateResults = require("../utils/handleValidator");

const validatorRegistrerItem = [
  check("name").exists().notEmpty().isLength({ min: 3, max: 99 }),
  check("age").exists().notEmpty().isNumeric(),
  check("email").exists().notEmpty().isEmail(),
  check("password").exists().notEmpty().isLength({ min: 4, max: 20 }),
  (req, res, next) => validateResults(req, res, next),
];

const validatorLoginItem = [
  check("email").exists().notEmpty().isEmail(),
  check("password").exists().notEmpty().isLength({ min: 4, max: 20 }),
  (req, res, next) => validateResults(req, res, next),
];

module.exports = { validatorRegistrerItem, validatorLoginItem };
