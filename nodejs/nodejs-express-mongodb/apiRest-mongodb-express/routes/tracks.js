const express = require("express");
const {
  getItems,
  getItem,
  createItem,
  updateItem,
  deleteItem,
} = require("../controllers/tracks");
const customHeader = require("../middlewares/customHeader");
const checkRol = require("../middlewares/rol");
const authMiddleware = require("../middlewares/session");
const {
  validatorCreateItem,
  validatorGetItem,
} = require("../validators/tracks");
const router = express.Router();

// http://localhost:3001/api/tracks

// Obtener items:
router.get("/", authMiddleware, getItems);

// Obtener item:
router.get("/:id", authMiddleware, validatorGetItem, getItem);

// Crear item:
router.post(
  "/",
  authMiddleware,
  // checkRol(["admin", "user"]),
  validatorCreateItem,
  createItem
);

// Actualizar item:
router.put(
  "/:id",
  authMiddleware,
  validatorGetItem,
  validatorCreateItem,
  updateItem
);

// Borrar item:
router.delete("/:id", authMiddleware, validatorGetItem, deleteItem);

module.exports = router;
