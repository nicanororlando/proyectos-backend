// En el controlador voy a tener la logica de mi aplicacion.

const { matchedData } = require("express-validator");
const { tracksModel } = require("../models");
const { handleHttpError } = require("../utils/handleError");

// Obtener la lista de la base de datos
const getItems = async (req, res) => {
  try {
    // En mongo la funcion find buscca todo lo que esta en el modelo de Mongo.
    const data = await tracksModel.find({});
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { getItems: error });
  }
};

// Obtener un detalle
const getItem = async (req, res) => {
  try {
    bodyClean = matchedData(req);
    const { id } = bodyClean;

    // const { id } = req.params;

    const data = await tracksModel.findById(id);
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { getItem: error });
  }
};

// Insertar registro
const createItem = async (req, res) => {
  try {
    // const { body } = req;

    /* Es una funcion de exp-val que nos devuelve el objeto sin datos adicionales, 
    es decir, si alguien manda datos de mas, esta funcion los saca ya que no lo 
    queremos. Es un agregado a la validacion que esta antes. */
    bodyClean = matchedData(req);

    // Mandamos los datos del body a la base de datos de Mongo:
    const data = await tracksModel.create(bodyClean);
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { createItem: error });
  }
};

// Actualizar registro
const updateItem = async (req, res) => {
  try {
    const { id, ...body } = matchedData(req);
    // const { id } = req.params;

    /* Le mandamos a la base de datos el 'id' para hacer la busqueda, y luego el
    body para actualizar la informacion del item que coincida con el id que mandamos.  */
    const data = await tracksModel.findOneAndUpdate(id, body);
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { updateItem: error });
  }
};

// Eliminar registro
const deleteItem = async (req, res) => {
  try {
    // bodyClean = matchedData(req);
    // const { id } = bodyClean;

    const { id } = req.params;

    // const data = await tracksModel.deleteOne({ _id: id }); // Elimina de todos lados
    const data = await tracksModel.delete({ _id: id });
    res.send({ data });
  } catch (error) {
    handleHttpError(res, { deleteItem: error });
  }
};

module.exports = { getItems, getItem, createItem, updateItem, deleteItem };
