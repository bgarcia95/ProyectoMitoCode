
package Controller;

import Model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped

public class plantillaBean implements Serializable{
    
    public void verificarSesion(){
        try{
        FacesContext context = FacesContext.getCurrentInstance(); 
        Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
       
        if(us==null){
            context.getExternalContext().redirect("./../permisos.xhtml");
        }
        
        }catch(Exception e){
            
        }
    }
}
