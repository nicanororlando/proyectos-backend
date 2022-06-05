const mongoose = require("mongoose");
const mongooseDelete = require("mongoose-delete");

// Creamos el esquema o estructura
const StorageSchema = new mongoose.Schema(
  {
    url: { type: String },
    filename: { type: String },
  },
  {
    timestamps: true, // Nos va a registrar el 'createdAt' y 'updateAt'
    versionKey: false,
  }
);

// Para poder utilizar el soft delete.
StorageSchema.plugin(mongooseDelete, { overrideMethods: "all" });

/* Exportamos un modelo de mongoose. El primer parametro es el nombre de la coleccion
o tabla que va a manejar el segundo parametro que seria el esquema o estructura. */
module.exports = mongoose.model("storage", StorageSchema);
