function minimumSwaps(arr) {
  let cantSwaps = 0;

  for (let i = 0; i < arr.length - 1; i++) {
    let swap = false;
    let min = arr[i];
    let minIndex = i;

    for (let j = i + 1; j < arr.length; j++) {
      if (min > arr[j]) {
        min = arr[j];
        minIndex = j;
        swap = true;
      }
    }
    if (swap) {
      // This makes our programm going slower:
      // const index = arr.indexOf(min);

      const temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;

      cantSwaps++;
    }
  }
  return cantSwaps;
}

console.log(minimumSwaps([1, 3, 5, 2, 4, 6, 7]));
