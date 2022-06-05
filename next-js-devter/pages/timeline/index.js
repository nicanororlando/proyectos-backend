import Link from 'next/link';

export default function Timeline({ userName }) {
  return (
    <>
      <h1>This is the timeline of {userName}</h1>
      <Link href='/'><a>Go home</a></Link>
    </>
  );
}

/* Este metodo se ejecuta en el servidor, cuando entramos a la ruta next.js
se fija si el componente Timeline tiene el metodo getInitialProps, y lo ejecuta
antes de renderizarlo. Entonces primero recupera los datos de forma sincrona, y si
llegase a ser de forma asincrona va a esperar hasta que se recuperen esos datos
antes de renderizar. Ademas de renderizar el componente desde el servidor con
esa informacion, esta enviando esos datos que creamos en el getInitialProps en 
HTML. Esto se le llama el proceso de hidratacion: Para poder renderizar lo que 
tenemos en el servidor y que en el cliente se renderice exactamente igual, por
eso desde el servidor tambien se mandan los datos con los cuales fue renderizada
la pagina en el servidor para que se renderice igual en el lado del cliente. 

Esto es importante por que de esta forma podemos hacer un fetch a cualquier api
externa o interna, y esos datos los devolvemos directamente como props para 
nuestro componente.

Apenas ingreso a una ruta, se ejecuta en el servidor, pero una vez que estoy 
dentro de la pagina, como es una SPA, esta funcion ya se va a ejecutar en el
cliente cada vez que se ejecute nuevamente. 

Esta funcion solo funciona en tipo pagina, NO componentes. */
Timeline.getInitialProps = () => {
  return fetch('http://localhost:3000//api/hello')
    .then(res=>res.json())
    .then(response => {
      const {userName} = response;
      return {userName}
    });
}