package exceptiones;

import propierties.PropiertesController;

/**
 *
 * @author polmonleonvives
 */
public class ErroresPersistencia extends Exception {
    private final int cogigoError;

    public static final int ERROR_CERRAR = 1;
    public static final int ERROR_LEER = 2;
    public static final int ERROR_ESCRIBIR = 3;

    public ErroresPersistencia(int cogigoError) {
        this.cogigoError = cogigoError;
    }

    @Override
    public String getMessage() {
        switch(this.cogigoError){
            case ERROR_CERRAR:
                return PropiertesController.getInstance().getPropiertie("ERROR_CERRAR");
            case ERROR_LEER:
                return PropiertesController.getInstance().getPropiertie("ERROR_LEER");
            case ERROR_ESCRIBIR:
                return PropiertesController.getInstance().getPropiertie("ERROR_ESCRIBIR");
            default:
                return super.getMessage();
        }
    }
    
}
