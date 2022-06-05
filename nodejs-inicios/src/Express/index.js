const express = require("express");
require("colors");

const server = express();

server.get("/", (req, res) => {
  res.send("<h1>Hola mundo con Express y node.</h1>");
  res.end(); // No es necesario en este caso igual.
});

server.listen(3000, () => console.log("Server on port 3000".red));
