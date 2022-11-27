// Example: Is given a Two letter subfix, we have to fetch a JSON and retrieve the name of the country which machs
// with the given subfix.
async function getCountryName(country) {
  let page = 1;
  do {
    let response = await fetch(
      "https://jsonmock.hackerrank.com/api/countries?page=" + page
    );
    let data = await response.text();
    let countries = JSON.parse(data);

    for (let i = 0; i < countries.per_page; i++) {
      if (countries.data[i].alpha2Code == country)
        return countries.data[i].name;
    }

    page++;
  } while (page < 20);
}

(async () => {
  const countryName = await getCountryName("AF");
  console.log(countryName);
})();
