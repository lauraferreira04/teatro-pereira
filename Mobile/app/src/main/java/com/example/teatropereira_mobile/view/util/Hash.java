package com.example.teatropereira_mobile.view.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;

public class Hash {
    public static String encripar(String texto, String algoritmo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest message = MessageDigest.getInstance(algoritmo);
        byte messageDigest[] = message.digest(retirarAcento(texto).getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        String senhahex = hexString.toString();
        return senhahex;
    }

    public static String retirarAcento(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;
    }
}
