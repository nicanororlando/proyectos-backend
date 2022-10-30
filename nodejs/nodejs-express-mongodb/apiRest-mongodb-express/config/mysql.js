const { Sequelize } = require("sequelize");

// https://www.youtube.com/watch?v=CRwGhVFSfwQ&list=PL_8FSlpwPBDkcBeEdgZ4e-RYUGvIA3LNI&index=3

const database = process.env.MYSQL_DATABASE;
const username = process.env.MYSQL_USERNAME;
const password = process.env.MYSQL_PASSWORD;
const host = process.env.MYSQL_HOST;

const sequelize = new Sequelize(database, username, password, {
  host,
  dialect: "mysql",
});

const dbConnectMySql = async () => {
  try {
    await sequelize.authenticate();
    console.log("MYSQL: Conexion correcta.");
  } catch (error) {
    console.log("MYSQL: Error de conexión.", error);
  }
};

module.exports = { sequelize, dbConnectMySql };
