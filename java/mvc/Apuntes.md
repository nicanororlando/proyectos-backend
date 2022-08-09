# Contexto de Spring e Inyeccion de dependencias

Este contexto es una region donde Spring va a almacenar instancias de clases. Cada una de estas instancias va a estar en el contexto de Spring, y nosotros podemos decirle a Spring que inyecte esas instancias que tenemos en el contexto, en otras clases.
Para registrar una instancia de una clase en el contexto de Spring usamos la anotacion '@Component'. Entonces si en otra clase requerimos una implementacion de la instancia que guardamos, podemos usar la anotacion '@Autowired' en la creacion del objeto, y esto nos va a inicializar ese objeto.

Otra forma de registrar es usando la notacion '@Component("nombre")' y de esta manera le asignamos un nombre al bean (instancia) en el contexto de Spring, y de esta manera podemos usar esta anotacion para todas las clases que queramos agregar al context. Despues, como vamos a tener varias instancias en el context, cuando queramos usar una en especifico usamos el @Autowired mas @Qualifier("nombre").
