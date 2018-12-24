package modelo;

import exceptiones.ErroresLogica;

/**
 *
 * @author polmonleonvives
 */
public class Nibiriano extends Especie {

    private boolean isVegetarian;

    public Nibiriano(String name, boolean isVegetarian) throws ErroresLogica {
        super(name, "nibirian");
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + (this.isVegetarian ? "vegetarian" : "novegetarian");
    }

}
