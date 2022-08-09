const { sequelize } = require("../../config/mysql");
const { DataTypes } = require("sequelize");

// Definimos nuestro modelo:
const Storage = sequelize.define(
  "storage", // Nombre de la tabla y los siguientes son los campos de la tabla.
  {
    url: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    filename: {
      type: DataTypes.STRING,
    },
  },
  // Y para las configuraciones:
  {
    timestamps: true, // Para que la tabla tenga el createdAt y updatedAt
  }
);

module.exports = Storage;
