/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class Hash {
    public static String encriptar(String texto, String algoritmo) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        MessageDigest message = MessageDigest.getInstance(algoritmo);
        byte messageDigest[] = message.digest(Funcoes.retirarAcento(texto).getBytes("UTF-8"));

        // Colocar no formato hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();

        return senhahex;
    }
}
