
package Controller;

import EJB.PersonaFacadeLocal;
import Model.Persona;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class personaBean implements Serializable{
    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;
    
    @PostConstruct
    public void init(){
        persona=new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar(){
        try{
            personaEJB.create(persona);
        }catch(Exception e){
            
        }
    }
}
