const express = require("express");
const {
  getItems,
  getItem,
  createItem,
  updateItem,
  deleteItem,
} = require("../controllers/tracks");
const customHeader = require("../middlewares/customHeader");
const {
  validatorCreateItem,
  validatorGetItem,
} = require("../validators/tracks");
const router = express.Router();

// http://localhost:3000/api/tracks

// Obtener items:
router.get("/", getItems);

// Obtener item:
router.get("/:id", validatorGetItem, getItem);

// Crear item:
router.post("/", validatorCreateItem, createItem);

// Actualizar item:
router.put("/:id", validatorGetItem, validatorCreateItem, updateItem);

// Borrar item:
router.delete("/:id", validatorGetItem, deleteItem);

module.exports = router;
