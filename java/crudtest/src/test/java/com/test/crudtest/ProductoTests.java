package com.test.crudtest;

import static org.assertj.core.api.Assertions.assertThat;
// Importamos todos los assertions (assertNotNull, assertNull).
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

// Para identificar que vamos a testear una entidad.
@DataJpaTest
// Para que me haga las operaciones no a la db h2, sino a la db real.
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductoTests {

  @Autowired
  private IProductoRepositorio repositorio;

  // Para indicar que este metodo es de prueba. Esto va a guardar temporalmente el producto en la db.
  @Test
  /* Como estamos testeando, por defecto no se guardan los datos en la db sino que se hace un
   *  rollback o reversion. Para que no pase eso y podamos almacenar datos de en la db:
   */
  @Rollback(false)
  @Order(1)
  public void testGuardarProducto() {
    Producto producto = new Producto("Televisor Samsung HD", 3000);

    Producto productoGuardado = repositorio.save(producto);

    // Va a confirmar la prueba unitaria siempre y cuando el valor no sea nulo.
    assertNotNull(productoGuardado);
  }

  @Test
  /* Para que el test sea exitoso debemos ejecutarlo junto al 'testGuardarProducto', ya que sino no
   * tendria datos en la tabla para buscar.
   */
  @Order(2)
  public void testBuscarProductoPorNombre() {
    String nombre = "Televisor Samsung HD";
    Producto producto = repositorio.findByNombre(nombre);

    // Verificamos que la respuesta a la busqueda por nombre coincida con el nombre.
    // MatcherAssert.assertThat(producto.getNombre(), equalTo(nombre));
    assertThat(producto.getNombre()).isEqualTo(nombre);
  }

  @Test
  @Order(3)
  public void testBuscarProductoPorNombreNoExistente() {
    String nombre = "IPhone 11";
    Producto producto = repositorio.findByNombre(nombre);

    // Verificamos que la respuesta a la busqueda sea nula (osea q no exista).
    assertNull(producto);
  }

  @Test
  @Rollback(false)
  @Order(4)
  public void testActualizarProducto() {
    String nombreProducto = "Televisor HD";
    Producto producto = new Producto(nombreProducto, 2000); // Valores nuevos
    producto.setId(1); // Le pasamos el id del producto que queremos actualizar.

    // Guardamos el producto en la db.
    repositorio.save(producto);

    // Luego de guardar, buscamos ese producto.
    Producto productoActualizado = repositorio.findByNombre(nombreProducto);

    // Confirmamos que el producto se haya actualizado correctamente.
    assertThat(productoActualizado.getNombre()).isEqualTo(nombreProducto);
  }

  // Para que funcione correctamente hay q ejecutar este test solo junto al de 'guardarProducto'.
  @Test
  @Order(5)
  public void testListarProductos() {
    List<Producto> productos = (List<Producto>) repositorio.findAll(); // Casteamos el tipo.

    for (Producto producto : productos) {
      System.out.println(producto.getNombre());
      System.out.println(producto.getPrecio());
    }

    System.out.println(
      "TAMAÑOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO: " +
      productos.size()
    );

    // Comprobamos que la tabla tenga un tamaño mayor a cero.
    assertThat(productos).size().isGreaterThan(0); // No funca
  }

  @Test
  @Rollback(false)
  @Order(6)
  public void testEliminarProducto() {
    Integer id = 1;

    // Si existe retorna true
    boolean esExistenteAntesDeEliminar = repositorio.findById(id).isPresent();

    repositorio.deleteById(id);

    // Si existia retorna true
    boolean noExisteDespuesDeEliminar = repositorio.findById(id).isPresent();

    assertTrue(esExistenteAntesDeEliminar);
    assertFalse(noExisteDespuesDeEliminar);
  }
}
