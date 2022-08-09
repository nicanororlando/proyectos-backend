// En el controlador voy a tener la logica de mi aplicacion.

const { matchedData } = require("express-validator");
const { usersModel } = require("../models");
const { handleHttpError } = require("../utils/handleError");
const { encrypt, compare } = require("../utils/handlePassword");
const { tokenSign } = require("../utils/handleJwt");

// Insertar registro
const registrerController = async (req, res) => {
  try {
    console.log(req.body);
    req = matchedData(req);
    const passwordHash = await encrypt(req.password);

    // Creo o mas bien sobreescribo la contraseña que esta en nuestro cuerpo.
    const body = {
      ...req,
      password: passwordHash,
    };

    /* El 'create' Devuelve una promesa desde el instanciamiento de la conexion de la 
  db. En resumen devuelve literalmente lo que la base de datos devuelve. 
    Entonces, para que no se vea el password en la respuesta de la base de datos,
  nosotros mismos tenemos que setearla a indefinido, pero obvio que no cambiamos nada
  dentro de la base de datos. */
    const dataUser = await usersModel.create(body);
    dataUser.set("password", undefined, { strict: false });

    const data = {
      token: await tokenSign(dataUser),
      user: dataUser,
    };

    res.send({ data });
  } catch (error) {
    handleHttpError(res, { registrerController: error });
  }
};

const loginController = async (req, res) => {
  try {
    req = matchedData(req);

    // select para que podamos obtener el password ya que esta oculto por nosotros.
    const user = await usersModel.findOne({ email: req.email });
    // .select("password name role email"); // No funciona en mysql
    if (!user) {
      handleHttpError(res, "USER_NOT_EXIST", 404);
      return;
    }
    const hashPassword = user.get("password");

    const check = await compare(req.password, hashPassword);
    if (!check) {
      handleHttpError(res, "PASSWORD_INCORRECT", 401);
      return;
    }

    user.set("password", undefined, { strict: false });
    const data = {
      token: await tokenSign(user),
      user,
    };

    res.send({ data });
  } catch (error) {
    handleHttpError(res, "ERROR_LOGIN");
  }
};

module.exports = { registrerController, loginController };
