// Este modulo nos va a permitir trabajar con informacion del sistema operativo.
const os = require("os");

console.log("Operating system: ");
console.log("----------------------------------------------------------");
console.log("Sistema operativo: " + os.platform());
console.log("Release: " + os.release());
console.log("Memoria libre: " + os.freemem() / 1073741824 + " gigabytes");
console.log("Memoria total: " + os.totalmem() / 1073741824 + " gigabytes");
console.log("\n");

module.exports = os;
