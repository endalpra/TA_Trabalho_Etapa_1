package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Érico
 */
public class Mensagem implements Serializable{
    private Integer id;
    private Usuario usuario;
    private String msg;

    public Mensagem() {
    }

    public Mensagem(Integer id, Usuario usuario, String msg) {
        this.id = id;
        this.usuario = usuario;
        this.msg = msg;
    }    

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensagem other = (Mensagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
