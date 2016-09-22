package br.edu.ifsul.bean;

import br.edu.ifsul.controle.ControleChat;
import br.edu.ifsul.controle.ControleUsuario;
import br.edu.ifsul.modelo.Mensagem;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.inject.Inject;

/**
 *
 * @author Érico
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 1)
public class BeanUsuario implements Serializable {

    private Usuario usuario;

    @Inject
    private ControleChat controleChat;

    @Inject
    private BeanChat beanChat;

    public BeanUsuario() {
        System.out.println("Criou Sessão");
    }

    @PostConstruct
    public void inicia() {

    }

    @PreDestroy
    public void sair() {
        //Util.mensagemInformacao("Usuário "+usuario.getNome()+" desconectou-se");
        Mensagem m = new Mensagem(beanChat.getMensagens().size() + 1, new Usuario(0, "Servidor"), "Usuário " + usuario.getNome() + " desconectou-se!");
        beanChat.getMensagens().add(m);
        controleChat.getBeanChat().getUsuarios().remove(usuario);        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ControleChat getControleChat() {
        return controleChat;
    }

    public void setControleChat(ControleChat controleChat) {
        this.controleChat = controleChat;
    }

    public BeanChat getBeanChat() {
        return beanChat;
    }

    public void setBeanChat(BeanChat beanChat) {
        this.beanChat = beanChat;
    }

}
