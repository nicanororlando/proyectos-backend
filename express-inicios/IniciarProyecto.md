# Pasos para crear la API:

# Cada vez que instalamos una dependencia tenemos que tener en cuenta si instalamos como dependencia o como dependencia de desarrollo:

### `dependencies:` Cuando el codigo del servidor depende de una de las bibliotecas que esten ahi. Es tanto para desarrollo como para produccion.

### `devDependencies:` Significa que los modulos que esten dentro me van a ayudar a desarrollar el codigo. Solo es para desarrollo.

`npm init -y` Para crear el package.json
`npm install express` Para instalar express en el proyecto
`npm i nodemon -D` Para guardar el codigo de JavaScript, esto va a reiniciar el servidor cada vez que se produzca un cambio en el codigo, acelera bastante la cosa.
Para compilar la app ejecutamos `npx nodemon index.js`
