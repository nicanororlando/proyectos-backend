// Mongo es nuestro motor de base de datos no relacional.

const mongoose = require("mongoose");

const dbConnectMongoDB = () => {
  const DB_URI = process.env.DB_URI;

  // Crea una conexion hacia la base de datos
  mongoose.connect(
    DB_URI,
    {
      useNewUrlParser: true,
      useUnifiedTopology: true,
    },
    (err, res) => {
      if (!err) console.log("Conexion correcta");
      else console.log("Error de conexion");
    }
  );
};

module.exports = dbConnectMongoDB;
