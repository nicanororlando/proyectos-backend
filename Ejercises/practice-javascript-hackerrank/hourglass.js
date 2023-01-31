const resultHourglass = document.createElement("P");

function hourglassSum(arr) {
  let maxSum;
  let sum;
  for (let i = 0; i < arr.length - 2; i++) {
    for (let j = 0; j < arr.length - 2; j++) {
      sum =
        arr[i][j] +
        arr[i][j + 1] +
        arr[i][j + 2] +
        arr[i + 1][j + 1] +
        arr[i + 2][j] +
        arr[i + 2][j + 1] +
        arr[i + 2][j + 2];

      if ((i == 0 && j == 0) || sum > maxSum) {
        maxSum = sum;
      }
      console.log(i, j);
    }
  }
  return maxSum;
}

let arr = [
  [1, 1, 1, 0, 0, 0],
  [0, 1, 0, 0, 0, 0],
  [1, 1, 1, 0, 0, 0],
  [0, 0, 2, 4, 4, 0],
  [0, 0, 0, 2, 0, 0],
  [0, 0, 1, 2, 4, 0],
];

resultHourglass.innerHTML = "Ej4: Hourglass max sum => " + hourglassSum[arr];

results.appendChild(resultHourglass);
