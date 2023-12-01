/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.EventoDao;
import model.ReservaDao;
import model.UsuarioDao;
import modelDominio.Evento;
import modelDominio.Usuario;
import modelDominio.Reserva;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class TrataClienteController extends Thread{
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private int idUnico;
    
    public TrataClienteController(Socket socket, int idUnico) {
        this.socket = socket;
        this.idUnico = idUnico;
        try {
            this.in = new ObjectInputStream(this.socket.getInputStream());
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
            this.start();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }

    @Override
    public void run() {
        String comando;
        System.out.println("Esperando comandos do cliente: " + idUnico);
        
        try {
           comando = (String)in.readObject();
            while(!comando.equalsIgnoreCase("fim")) {
               System.out.println("Cliente " + idUnico + " enviou o comando: " + comando);
               if (comando.equalsIgnoreCase("UsuarioEfetuarLogin")) {
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();
                    UsuarioDao usuarioDao = new UsuarioDao();
                    Usuario usuarioLogado = usuarioDao.efetuarLogin(usuario);
                    out.writeObject(usuarioLogado);
                    
                } else if (comando.equalsIgnoreCase("UsuarioLista")){
                    //
                    UsuarioDao usuarioDao = new UsuarioDao();
                    ArrayList<Usuario> listaUsuarios = usuarioDao.getListaUsuarios();            
                    out.writeObject(listaUsuarios);
                } else if (comando.equalsIgnoreCase("UsuarioExiste")){
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();
                    UsuarioDao usuarioDao = new UsuarioDao();
                    boolean resultado = usuarioDao.usuarioExiste(usuario);
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("UsuarioInserir")){
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();
                    UsuarioDao usuarioDao = new UsuarioDao();
                    boolean resultado = usuarioDao.inserirUsuario(usuario);
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("UsuarioAlterar")){
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();
                    UsuarioDao usuarioDao = new UsuarioDao();
                    boolean resultado = usuarioDao.alterarUsuario(usuario);
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("UsuarioExcluir")){
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();
                    UsuarioDao usuarioDao = new UsuarioDao();
                    boolean resultado = usuarioDao.excluirUsuario(usuario);
                    out.writeObject(resultado);                 
                } else if (comando.equalsIgnoreCase("EventoLista")){
                    //
                    EventoDao eventoDao = new EventoDao();
                    ArrayList<Evento> listaEventos = eventoDao.getListaEventos();            
                    out.writeObject(listaEventos);
                }    else if (comando.equalsIgnoreCase("EventoInserir")){
                    out.writeObject("ok");
                    Evento evento = (Evento) in.readObject();
                    EventoDao eventoDao = new EventoDao();
                    boolean resultado = eventoDao.inserirEvento(evento);
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("EventoAlterar")){
                    out.writeObject("ok");
                    Evento evento = (Evento) in.readObject();
                    EventoDao eventoDao = new EventoDao();
                    boolean resultado = eventoDao.alterarEvento(evento);
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("EventoExcluir")){
                    out.writeObject("ok");
                    Evento evento = (Evento) in.readObject();
                    EventoDao eventoDao = new EventoDao();
                    boolean resultado = eventoDao.excluirEvento(evento);
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("ReservaCadeira")) {
                    out.writeObject("ok");
                    Evento evento = (Evento) in.readObject();
                    EventoDao eventoDao = new EventoDao();
                    boolean reservarCadeira = eventoDao.reservarCadeira(evento);
                    out.writeObject(reservarCadeira);
                } else if (comando.equalsIgnoreCase("ReservaLista")){
                    //
                    ReservaDao reservaDao = new ReservaDao();
                    ArrayList<Reserva> listaReservas = reservaDao.getListaReservas();            
                    out.writeObject(listaReservas);
                } else if (comando.equalsIgnoreCase("EfetuarReserva")){
                    out.writeObject("ok");
                    Reserva reserva = (Reserva) in.readObject();
                    ReservaDao reservaDao = new ReservaDao();
                    boolean resultado = reservaDao.efetuarReserva(reserva);
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("AtualizacaoSenhaUsuario")){
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();                                        
                    out.writeObject("ok");
                    String novaSenha = (String) in.readObject();
                    UsuarioDao usuarioDao = new UsuarioDao();
                    System.out.println("Atualizando senha - Senha atual: " + usuario.getSenha());
                    boolean resultado = usuarioDao.senhaUsuarioExiste(usuario);
                    if (resultado == true) {
                        usuario.setSenha(novaSenha);
                        System.out.println("Atualizando senha - Senha Nova: " + usuario.getSenha() + ", (var): " + novaSenha);
                        UsuarioDao usuarioDao2 = new UsuarioDao();
                        resultado = usuarioDao2.alterarUsuario(usuario);
                    } 
                    out.writeObject(resultado);
                } else if (comando.equalsIgnoreCase("EnviarEmail")){
                    try {
                        out.writeObject("ok");
                        String emailDestinatario = (String) in.readObject();
                        UsuarioDao usuarioDao = new UsuarioDao();
                        boolean resultado = usuarioDao.enviarEmail(emailDestinatario);
                        out.writeObject(resultado);
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro: " + e.getMessage());
                        out.writeObject(false); // Indicar falha ao cliente
                    }
                }
                System.out.println("Esperando comando");
                comando = (String)in.readObject();
           }      
           
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
        }
        
         try {
            System.out.println("Cliente " + idUnico + " finalizou a conexão.");
            in.close();
            out.close();
            socket.close();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
}