package br.edu.ifsul.bean;

import br.edu.ifsul.modelo.Usuario;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

/**
 *
 * @author Érico
 */
@Stateful
public class BeanUsuario implements Serializable {
    private List<Usuario> usuarios = new ArrayList<>();
    
    public BeanUsuario(){
       usuarios.add(new Usuario(1, "Érico"));
    }
    @PreDestroy
    public void sair(Usuario obj){
        usuarios.remove(obj);
        //AQUI INFORMAR A MENSAGEM QUE USUARIO SAIU
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }   
    
}
