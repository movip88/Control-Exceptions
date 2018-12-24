package modelo;

import exceptiones.ErroresLogica;

/**
 *
 * @author polmonleonvives
 */
public class Kinglon extends Especie {

    private int fuerza;

    public Kinglon(int fuerza, String name) throws ErroresLogica {
        super(name, "klingon");
        this.setDato(fuerza);
    }

    @Override
    public void setDato(int dato) throws ErroresLogica {
        if (dato < 50 || dato > 350) {
            throw new ErroresLogica(ErroresLogica.ERROR_012);
        }
        this.fuerza = dato;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + fuerza;
    }
}
