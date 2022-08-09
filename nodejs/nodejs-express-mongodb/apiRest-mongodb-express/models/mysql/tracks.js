const { sequelize } = require("../../config/mysql");
const { DataTypes } = require("sequelize");
const Storage = require("./storage");

// Definimos nuestro modelo:
const Tracks = sequelize.define(
  "tracks", // Nombre de la tabla y los siguientes son los campos de la tabla.
  {
    name: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    album: {
      type: DataTypes.STRING,
    },
    cover: {
      type: DataTypes.STRING,
    },
    password: {
      type: DataTypes.STRING,
    },
    artist_name: {
      type: DataTypes.STRING,
    },
    artist_nickname: {
      type: DataTypes.STRING,
    },
    artist_nationality: {
      type: DataTypes.STRING,
    },
    duration_start: {
      type: DataTypes.INTEGER,
    },
    duration_end: {
      type: DataTypes.INTEGER,
    },
    mediaId: {
      type: DataTypes.STRING,
    },
  },
  // Y para las configuraciones:
  {
    timestamps: true, // Para que la tabla tenga el createdAt y updatedAt
  }
);

Tracks.findAllData = function () {
  // Creo la relacion entre los tracks y storage que coinciden con el mediaId.
  Tracks.belongsTo(Storage, {
    foreignKey: "mediaId",
    as: "audio",
  });

  // Retornamos el metodo nativo de sequelize, que incluye en la busqueda la relacion.
  return Tracks.findAll({ include: Storage });
};

Tracks.findOneData = function (id) {
  // Creo la relacion entre los tracks y storage que coinciden con el mediaId.
  Tracks.belongsTo(Storage, {
    foreignKey: "mediaId",
    as: "audio",
  });

  // Retornamos el metodo nativo de sequelize, que incluye en la busqueda la relacion.
  return Tracks.findOne({ where: { id }, include: "audio" });
};

module.exports = Tracks;
