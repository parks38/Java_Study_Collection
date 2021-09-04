package com.example.email_practice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class HashCalculator {

  public static enum Hash {
    SHA1("SHA1"), SHA256("SHA-256"), SHA512("SHA-512");

    private String name;

    Hash(String name) {
      this.name= name;
    }

    public String getName() {
      return name;
    }

    /**
     * file 입력 받아 Hash 값 16진수로 리턴
     */
    public String checksum(File input) throws Exception {
      InputStream in = new FileInputStream(input);
      MessageDigest digest = MessageDigest.getInstance(getName());
      byte[] block = new byte[4096];
      int length;
      while ((length = in.read(block)) > 0) {
        digest.update(block, 0, length);
      }
      in.close();
      return toHex(digest.digest());
    }

    /**
     *  문자열을 입력 받아 Hash 값(16 진수) 리턴
     */
    public String checksum(String input) throws Exception {
      MessageDigest digest = MessageDigest.getInstance(getName());
      byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

      return toHex(hash);
    }
  }

  /**
   *  byte[] 을 받아 16지누 변환 후 리턴
   */
  public static String toHex(byte[] bytes) {
    return DatatypeConverter.printHexBinary(bytes);
  }
}
