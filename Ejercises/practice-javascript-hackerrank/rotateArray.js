function rotLeft(a, d) {
  for (let i = 0; i < d; i++) {
    const first = a.shift();
    a.push(first);
  }
  return a;
}

console.log(rotLeft([1, 2, 3, 4, 5], 4));
