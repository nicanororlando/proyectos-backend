// Este modulo nos permite trabajar con los ARCHIVOS del sistema operativo.
const fs = require("fs");

console.log("Files system.");
console.log("----------------------------------------------------------");
/* Fnc para crear un archivo: Recibe tres params: 1. Nombre y direccion para crear 
el archivo, 2. Contenido, 3. Callback (Funcion que se ejecuta cuando termino el proceso
anterior, en este caso cuando termina de crear el archivo) que sirve para cuando 
ocurra un error. Esta funcion es asincrona, es decir, node se va a tratar de dar las 
instrucciones para crear un archivo. El sistema operativo se va a encargar de 
crearlo en realidad, y mientras se crea, node va a seguir ejecutando las siguientes
lineas fuera de la funcion, y cuando se termine de crear el archivo, recien ahi se va
a ejecutar la funcion interna o 'callback' del fs.writefile, ya que es asincrono. */
fs.writeFile(
  "./src/FilesSystem/Texto.txt",
  "Linea uno del archivo Texto.txt",
  (err) => {
    if (err) console.log(err);
    else console.log("Archivo de files system creado.");
  }
);

fs.readFile("./src/FilesSystem/Texto.txt", (err, data) => {
  if (err) console.log(err);
  if (data) console.log(data.toString());
  console.log("\n");
});

module.exports = fs;
