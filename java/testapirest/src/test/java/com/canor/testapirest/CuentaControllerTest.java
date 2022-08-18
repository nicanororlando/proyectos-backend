package com.canor.testapirest;

// JUnit y Mockito.
import static org.hamcrest.Matchers.*;
// import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.canor.testapirest.controller.CuentaControlador;
import com.canor.testapirest.entity.Cuenta;
import com.canor.testapirest.entity.TransaccionDTO;
import com.canor.testapirest.service.ICuentaServicio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/* @WebMvcTest:
 *  Sirve para probar la capa del controlador y debe proporcionar las dependencias restantes
 * requeridas mediante 'mocks' En otras palabras le indicamos que esta va a ser una clase para
 * probar un controlador.
 */
@WebMvcTest(CuentaControlador.class)
public class CuentaControllerTest {

  @Autowired
  // MockMvc nos va a permitir hacer llamadas a un controllador.
  private MockMvc mockMvc;

  // Para crear un simulacro de este servicio.
  @MockBean
  private ICuentaServicio cuentaServicio;

  // Para mapear un JSON a Objeto o viceversa. Provee funcionalidad para leer y escribir JSON.
  ObjectMapper objectMapper;

  // @BeforeEach sirve para ejecutar una accion antes de cada Test.
  @BeforeEach
  void configurar() {
    objectMapper = new ObjectMapper();
  }

  @Test
  public void testVerDetalles() throws Exception {
    /* Voy a simular que estoy guardando un registro, pero en realidad no lo estoy guardando.
     * Aca le decimos que cuando se llame al metodo findById(1L), que retorne la Cuenta que tenemos
     * predefinida en la clase Datos.
     */
    when(cuentaServicio.findById(1L))
      .thenReturn(Datos.crearCuenta001().orElseThrow());

    // Retorna una peticion.
    /* Se espera que la respuesta sea de tipo JSON, que el status sea OK, luego que el contenido
     * sea de tipo JSON, y luego le indicamos que valores se esperan que retorne tanto 'persona'
     * como 'saldo'.
     */
    mockMvc
      .perform(get("/api/cuentas/1").contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.persona").value("Canor"))
      .andExpect(jsonPath("$.saldo").value("1000"));

    // Para verificar que si llamamos a la cuenta servicio, se llame al metodo findById(1L).
    verify(cuentaServicio).findById(1L);
  }

  @Test
  public void testTransferirDinero() throws Exception {
    TransaccionDTO transaccionDTO = new TransaccionDTO();
    transaccionDTO.setCuentaOrigenId(1L);
    transaccionDTO.setCuentaDestinoId(2L);
    transaccionDTO.setMonto(new BigDecimal(100));
    transaccionDTO.setBancoId(1L);

    System.out.println(objectMapper.writeValueAsString(transaccionDTO));

    Map<String, Object> respuesta = new HashMap<>();
    respuesta.put("date", LocalDate.now().toString());
    respuesta.put("status", "OK");
    respuesta.put("mensaje", "Transferencia realizada con exitoo");
    respuesta.put("transaccionDTO", transaccionDTO);

    System.out.println(objectMapper.writeValueAsString(respuesta));

    mockMvc
      .perform(
        post("/api/cuentas/transferir")
          // Le indicamos que el contenido que se envia es de tipo JSON.
          .contentType(MediaType.APPLICATION_JSON)
          // Le indicamos el contenido que se va a enviar.
          .content(objectMapper.writeValueAsString(transaccionDTO))
      )
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.date").value(LocalDate.now().toString()))
      .andExpect(
        jsonPath("$.mensaje").value("Transferencia realizada con exitoo")
      )
      .andExpect(
        jsonPath("$.transaccionDTO.cuentaOrigenId")
          .value(transaccionDTO.getCuentaOrigenId())
      )
      .andExpect(content().json(objectMapper.writeValueAsString(respuesta)));
  }

  @Test
  public void listarCuentas() throws JsonProcessingException, Exception {
    List<Cuenta> cuentas = Arrays.asList(
      Datos.crearCuenta001().orElseThrow(),
      Datos.crearCuenta002().orElseThrow()
    );

    when(cuentaServicio.listAll()).thenReturn(cuentas);

    mockMvc
      .perform(get("/api/cuentas").contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$[0].persona").value("Canor"))
      .andExpect(jsonPath("$[1].persona").value("Julen"))
      .andExpect(jsonPath("$[0].saldo").value("1000"))
      .andExpect(jsonPath("$[1].saldo").value("2000"))
      .andExpect(jsonPath("$", hasSize(2)))
      .andExpect(content().json(objectMapper.writeValueAsString(cuentas)));

    verify(cuentaServicio).listAll();
  }

  @Test
  public void guardarCuenta() throws JsonProcessingException, Exception {
    Cuenta cuenta = new Cuenta(null, "Nabucodonosor", new BigDecimal("3000"));

    /* Cuando se llame al metodo save para guardar cualquier cuenta, entonces llamamos a una funcion
     * lamda y a obtener su primer argumento (null) y luego cambiar el id a 3L.
     */
    when(cuentaServicio.save(any()))
      .then(
        invocation -> {
          Cuenta c = invocation.getArgument(0);
          c.setId(3L);
          return c;
        }
      );

    /*    Cuando se haga una peticion de tipo 'post' le indicamos que el tipo de contenido que le
     *  enviamos es de tipo JSON y que le voy a enviar la cuenta que creamos al principio.
     *    Luego vamos a esperar que el contenido que devuelva sea JSON y que los datos que devuelva
     *  sean los mismos que se enviaron.
     */
    mockMvc
      .perform(
        post("/api/cuentas")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(cuenta))
      )
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id", is(3)))
      .andExpect(jsonPath("$.persona", is("Nabucodonosor")))
      .andExpect(jsonPath("$.saldo", is(3000)));

    // Para comprobar si se ha llamado o invocado algun metodo.
    verify(cuentaServicio).save(any());
  }
}
