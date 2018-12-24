package projecte.excepcions;

import controller.SerController;
import exceptiones.ErroresLogica;
import exceptiones.ErroresPersistencia;
import modelo.Especie;
import modelo.Planeta;
import persistencia.InputOutputTXT;
import propierties.PropiertesController;

/**
 *
 * @author polmonleonvives
 */
public class ProjecteExcepcions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InputOutputTXT.cargarSeres();
            Planeta p = Planeta.getInstance();
            Utilidades u = new Utilidades();

            boolean salir = true;

            while (salir) {

                try {
                    String comando = u.pedirDatos(PropiertesController.getInstance().getPropiertie("INTRODUCE_COMANDO"));
                    if (comando.length() == 0) {
                        throw new ErroresLogica(ErroresLogica.ERROR_001);
                    }
                    args = comando.split(" ");

                    for (int i = 0; i < args.length; i++) {
                        args[i] = args[i].toLowerCase();
                    }
                    int dato;
                    switch (args[0].toUpperCase()) {
                        case "C":
                            checkArguments(args, 5);
                            String[] infoSer = {args[1], args[3], args[4]};
                            p.addSer(SerController.devolverSer(infoSer), args[2]);
                            System.out.println(PropiertesController.getInstance().getPropiertie("SER_CENSADO"));
                            break;
                        case "B":
                            checkArguments(args, 2);
                            p.delSer(args[1]);
                            System.out.println(PropiertesController.getInstance().getPropiertie("SER_BORRADO"));
                            break;
                        case "L":
                            checkArguments(args, 1);
                            System.out.println(p.devolverTodosLosSeres());
                            break;
                        case "M":
                            checkArguments(args, 3);
                            dato = SerController.checkNumber(args[2]);
                            p.modificarSer(args[1], dato);
                            System.out.println(PropiertesController.getInstance().getPropiertie("SER_MODIFICADO"));
                            break;
                        case "P":
                            checkArguments(args, 2);
                            Especie e = new Especie();
                            e.setNameEspecie(args[1]);
                            System.out.println(p.devolverEspecie(e));
                            break;
                        case "X":
                            checkArguments(args, 1);
                            salir = false;
                            break;
                        case "I":
                            checkArguments(args, 2);
                            PropiertesController pro = PropiertesController.getInstance();
                            switch (args[1].toLowerCase()) {
                                case "ca":
                                    pro.setIdioma(PropiertesController.CA);
                                    break;
                                case "es":
                                    pro.setIdioma(PropiertesController.ES);
                                    break;
                                case "en":
                                    pro.setIdioma(PropiertesController.EN);
                                    break;
                                default:
                                    throw new ErroresLogica(ErroresLogica.ERROR_004);
                            }
                            System.out.println(PropiertesController.getInstance().getPropiertie("IDIOMA_CAMBIADO"));
                            break;
                        default:
                            throw new ErroresLogica(ErroresLogica.ERROR_009);
                    }
                } catch (ErroresLogica ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (ErroresPersistencia ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkArguments(String[] data, int argumentos) throws ErroresLogica {
        if (data.length != argumentos) {
            throw new ErroresLogica(ErroresLogica.ERROR_001);
        }
    }
}
