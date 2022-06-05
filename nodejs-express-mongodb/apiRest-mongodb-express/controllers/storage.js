// En el controlador voy a tener la logica de mi aplicacion.

const fs = require("fs");
const { matchedData } = require("express-validator");
const { storageModel } = require("../models");
const { handleHttpError } = require("../utils/handleError");

const PUBLIC_URL = process.env.PUBLIC_URL;
const MEDIA_PATH = `${__dirname}/../storage`;

// Obtener la lista de la base de datos
const getItems = async (req, res) => {
  try {
    // En mongo la funcion find buscca todo lo que esta en el modelo.
    const data = await storageModel.find({});
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { getItems: error });
  }
};

// Obtener un detalle
const getItem = async (req, res) => {
  try {
    const { id } = matchedData(req);
    const data = await storageModel.findById(id);
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { getItem: error });
  }
};

// Insertar registro
const createItem = async (req, res) => {
  try {
    const { body, file } = req;
    console.log(body, file);

    const fileData = {
      filename: file.filename,
      url: `${PUBLIC_URL}/${file.filename}`,
    };

    // Mandamos los datos del body a la base de datos:
    const data = await storageModel.create(fileData);
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { create: error });
  }
};

// Eliminar registro
const deleteItem = async (req, res) => {
  try {
    const { id } = matchedData(req);
    const dataFile = await storageModel.findById(id);

    await storageModel.delete({ _id: id }); // Hacemos un soft delete

    const { filename } = dataFile;
    const filePath = `${MEDIA_PATH}/${filename}`;

    // De esta manera y con el metodo deleteOne, lo eliminariamos por completo.
    // fs.unlinkSync(filePath); // Para que elimine el registro fisico del path.

    const data = {
      filePath,
      deleted: 1,
    };
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { getItems: error });
  }
};

module.exports = { getItems, getItem, createItem, deleteItem };
