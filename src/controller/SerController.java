/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptiones.ErroresLogica;
import modelo.Andoriano;
import modelo.Especie;
import modelo.Humano;
import modelo.Kinglon;
import modelo.Nibiriano;
import modelo.Vulcaniano;

/**
 *
 * @author polmonleonvives
 */
public class SerController {

    public static Especie devolverSer(String[] data) throws ErroresLogica {
        int dato;
        Especie ser = new Especie(data[1], data[0]);
        switch (ser.getNameEspecie()) {
            case "human":
                dato = checkNumber(data[2]);
                ser = new Humano(ser.getName(), dato);
                break;
            case "vulcan":
                dato = checkNumber(data[2]);
                ser = new Vulcaniano(dato, ser.getName());
                break;
            case "andorian":
                ser = new Andoriano(ser.getName(), chekType(data[2]));
                break;
            case "nibirian":
                ser = new Nibiriano(ser.getName(), chekType(data[2]));
                break;
            case "klingon":
                dato = checkNumber(data[2]);
                ser = new Kinglon(dato, ser.getName());
                break;
        }
        return ser;
    }

    public static int checkNumber(String i) throws ErroresLogica {
        try {
            return Integer.parseInt(i);
        } catch (NumberFormatException ex) {
            throw new ErroresLogica(ErroresLogica.ERROR_004);
        }
    }

    private static boolean chekType(String tipo) throws ErroresLogica {
        switch (tipo) {
            case "vegetarian":
            case "aenar":
                return true;
            case "novegetarian":
            case "noaenar":
                return false;
            default:
                throw new ErroresLogica(ErroresLogica.ERROR_004);
        }
    }
}
