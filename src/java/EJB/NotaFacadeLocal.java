
package EJB;

import Model.Nota;
import java.util.List;
import javax.ejb.Local;

@Local
public interface NotaFacadeLocal {
    
    void create(Nota persona);

    void edit(Nota persona);

    void remove(Nota persona);

    Nota find(Object id);

    List<Nota> findAll();

    List<Nota> findRange(int[] range);

    int count();
    
}
