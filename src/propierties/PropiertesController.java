package propierties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user88
 */
public class PropiertesController {

    public static final String ES = "es";
    public static final String CA = "ca";
    public static final String EN = "en";

    private static PropiertesController instance;
    private String idioma;

    public static PropiertesController getInstance() {
        if (instance == null) {
            instance = new PropiertesController();
        }
        return instance;
    }

    public PropiertesController() {
        this.idioma = ES;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPropiertie(String llave) {
        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        FileReader fr = null;
        try {
            Properties prop = new Properties();
            fr = new FileReader(rutaActual + separador + "src" + separador + "propierties" + separador + this.idioma + ".properties");
            prop.load(fr);

            return prop.getProperty(llave);
        } catch (IOException ex) {
            Logger.getLogger(PropiertesController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PropiertesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "Error leer fichero propiertes";
    }

}
