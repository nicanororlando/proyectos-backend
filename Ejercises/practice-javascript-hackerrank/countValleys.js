/*
 * Complete the 'countingValleys' function below.
 * We have to count how many times the hiker has passed through the valley.
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */
// 0 = _
// > 0 /
// < 0 \

// _/\      _
//    \    /
//     \/\/

const countingValleysElement = document.createElement("P");

function countingValleys(steps, path) {
  let height = 0;
  let countValleys = 0;

  for (let i = 1; i < steps; i++) {
    if (path[i] == "D") {
      if (height == 0) countValleys++;

      height--;
    }
    if (path[i] == "U") {
      height++;
    }
  }

  return countValleys;
}

countingValleysElement.innerHTML =
  "Ej2: Count valleys for 'UDDDUDUU' => " + countingValleys(8, "UDDDUDUU");

results.appendChild(countingValleysElement);
