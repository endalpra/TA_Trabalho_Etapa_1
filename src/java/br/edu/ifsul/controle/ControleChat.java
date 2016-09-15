package br.edu.ifsul.controle;

import br.edu.ifsul.bean.BeanChat;
import br.edu.ifsul.bean.BeanUsuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
    @EJB
    private BeanUsuario beanUsuarios;
    
    public ControleChat(){
        
    }
    
    public String chat(){
        return "carrinho";
    }

    public BeanChat getBeanChat() {
        return beanChat;
    }

    public void setBeanChat(BeanChat beanChat) {
        this.beanChat = beanChat;
    }

    public BeanUsuario getBeanUsuarios() {
        return beanUsuarios;
    }

    public void setBeanUsuarios(BeanUsuario beanUsuarios) {
        this.beanUsuarios = beanUsuarios;
    }   
    
}
