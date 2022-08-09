package com.canor.jobs.util;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

  // El objeto multipart el contenido binario de la imagen y algo de metadata (informacion sobre el dato que viene).
  public static String SaveFile(MultipartFile multipartFile, String route) {
    // Obtenemos el nombre original del archivo
    String originalName = multipartFile.getOriginalFilename();
    try {
      File imageFile = new File(route + originalName);
      System.out.println("Archivo: " + imageFile.getAbsolutePath());
      // Guardamos fisicamente el archivo en HD
      multipartFile.transferTo(imageFile);
      return originalName;
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }
}
