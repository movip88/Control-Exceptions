package exceptiones;

import propierties.PropiertesController;

/**
 *
 * @author polmonleonvives
 */
public class ErroresLogica extends Exception{
    private final int cogigoError;
    
    public static final int ERROR_001 = 1;
    public static final int ERROR_002 = 2;
    public static final int ERROR_003 = 3;
    public static final int ERROR_004 = 4;
    public static final int ERROR_005 = 5;
    public static final int ERROR_006 = 6;
    public static final int ERROR_007 = 7;
    public static final int ERROR_008 = 8;
    public static final int ERROR_009 = 9;
    public static final int ERROR_010 = 10;
    public static final int ERROR_011 = 11;
    public static final int ERROR_012 = 12;
    
    public ErroresLogica(int cogigoError) {
        this.cogigoError = cogigoError;
    }

    @Override
    public String getMessage() {
        PropiertesController pro = PropiertesController.getInstance();
        return pro.getPropiertie("ERROR_"+cogigoError);
    }
}