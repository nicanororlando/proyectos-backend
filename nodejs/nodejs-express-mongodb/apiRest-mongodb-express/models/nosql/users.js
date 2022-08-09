const mongoose = require("mongoose");
const mongooseDelete = require("mongoose-delete");

// Creamos el esquema o estructura
const UserSchema = new mongoose.Schema(
  {
    name: { type: String },
    age: { type: Number },
    email: { type: String, unique: true },
    password: { type: String, select: false }, // Para ocultar la informacion
    role: { type: ["user", "admin "], default: "user" },
  },
  {
    timestamps: true, // Nos va a registrar el 'createdAt' y 'updateAt'
    versionKey: false,
  }
);

// Para poder utilizar el soft delete.
UserSchema.plugin(mongooseDelete, { overrideMethods: "all" });

/* Exportamos un modelo de mongoose. El primer parametro es el nombre de la coleccion
o tabla que va a manejar el segundo parametro que seria el esquema o estructura. */
module.exports = mongoose.model("users", UserSchema);
