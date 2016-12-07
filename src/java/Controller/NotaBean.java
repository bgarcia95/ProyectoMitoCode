package Controller;

import EJB.CategoriaFacadeLocal;
import EJB.NotaFacadeLocal;
import Model.Categoria;
import Model.Nota;
import Model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class NotaBean implements Serializable {

    @EJB
    private NotaFacadeLocal notaEJB;
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    @Inject
    private Nota nota;
    @Inject
    private Categoria categoria;

    private List<Categoria> categorias;

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @PostConstruct
    public void init() {
        categorias = categoriaEJB.findAll();

    }

    public void registrar() {

        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.nota.setPersona(us.getId_usuario());
            this.nota.setCategoria(categoria);
            notaEJB.create(nota);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró"));
        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
        }

    }
}
