function minimumBribes(q) {
  let num = 0;
  let chaotic = false;
  for (let i = q.length - 1; i >= 0; i--) {
    if (q[i] - i > 3) chaotic = true;
    for (let j = q[i] - 2; j < i; j++) {
      if (q[j] > q[i]) num++;
    }
  }
  if (chaotic) console.log("Too chaotic");
  else console.log(num);
}
console.log(minimumBribes([2, 5, 1, 3, 4]));
