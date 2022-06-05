const multer = require("multer");

/* Multer utiliza el storage como un Middleware */
const storage = multer.diskStorage({
  // Donde vamosa a guardar nuestros archivos.
  destination: (req, file, callback) => {
    const pathStorage = `${__dirname}/../storage`;
    callback(null, pathStorage);
  },
  filename: (req, file, callback) => {
    // Obtenemos la extension del archivo que la persona esta enviando:
    const ext = file.originalname.split(".").pop(); // ["name", "png"];
    const filename = `file-${Date.now()}.${ext}`; // Para que los nombres sean unicos.
    callback(null, filename);
  },
});

const uploadMiddleware = multer({ storage });

module.exports = uploadMiddleware;
