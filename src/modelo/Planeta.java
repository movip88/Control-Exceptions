package modelo;

import exceptiones.ErroresLogica;
import exceptiones.ErroresPersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import persistencia.InputOutputTXT;
import propierties.PropiertesController;

/**
 *
 * @author polmonleonvives
 */
public class Planeta {

    private static Planeta instance;

    public static Planeta getInstance() {
        if (instance == null) {
            instance = new Planeta();
        }
        return instance;
    }

    private Map<String, ArrayList<Especie>> seresCensados;

    private Planeta() {
        this.seresCensados = new HashMap();
        this.seresCensados.put("vulcano", new ArrayList());
        this.seresCensados.put("andoria", new ArrayList());
        this.seresCensados.put("nibiru", new ArrayList());
        this.seresCensados.put("kronos", new ArrayList());
    }

    public void addSer(Especie e, String planeta) throws ErroresLogica, ErroresPersistencia {
        if (!seresCensados.containsKey(planeta)) {
            throw new ErroresLogica(ErroresLogica.ERROR_003);
        }
        if ((planeta.equals("kronos") && this.seresCensados.get("kronos").size() > 29) || (e.getClass().getName().equals(Nibiriano.class.getName()) && !planeta.equals("nibiru")) || (planeta.equals("vulcano") && e.getClass().getName().equals(Andoriano.class.getName())) || (planeta.equals("andoria") && e.getClass().getName().equals(Vulcaniano.class.getName()))) {
            throw new ErroresLogica(ErroresLogica.ERROR_005);
        }
        for (ArrayList seres : this.seresCensados.values()) {
            if (seres.contains(e)) {
                throw new ErroresLogica(ErroresLogica.ERROR_006);
            }
        }
        this.seresCensados.get(planeta).add(e);
        InputOutputTXT.guardarSeres(planeta, this.seresCensados.get(planeta));
    }

    public void delSer(String nombre) throws ErroresLogica, ErroresPersistencia {
        Especie e = new Especie(nombre);
        for (String p : this.seresCensados.keySet()) {
            for (ArrayList<Especie> seres : this.seresCensados.values()) {
                if (seres.contains(e)) {
                    seres.remove(e);
                    InputOutputTXT.guardarSeres(p, seres);
                    return;
                }
            }
        }

        throw new ErroresLogica(ErroresLogica.ERROR_007);
    }

    public String devolverEspecie(Especie e) {
        StringBuilder sb = new StringBuilder();
        sb.append(PropiertesController.getInstance().getPropiertie("POBLACION_RAZA")).append("\n");
        this.seresCensados.forEach((k, v) -> {
            for (Especie ser : v) {
                if (ser.getNameEspecie().equals(e.getNameEspecie())) {
                    sb.append(ser.toString()).append("-").append(k).append("\n");
                }
            }
        });
        return sb.toString();
    }

    public String devolverTodosLosSeres() {
        StringBuilder sb = new StringBuilder();
        sb.append(PropiertesController.getInstance().getPropiertie("POBLACION_PLANETA")).append("\n");
        this.seresCensados.forEach((k, v) -> {
            v.sort((s1, s2) -> {
                if (s1.getNameEspecie().compareTo(s2.getNameEspecie()) == 0) {
                    return s1.getName().compareTo(s2.getName());
                } else {
                    return s1.getNameEspecie().compareTo(s2.getNameEspecie());
                }
            });
            v.forEach((ser) -> {
                if (sb.indexOf(k) < 0) {
                    sb.append("< ").append(k).append(" >\n");
                }
                sb.append(ser.toString()).append("\n");
            });
        });
        return sb.indexOf("-") > 0 ? sb.toString() : PropiertesController.getInstance().getPropiertie("NO_REGISTRADOS") + "\n";
    }

    public void modificarSer(String nombre, int dato) throws ErroresLogica, ErroresPersistencia {
        Especie e = new Especie(nombre);
        for (String p : this.seresCensados.keySet()) {
            for (ArrayList<Especie> seres : this.seresCensados.values()) {
                if (seres.contains(e)) {
                    seres.get(seres.indexOf(e)).setDato(dato);
                    InputOutputTXT.guardarSeres(p, seres);
                    return;
                }
            }
        }

        throw new ErroresLogica(ErroresLogica.ERROR_007);
    }

    public Set<String> devolverNombrePlanetas() {
        return this.seresCensados.keySet();
    }
}
