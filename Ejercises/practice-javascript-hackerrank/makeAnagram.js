const makeAnagram = () => {
  let map = {},
    aCount = 0,
    bCount = 0;
  for (let i = 0; i < a.length; i++) {
    if (!map[a[i]]) map[a[i]] = 1;
    else map[a[i]]++;
  }
  for (let j = 0; j < b.length; j++) {
    if (map[b[j]]) {
      map[b[j]]--;
      aCount++;
    } else bCount++;
  }
  return a.length - aCount + bCount;
};

makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
