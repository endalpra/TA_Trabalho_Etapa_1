package br.edu.ifsul.bean;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Érico
 */
@Singleton
public class BeanChat implements Serializable{
    private List<Usuario> usuarios = new ArrayList<>();
    private List<String> mensagens = new ArrayList<>();

    public BeanChat() {
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    } 
    
}

