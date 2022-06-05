const http = require("http");

// Despues de haber instalado el modulo 'npm install colors':
const colors = require("colors");

console.log("HTTP: ");
console.log("----------------------------------------------------------");

/* Cuando estamos creando un servidor, tenemos que recibir la informacion que estos 
navegadores o computadores me estan dando. Para eso la funcion tiene
un parametro llamado 'request' o solicitud, y otro 'response' para recibir la 
respuesta del mismo.  */

const handleServer = (request, response) => {
  response.writeHead(200, { "Content-type": "text.html" });
  response.write("<h1>Hola mundo desde Nodejs</h1>");
  response.end();
};

const server = http.createServer(handleServer);

// Iniciamos el server y le añadimos un callback .
server.listen(3000, () => console.log("Servidor en el puerto 3000".green));

// http
//   .createServer((request, response) => {
//     response.writeHead(200, { "Content-type": "text.html" });
//     response.write("<h1>Hola mundo desde Nodejs</h1>");
//     response.end();
//   })
//   .listen(3000);

console.log("\n");

module.exports = http;
