package modelo;

import exceptiones.ErroresLogica;

/**
 *
 * @author polmonleonvives
 */
public class Humano extends Especie {

    private int edad;

    public Humano(String name, int edad) throws ErroresLogica {
        super(name, "human");
        this.setDato(edad);
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public void setDato(int dato) throws ErroresLogica {
        if (dato < 0 || dato > 130) {
            throw new ErroresLogica(ErroresLogica.ERROR_010);
        }
        this.edad = dato;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + edad;
    }
}
