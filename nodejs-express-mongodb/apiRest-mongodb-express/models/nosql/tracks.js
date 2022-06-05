const mongoose = require("mongoose");
const mongooseDelete = require("mongoose-delete");

// Creamos el esquema o estructura
const TracksSchema = new mongoose.Schema(
  {
    name: { type: String },
    album: { type: String },
    cover: {
      type: String,
      validator: (req) => {
        return true;
      },
      message: "ERROR_URL",
    },
    artist: {
      name: { type: String },
      nickname: { type: String },
      nationality: { type: String },
    },
    duration: {
      start: { type: Number },
      end: { type: Number },
    },
    mediaId: { type: mongoose.Types.ObjectId },
  },
  {
    timestamps: true, // Nos va a registrar el 'createdAt' y 'updateAt'
    versionKey: false,
  }
);

// Para poder utilizar el soft delete.
TracksSchema.plugin(mongooseDelete, { overrideMethods: "all" });

/* Exportamos un modelo de mongoose. El primer parametro es el nombre de la coleccion
o tabla que va a manejar el segundo parametro que seria el esquema o estructura. */
module.exports = mongoose.model("tracks", TracksSchema);
