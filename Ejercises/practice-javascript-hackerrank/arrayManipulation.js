function arrayManipulation(n, queries) {
  let newArray = new Array(n);
  newArray.fill(0).map((e) => parseInt(e));

  // let newArray = '0'.repeat(n).split('').map((e) => parseInt(e));

  // let newArray = [];
  // for(let k=0;k<n;k++){
  //     newArray.push(0);
  // }

  for (let i = 0; i < queries.length; i++) {
    let startIndex = queries[i][0] - 1;
    let endIndex = queries[i][1] - 1;
    let numberToAdd = queries[i][2];

    for (let j = startIndex; j <= endIndex; j++) {
      newArray[j] += numberToAdd;
    }
  }
  return Math.max(...newArray);
}

function arrayManipulationOptimzied(n, queries) {
  const arr = Array(n + 1);
  let maxValue = 0,
    currentNumber = 0;
  queries.forEach(([startRange, endRange, value]) => {
    arr[startRange] = arr[startRange] || { start: 0, end: 0 };
    arr[endRange] = arr[endRange] || { start: 0, end: 0 };
    arr[startRange].start += value;
    arr[endRange].end += value;
  });
  arr.forEach((cell) => {
    if (cell) {
      currentNumber += cell.start;
      if (currentNumber > maxValue) {
        maxValue = currentNumber;
      }
      currentNumber -= cell.end;
    }
  });
  return maxValue;
}

// We have to make a 'n' large value
const n = 10;
// Given this array
const queries = [
  [1, 5, 3],
  [4, 8, 7],
  [6, 9, 1],
];

console.log(arrayManipulation(n, queries));
console.log(arrayManipulationOptimzied(n, queries));
