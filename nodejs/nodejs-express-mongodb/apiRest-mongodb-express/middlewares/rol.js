const { handleHttpError } = require("../utils/handleError");

/**
 * Array con los roles permitidos.
 * @param {*} rol
 * @returns
 */
const checkRol = (rol) => (req, res, next) => {
  try {
    const { user } = req; // Recuperamos el user que inyectamos en el anterior middleware.
    const rolesByUser = user.role;

    /* Devuelve 'true' si alguno de los permisos de 'rolesByUser' (osea los que tiene
    asignado ese usuario), coincide con los permisos definidos en 'rol'. */
    const checkValueRol = rol.some((rolSingle) =>
      rolesByUser.includes(rolSingle)
    );
    if (!checkValueRol) {
      handleHttpError(res, "USER_NOT_PERMISSIONS", 403);
      return;
    }

    next();
  } catch (error) {
    handleHttpError(res, "ERROR_PERMISSIONS", 403);
  }
};

module.exports = checkRol;
