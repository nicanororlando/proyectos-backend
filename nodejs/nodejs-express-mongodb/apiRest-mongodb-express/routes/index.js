const express = require("express");
const fs = require("fs");
const router = express.Router();

const PATH_ROUTES = __dirname; // Nos da la ruta donde se encuentra la carpeta routes.

const removeExtension = (filename) => {
  // Si el filename es por ej 'tracks.js':
  // split separa los elementos donde haya un punto (en este caso). [track, js]
  // shift retorna el primer valor del array. [tracks]
  return filename.split(".").shift();
};

// Retorna un array con los nombres de los archivos dentro de routes.
fs.readdirSync(PATH_ROUTES).filter((file) => {
  const name = removeExtension(file); // index, storage, tracks, users
  if (name !== "index") {
    router.use(`/${name}`, require(`./${file}`));
  }
});

module.exports = router;
