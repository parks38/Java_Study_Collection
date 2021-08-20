package com.example.email_practice.util;

public class PasswordWrongException extends RuntimeException{

  PasswordWrongException() {
    super("Password is wrong!");
  }
}
