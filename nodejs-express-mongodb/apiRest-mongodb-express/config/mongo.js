const mongoose = require("mongoose");

const dbConnect = () => {
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

module.exports = dbConnect;
