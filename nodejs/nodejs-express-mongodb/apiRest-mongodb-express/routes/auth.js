const express = require("express");
const { registrerController, loginController } = require("../controllers/auth");
const {
  validatorLoginItem,
  validatorRegistrerItem,
} = require("../validators/auth");
const router = express.Router();

// http://localhost:3001/api/auth/register
router.post("/register", validatorRegistrerItem, registrerController);
  
// http://localhost:3001/api/auth/login
router.post("/login", validatorLoginItem, loginController);

module.exports = router;
