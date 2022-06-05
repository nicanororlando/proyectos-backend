require("dotenv").config(); // Para que mi app use las variables de entorno '.env'.
const express = require("express");
const cors = require("cors");
const dbConnect = require("./config/mongo");

const PORT = process.env.PORT || 3000;
const app = express();

// Para no tener problemas con los cors.
app.use(cors());

// Para que reconozca archivos JSON.
app.use(express.json());

// Para que los recursos estaticos los saque de la carpeta storage.
app.use(express.static("storage"));

app.use("/api", require("./routes"));

app.listen(PORT, () => {
  console.log(`Server on http://localhost:${PORT}`);
});

dbConnect();
