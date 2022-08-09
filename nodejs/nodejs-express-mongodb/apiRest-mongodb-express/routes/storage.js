const express = require("express");
const {
  createItem,
  getItems,
  getItem,
  deleteItem,
} = require("../controllers/storage");
const uploadMiddleware = require("../utils/handleStorage");
const { validatorGetItem } = require("../validators/storage");
const router = express.Router();

// http://localhost:3001/api/storage

router.get("/", getItems);

router.get("/:id", validatorGetItem, getItem);

/* Utilizamos el middleware agarrando un solo archivo, y le ponemos el nombre de la
propiedad en la cual viene el archivo (en este caso es "myfile"). */
router.post("/", uploadMiddleware.single("myfile"), createItem);

router.delete("/:id", validatorGetItem, deleteItem);

module.exports = router;
