/*
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

const socksElement = document.createElement("P");

function sockMerchant(n, ar) {
  let sorted = ar.sort();
  let pairs = 0;
  for (let i = 0; i < n; i++) {
    if (sorted[i] == sorted[i + 1]) {
      i += 1;
      pairs++;
    }
  }
  return pairs;
}

const ar = [10, 20, 20, 10, 10, 30, 50, 10, 20];
const resultSocks = sockMerchant(ar.length, ar);

socksElement.innerHTML = "Ej1: Number of pairs => " + resultSocks;

results.appendChild(socksElement);
