package com.canor.jobs.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Le indicamos que para este metodo solo se van a aceptar excepciones del tipo multipartExceptions.
  @ExceptionHandler(MultipartException.class)
  public String handleMultipart(
    MultipartException e,
    RedirectAttributes attributes
  ) {
    attributes.addFlashAttribute("message", e.getCause().getMessage());
    return "redirect:/vacants/";
  }
}
