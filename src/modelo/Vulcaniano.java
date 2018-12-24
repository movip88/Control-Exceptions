package modelo;

import exceptiones.ErroresLogica;

/**
 *
 * @author polmonleonvives
 */
public class Vulcaniano extends Especie {
    
    private int meditacion;
    
    public Vulcaniano(int meditacion, String name) throws ErroresLogica {
        super(name, "vulcan");
        this.setDato(meditacion);
    }
    
    @Override
    public void setDato(int dato) throws ErroresLogica {
        if (dato < 0 || dato > 10) {
            throw new ErroresLogica(ErroresLogica.ERROR_011);
        }
        this.meditacion = dato;
    }
    
    public int getMeditacion() {
        return meditacion;
    }
    
    @Override
    public String toString() {
        return super.toString() + "-" + meditacion;
    }
    
}
