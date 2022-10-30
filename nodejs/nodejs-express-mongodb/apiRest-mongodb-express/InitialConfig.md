### Esta es la configuracion inicial de la API Rest con Express y Mongodb.

1. Creamos nuestra db no-relacional en mongodb, donde:
   -Creamos nuestra organizacion.
   -Creamos un nuevo proyecto.
   -Creamos la base de datos.
   -Creamos nuestro usuario y contraseña.
   -Definimos las IP's que se pueden conectar. Si queremos que se pueda conectar cualquier IP, simplemente ponemos 0.0.0.0/0 y una descripcion cualquiera.
   -Ya podemos crear la base de datos.
   -Cuando termine de crearse ya podemos conectar nuestra aplicacion, para ello vamos donde dice conectar, y si queremos conectar con nuestro proyecto ponemos: conectar a la app, y luego copiamos el 'DB_URI' y lo guardamos en algun lado.

2. Creamos nuestro proyecto de node:
   `npm init --y` Package.json
   `npm i express -S` Instalamos express y nos aseguramos q se instale en dep.
   `npm i cors dotenv multer -S` Instalamos estas dependencias. `cors` para evitar los tipicos problemas al compilar. `dotenv` para poder manejar variables de entorno. `multer` nos va a ayudar a manejar la carga de archivos.
   `npm i nodemon -D` Nos va a ayudar a reiniciar el servidor cuando hayan cambios.

3. Configuraciones:
   -Creamos el `.gitignore` y agregamos lo necesario.
   -Creamos los archivos `.env` y agregamos la data.

4. "Scaffold" o estructura de carpetas:
   -Utilizamos el MVC (En este caso `models`, `controllers` y `routes`).
   -Agregamos las carpetas 'config', 'utils' y 'storage'.

### Ya podemos empezar nuestro proyecto! Aca dejo algunas configuraciones o instalaciones de packetes/modulos/dependencias para el proyecto:

`npm i mongoose -S` Nos va a ayudar a gestionar la conexion con Mongodb.
`npm i express-validator -S` Es un packete que funciona como un middleware el cual se va a encargar de hacer un filtro para que la data que se esta enviando llegue al controlador como debe llegar.
`npm i mongoose-delete -S` Para poder usar la estrategia del 'soft delete' o borrado logico.
`npm i jsonwebtoken -S` Para crear permisos y autenticaciones.
`npm i bcryptjs -S`
`npm i morgan-body -S` Nos va a ayudar a interceptar todas las peticiones, respuestas, datos de entrada, y poder filtrar basado en el codigo del header de la peticion http y posteriormente enviar eso a nuestro slack para que yo pueda revisar y monitorear en cualquier momemento.
`npm i @slack/webhook -S` Para poder conectarnos al webhook del slack.

`npm i sequelize -S` Libreria para facilitar las queries para conexion a mysql.
`npm i mysql2 -S` Para instalar el packete de mysql.

5. Creacion de base de datos relacional 'mysql':
   -Iniciar base de datos con XAAMP o cualquier motor de base de datos.
   -Instalar sequelize.
   -Creamos la configuracion para conectar a la base de datos en el archivo 'mysql.js'.
   -Creamos la conexion a la base de datos en 'app.js'.
   -Instalamos 'mysql2'.
   -Tenemos que crear la db si no la tenemos, para eso ejecutamos estas queries:
   .create database api_node
   .use api_node
