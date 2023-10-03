package modelDominio;

import java.io.Serializable;

public class Comum  extends Usuario implements Serializable {
    private static final long serialVersionUID = 123L;

    public Comum(int idUsuario, String nomeUsuario, String login, String senha, String cpf, String email, String telefone,int tipoUsuario) {
        super(idUsuario, nomeUsuario, login, senha, cpf, email, telefone, tipoUsuario);
    }

    public Comum(String nomeUsuario, String login, String senha, String cpf, String email, String telefone, int tipoUsuario) {
        super(nomeUsuario, login, senha, cpf, email, telefone, tipoUsuario);
    }

    @Override
    public String toString() {
        return "Comum{" + '}'+ super.toString();
    }

}