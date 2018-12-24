package modelo;

import exceptiones.ErroresLogica;

/**
 *
 * @author polmonleonvives
 */
public class Andoriano extends Especie {
    
    private boolean isAenar;
    
    public Andoriano(String name, boolean isAenar) throws ErroresLogica {
        super(name, "andorian");
        this.isAenar = this.isAenar;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + (this.isAenar ? "aenar" : "noaenar");
    }
}
