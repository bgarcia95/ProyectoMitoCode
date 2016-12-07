
package Controller;

import EJB.NotaFacadeLocal;
import Model.Nota;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class valorarBean implements Serializable{
    
    @EJB
    private NotaFacadeLocal notaEJB;
    
    @Inject
    private comentarBean comentarBean;
    private Nota nota;
    
    @PostConstruct
    public void init(){
        this.nota= comentarBean.getNota();
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
    public void registrar(){
        try{
            notaEJB.edit(nota);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se comentó de manera correcta"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
        }finally{
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
            
    }
    
}
