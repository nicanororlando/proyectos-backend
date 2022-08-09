package com.spring.mvc.daos;

import org.springframework.stereotype.Component;

import com.spring.mvc.entities.User;

// DAO: Data Access Object.
/* Es un patron de diseño en el cual se tiene una clase cuyos metodos nos permiten hacer consultas 
 * para cierta informacion de tablas de nuestro sistema.
 * JPA es una forma de hacer consultas a la base de datos.
 */

@Component("user-dao-jpa") 
public class UserDAOJPA implements UserDAO {

  public User getUserById(int id){
    // Simulamos consulta a base de datos.
    // Y obtenemos el siguiente usuario:
    System.out.println("Invocando dao jpa");
    User user = new User();
    user.setName("Homero simpson");
    user.setAge(38);

    return user;
  }
}