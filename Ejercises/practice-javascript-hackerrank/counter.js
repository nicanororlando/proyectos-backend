const counter = (function counter() {
  let value = 0;
  return {
    getValue: function () {
      return value;
    },
    changeBy: function (k) {
      value += k;
    },
  };
})();
function getFixedCounter(k) {
  let myCounter = counter;
  return {
    increment: () => {
      myCounter.changeBy(k);
    },
    decrement: () => {
      myCounter.changeBy(-k);
    },
    getValue: () => {
      return myCounter.getValue();
    },
  };
}
function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  const val = parseInt(readLine().trim());

  const c = getFixedCounter(val);
  assert(!("changeBy" in c));

  const n = parseInt(readLine().trim());
  for (let i = 0; i < n; ++i) {
    const op = readLine().trim();
    if (op == "+") {
      c.increment();
    } else if (op == "-") {
      c.decrement();
    } else if (op === "?") {
      ws.write(`${c.getValue()}\n`);
    }
  }
  ws.end();
}

// input
// 1 4 + ? - ?
// output
// 1 0
