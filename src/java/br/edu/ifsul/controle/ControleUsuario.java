package br.edu.ifsul.controle;

import br.edu.ifsul.bean.BeanUsuario;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author Érico
 */
@Named(value = "controleUsuario")
@SessionScoped
public class ControleUsuario implements Serializable{
    @EJB
    private BeanUsuario beanUsuarios;
    private Usuario objeto;
    private Boolean editando;
    
    public ControleUsuario(){
        this.editando = false;
    }
    
    public String listar(){
        editando = false;
        return "/usuario/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Usuario();
        editando = true;
    }
    
   public void excluir(Usuario obj){
       beanUsuarios.getUsuarios().remove(obj);
   }
   
   public void salvar(){
       if(objeto.getId()==null){
           objeto.setId(beanUsuarios.getUsuarios().size()+1);
           beanUsuarios.getUsuarios().add(objeto);
       }
       editando = false;
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

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }
   
   
}
