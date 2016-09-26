package br.edu.ifsul.controle;

import br.edu.ifsul.bean.BeanChat;
import br.edu.ifsul.bean.BeanUsuario;
import br.edu.ifsul.modelo.Mensagem;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Érico
 */
@Named(value="controleChat")
@SessionScoped
public class ControleChat implements Serializable{
    @EJB
    private BeanChat beanChat;
    
    @Inject
    private ControleUsuario controleUsuario;
    
    private String msg;
    public ControleChat(){
        
    }
    
    public void sm(){
        if(controleUsuario.getBeanUsuarios().getUsuario() != null)
            beanChat.getMensagens().add(new Mensagem(2, controleUsuario.getBeanUsuarios().getUsuario(), msg));
    }
    public String chat(){
        return "chat";
    }

    public BeanChat getBeanChat() {
        return beanChat;
    }

    public void setBeanChat(BeanChat beanChat) {
        this.beanChat = beanChat;
    }
    
    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }

    public void setControleUsuario(ControleUsuario controleUsuario) {
        this.controleUsuario = controleUsuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
