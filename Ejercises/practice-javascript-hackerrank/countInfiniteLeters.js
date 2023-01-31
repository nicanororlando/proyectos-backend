/*
 * Complete the 'repeatedString' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. LONG_INTEGER n
 */

// s.length --->  3
// n        --->  10
function repeatedString(s, n) {
  let a = 0;
  const k = s.length; // Array length

  if (n >= k) {
    for (const letter of s) {
      if (letter === "a") a++;
    }

    a *= Math.floor(n / k);
  }

  console.log(n % k);
  for (let i = 0; i < n % k; i++) {
    if (s[i] === "a") a++;
  }

  return a;
}

console.log(repeatedString("a", 1000000000000));
