const customHeader = (req, res, next) => {
  try {
    const apiKey = req.headers.api_key;
    if (apiKey === "leifer-01") next();
    else throw "Api Key no es correcta";
  } catch (error) {
    res.status(403);
    res.send({ error: error });
  }
};

module.exports = customHeader;
