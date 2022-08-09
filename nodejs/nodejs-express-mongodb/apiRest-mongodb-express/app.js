require("dotenv").config(); // Para que mi app use las variables de entorno '.env'.
const express = require("express");
const cors = require("cors");
const dbConnectMongoDB = require("./config/mongo");
const { dbConnectMySql } = require("./config/mysql");

const morganBody = require("morgan-body");
const loggerStream = require("./utils/handleLogger");

const ENGINE_DB = process.env.ENGINE_DB;
const PORT = process.env.PORT || 3000;
const app = express();

morganBody(app, {
  noColors: true,
  stream: loggerStream,
  skip: function (req, res) {
    // Omite los mensajes que tengan status menor a 400, para que solo muestre errores.
    return res.statusCode < 400;
  },
});

// Para no tener problemas con los cors.
app.use(cors());

// Para que reconozca archivos JSON.
app.use(express.json());

// Para que los recursos estaticos los saque de la carpeta storage.
app.use(express.static("storage"));

app.use("/api", require("./routes"));

app.listen(PORT, () => {
  console.log(`Server on http://localhost:${PORT}`);
});

ENGINE_DB === "nosql" ? dbConnectMongoDB() : dbConnectMySql();
