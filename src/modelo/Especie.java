package modelo;

import exceptiones.ErroresLogica;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author polmonleonvives
 */
public class Especie {

    private String name;
    private String nameEspecie;

    public static List<String> especiesLista = Arrays.asList("human", "vulcan", "andorian", "nibirian", "klingon");

    public Especie(String name, String nameEspecie) throws ErroresLogica {
        this.setNameEspecie(nameEspecie);
        this.name = name;
    }

    public Especie(String name) {
        this.name = name;
    }

    public Especie() {
    }
    
    public String getName() {
        return name;
    }

    public String getNameEspecie() {
        return nameEspecie;
    }

    public void setNameEspecie(String nameEspecie) throws ErroresLogica {
        if (!especiesLista.contains(nameEspecie)) {
            throw new ErroresLogica(ErroresLogica.ERROR_002);
        }
        this.nameEspecie = nameEspecie;
    }

    public void setDato(int dato) throws ErroresLogica {
        throw new ErroresLogica(ErroresLogica.ERROR_008);
    }

    @Override
    public String toString() {
        return nameEspecie + "-" + name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Especie other = (Especie) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
