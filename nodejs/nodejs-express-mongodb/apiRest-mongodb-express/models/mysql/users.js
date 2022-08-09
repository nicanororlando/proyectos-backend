const { sequelize } = require("../../config/mysql");
const { DataTypes } = require("sequelize");

// Definimos nuestro modelo:
const Users = sequelize.define(
  "users", // Nombre de la tabla y los siguientes son los campos de la tabla.
  {
    name: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    age: {
      type: DataTypes.NUMBER,
    },
    email: {
      type: DataTypes.STRING,
    },
    password: {
      type: DataTypes.STRING,
    },
    role: {
      type: DataTypes.ENUM(["user", "admin"]),
    },
  },
  // Y para las configuraciones:
  {
    timestamps: true, // Para que la tabla tenga el createdAt y updatedAt
  }
);

module.exports = Users;
