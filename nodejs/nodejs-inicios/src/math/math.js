const add = (x1, x2) => {
  return x1 + x2;
};
const substract = (x1, x2) => {
  return x1 - x2;
};
const multiply = (x1, x2) => {
  return x1 * x2;
};
const divide = (x1, x2) => {
  if (x2 == 0) console.log("No se puede dividir por 0");
  else return x1 / x2;
};

exports.add = add;
exports.substract = substract;
exports.multiply = multiply;
exports.divide = divide;
