const bcryptjs = require("bcryptjs");

/**
 * Esto toma el texto plano y transformarlo en un hash dinamico
 * @param {*} passwordPlain
 * @returns
 */
const encrypt = async (passwordPlain) => {
  // Version encriptada de un string, en este caso de la contraseña:
  const hash = await bcryptjs.hash(passwordPlain, 10);
  return hash;
};

/**
 * Para tomar el hash y el texto plano y compararlos para identificar la clave.
 * @param {*} passwordPlain
 * @param {*} hashPassword
 */
const compare = async (passwordPlain, hashPassword) => {
  return await bcryptjs.compare(passwordPlain, hashPassword);
};

module.exports = { encrypt, compare };
