Luego de haber creado las rutas, los middlewares y demas, si quiero ver ya los datos en la base de datos, podemos descargar una herramienta llamada `Studio 3T` y crear una conexion a la base de datos a travez del `DB_URI`.

Para crear los permisos y autenticaciones vamos a utilizar el `JWT: JSON Web Token`. Es una cadena de texto larga que llama a la Hash, token o encriptado y esta compuesto por tres secciones: 1. Tipo de encriptacion o algoritmo que se utilizo para encriptarlo, 2. Payload o carga util que se suele utilizar como el nombre o id del usuario, 3. Verificaciones.
