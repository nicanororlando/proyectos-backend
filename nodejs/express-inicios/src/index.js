const express = require("express");
const morgan = require("morgan");

/* Esto es un MIDDLEWWARE: Es un manejador de una peticion que nosotros podemos
ejecutar antes de que llegue a su ruta original. En este o en el otro middleware
que creamos pero solo para la ruta "user", podemos hacer cosas como por ejemplo 
validaciones, entonces podemos hacer tipo que si algo se cumple que siga a la ruta
original y sino que haga otra cosa. */
const logger = (req, res, next) => {
  console.log("\nMiddleware logger:");
  console.log(
    // protocol: "http", host: "localhost", originalUrl: "Resto de la url"
    `Route received: ${req.protocol}://${req.get("host")}${req.originalUrl} \n`
  );
  console.log("Middleware morgan:");
  next();
};

// Mi servidor:
const app = express();

// SETTINGS:
app.set("appName", "Express beginnings");
app.set("port", 3000);
app.set("viewEngine", " ejs");

// MIDDLEWARS:
// Lo definimos para que express pueda entender los formatos JSON u objetos de js.
app.use(express.json());

console.log("Middleware logger:");
app.use(logger);

app.use(morgan("dev"));

/* Esto tambien es un MIDDLEWAR que crea una ruta, en donde se va a ejecutar cualquier 
ruta que coincida con esa ruta, y se va a ejecutar primero que cualquier otra 
instruccion ya sea get, put post o lo que sea, y luego con las ultima instruccion le 
decimos que siga a la sig ruta. */
app.all("user", (req, res) => {
  console.log("Por aqui paso");
  res.send("Finish");
});

// ROUTES:

app.get("/", (req, res) => {
  const data = [{ name: "john" }, { name: "joe" }, { name: "canor" }];
  res.render("index.ejs", { people: data });
});

app.get("/user", (req, res) => {
  res.json({
    name: "Canor",
    lastname: "Orlando",
  });
});

app.post("/user/:id", (req, res) => {
  // El req.body contiene los datos que le fueron enviados desde otro lugar.
  console.log(req.body);
  // En el req.params recibimos los parametros de la url en la q se hizo un POST.
  console.log(req.params);

  res.send("Post request received");
});

app.put("/user/:id", (req, res) => {
  console.log(req.body);
  res.send(`User ${req.params.id} updated.`);
});

app.delete("/user/:id", (req, res) => {
  res.send(`User ${req.params.id} deleted.`);
});

/* Este middleware va a ejecutar lo que esta en public cuando no se encuentre niunguna
ruta que coincida con una ruta definida por nosotros aca */
app.use(express.static("public"));

app.listen(app.get("port"), () => {
  console.log(app.get("appName")); // Obtengo el valor de la var q setie arriba.
  console.log("Server on port", app.get("port"));
});
