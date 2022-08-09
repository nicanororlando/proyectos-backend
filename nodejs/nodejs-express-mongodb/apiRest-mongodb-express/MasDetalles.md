Luego de haber creado las rutas, los middlewares y demas, si quiero ver ya los datos en la base de datos, podemos descargar una herramienta llamada `Studio 3T` y crear una conexion a la base de datos a travez del `DB_URI`.

Para crear los permisos y autenticaciones vamos a utilizar el `JWT: JSON Web Token`. Es una cadena de texto larga que llama a la Hash, token o encriptado y esta compuesto por tres secciones: 1. Tipo de encriptacion o algoritmo que se utilizo para encriptarlo, 2. Payload o carga util que se suele utilizar como el nombre o id del usuario, 3. Verificaciones.

Para poder monitorear errores o alertas de forma muy practica, podemos utilizar varias herramientas utiles. Una de ellas que vamos a utilizar ahora es `Slack`. En esta app se puede armar grupos de trabajo tipo discord y nos va a ayudar a todo el tema de monitoreo de errores, por ejemplo se puede configurar para q si hay algun error que me lo mande al celular como notificacion y demas. Para armar la app y todo revisar video de 'Leifer Mendes' -Min 4:50:00 hs/min/seg-

`mysql`: Es nuestro motor para base de datos relacional. Para comenzar utilizaremos sequelize, que es un ORM o libreria que nos va a facilitar la implementacion de los queries para que se conecten a cierto motor de base de datos.
