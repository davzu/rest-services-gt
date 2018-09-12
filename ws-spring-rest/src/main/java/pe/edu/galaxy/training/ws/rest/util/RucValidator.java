package pe.edu.galaxy.training.ws.rest.util;

public class RucValidator {

	public static boolean validar(String ruc) {
		if (ruc.trim().length() != 11) {
			return false;
		}

		for (int i = 0; i < ruc.length(); i++) {
			char c = ruc.charAt(i);
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		String prefijo = ruc.substring(0, 2);

		if (!(prefijo.equals("10") || prefijo.equals("20"))) {
			return false;
		}

		return true;
	}
	
	public static void main (String[] args) {
		String ruc = "10111111111";
		System.out.println(validar(ruc));
	}

}
