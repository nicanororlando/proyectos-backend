// Math es un objeto va a contener multiples propiedades, donde cada una va a ser una funcion.
const math = require("./math.js");

console.log("\n");
console.log("Math: ");
console.log("----------------------------------------------------------");
console.log("2 + 3: " + math.add(2, 3));
console.log("2 - 3: " + math.substract(2, 3));
console.log("2 * 3: " + math.multiply(2, 3));
console.log("2 / 3: " + math.divide(2, 3));
console.log("2 / 0: " + math.divide(2, 0));
console.log("\n");

module.exports = math;
