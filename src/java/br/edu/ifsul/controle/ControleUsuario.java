package br.edu.ifsul.controle;

import br.edu.ifsul.bean.BeanChat;
import br.edu.ifsul.bean.BeanUsuario;
import br.edu.ifsul.modelo.Mensagem;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.JOptionPane;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Érico
 */
@Named(value = "controleUsuario")
@SessionScoped
public class ControleUsuario implements Serializable {

    @EJB
    private BeanUsuario beanUsuarios;
    @EJB
    private BeanChat beanChat;
    private Usuario objeto;

    public ControleUsuario() {
        novo();
    }

    public String listar() {
        return "/usuario/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Usuario();
    }

    public void excluir(Usuario obj) {
        beanChat.getUsuarios().remove(obj);
    }

    public void salvar() {
        Boolean existe = false;
        objeto.setId(beanChat.getUsuarios().size() + 1);
        for (Usuario bu : beanChat.getUsuarios()) {
            if (bu.getNome().equals(objeto.getNome())) {
                existe = true;
            }
        }
        if (!existe) {
            beanUsuarios.setUsuario(objeto);//Joga usuario na sessão
            beanChat.getUsuarios().add(objeto);//Joga usuario na lista 
            //Util.mensagemInformacao("Usuário "+objeto.getNome()+" conectou-se");
            Mensagem m = new Mensagem(beanChat.getMensagens().size() + 1, new Usuario(0, "Servidor"), "Usuário " + objeto.getNome() + " conectou-se!");
            beanChat.getMensagens().add(m);
        } else {
            Mensagem m = new Mensagem(beanChat.getMensagens().size() + 1, new Usuario(0, "Servidor"), "Usuário " + objeto.getNome() + " já existe!");
            beanChat.getMensagens().add(m);
        }
    }

    public BeanUsuario getBeanUsuarios() {
        return beanUsuarios;
    }

    public void setBeanUsuarios(BeanUsuario beanUsuarios) {
        this.beanUsuarios = beanUsuarios;
    }

    public Usuario getObjeto() {
        return objeto;
    }

    public void setObjeto(Usuario objeto) {
        this.objeto = objeto;
    }

}
