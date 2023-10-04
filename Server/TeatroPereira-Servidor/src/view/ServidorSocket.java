/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.TrataClienteController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class ServidorSocket {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado. Aguardando conexão...");
            int idUnico = 0;
            while(true) {
                Socket cliente = servidor.accept();
                System.out.println("Um novo cliente se conectou: " + cliente);
                idUnico++;
                System.out.println("Iniciando nova thread para o cliente: " + idUnico);
                TrataClienteController trataCliente = new TrataClienteController(cliente, idUnico);
            }
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
    
}
