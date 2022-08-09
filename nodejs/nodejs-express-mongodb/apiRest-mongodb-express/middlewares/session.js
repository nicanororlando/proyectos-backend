const { usersModel } = require("../models");
const { handleHttpError } = require("../utils/handleError");
const { verifyToken } = require("../utils/handleJwt");
const getProperties = require("../utils/handlePropertiesEngine");
const propertiesKey = getProperties();

const authMiddleware = async (req, res, next) => {
  try {
    if (!req.headers.authorization) {
      handleHttpError(res, "NEED_SESSION", 401);
      return;
    }

    // Divide la cadena por un espacio y obtiene el ultimo valor del array (token).
    const token = req.headers.authorization.split(" ").pop();
    const dataToken = await verifyToken(token);

    if (!dataToken) {
      handleHttpError(res, "NOT_PAYLOAD_DATA ", 401);
      return;
    }

    const query = {
      [propertiesKey.id]: dataToken[propertiesKey.id],
    };

    /* El metodo 'findById' es solo de mongo, por eso tenemos que usar otro metodo
    que coincida tanto en mongo como en mysql. */
    // const user = await usersModel.findById(dataToken._id);
    // const user = await usersModel.findOne({id: _id});
    const user = await usersModel.findOne(query);

    /* Inyecto una propiedad 'user' a la peticion. De esta manera puedo acceder desde
    el controlador de tracks, al usuario que ingreso. */
    req.user = user;

    next();
  } catch (error) {
    handleHttpError(res, "NOT_SESSION", 401);
  }
};

module.exports = authMiddleware;
