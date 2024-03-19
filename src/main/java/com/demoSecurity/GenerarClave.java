package com.demoSecurity;

import java.security.SecureRandom;
import java.util.Base64;

public class GenerarClave {
    public static void main(String[] args) {
        String claveSecreta = generarClaveSecreta();
        System.out.println("Clave secreta generada: " + claveSecreta);
    }

    public static String generarClaveSecreta() {
        byte[] claveBytes = new byte[32]; // Longitud de 256 bits (32 bytes)
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(claveBytes);
        return Base64.getEncoder().encodeToString(claveBytes);
    }
}
