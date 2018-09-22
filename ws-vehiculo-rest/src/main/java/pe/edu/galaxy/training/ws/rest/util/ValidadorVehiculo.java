package pe.edu.galaxy.training.ws.rest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorVehiculo {

    private static final String PATRON_PLACA = "[a-zA-Z0-9]{3}-[0-9]{3}";
    private static final Pattern pattern;

    static {
        pattern = Pattern.compile(PATRON_PLACA);
    }

    public static boolean formatoPlacaValido(String placa) {
        boolean result = false;
        Matcher matcher = null;
        try {
            matcher = pattern.matcher(placa);
            result = matcher.matches();
        } finally {
            matcher = null;
        }

        return result;
    }

}
