package persistencia;

import controller.SerController;
import exceptiones.ErroresLogica;
import exceptiones.ErroresPersistencia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Especie;
import modelo.Planeta;

/**
 *
 * @author polmonleonvives
 */
public class InputOutputTXT {

    public static void cargarSeres() throws ErroresPersistencia {
        Planeta p = Planeta.getInstance();

        for (String nf : p.devolverNombrePlanetas()) {
            File f = new File(nf + ".txt");

            if (f.exists()) {
                FileReader fr = null;

                try {
                    fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);

                    String linea;

                    while ((linea = br.readLine()) != null) {
                        String[] info_linea = linea.split("-");
                        try {
                            p.addSer(SerController.devolverSer(info_linea), nf);
                        } catch (ErroresLogica ex) {
                            System.out.println("Error en una linea del fichero '" + linea + "' + error code -> " + ex.getMessage());
                        }
                    }
                } catch (IOException ex) {
                    throw new ErroresPersistencia(ErroresPersistencia.ERROR_LEER);
                } finally {
                    try {
                        if (fr != null) {
                            fr.close();
                        }
                    } catch (IOException ex) {
                        throw new ErroresPersistencia(ErroresPersistencia.ERROR_CERRAR);
                    }
                }
            }
        }
    }

    public static void guardarSeres(String nombrePlaneta, ArrayList<Especie> lista) throws ErroresPersistencia {
        File f = new File(nombrePlaneta + ".txt");

        if (f.exists()) {
            f.delete();
        }

        StringBuilder datos = new StringBuilder();

        lista.forEach((s) -> {
            datos.append(s);
            datos.append("\n");
        });

        FileWriter fw = null;

        try {
            fw = new FileWriter(f);

            fw.write(datos.toString());
        } catch (IOException ex) {
            throw new ErroresPersistencia(ErroresPersistencia.ERROR_ESCRIBIR);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                throw new ErroresPersistencia(ErroresPersistencia.ERROR_CERRAR);
            }
        }
    }

}
