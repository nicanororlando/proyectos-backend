/*
 * Complete the 'jumpingOnClouds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY c as parameter.
 */
const cloudsJumpElement = document.createElement("P");

function jumpingOnClouds(clouds) {
  let count = 0;
  for (let i = 0; i < clouds.length; i++) {
    // 000 | 010
    if (clouds[i] == 0 && clouds[i + 2] == 0) {
      i += 1;
      count++;
    }
    // 001
    else if (clouds[i] == 0 && clouds[i + 1] == 0) count++;
    // console.log(i);
  }
  return count;
}

cloudsJumpElement.innerHTML =
  "Ej3: Jumping clouds '0010010' -> " + jumpingOnClouds("0010010");
results.appendChild(cloudsJumpElement);
