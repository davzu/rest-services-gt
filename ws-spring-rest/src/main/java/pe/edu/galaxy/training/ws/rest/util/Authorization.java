package pe.edu.galaxy.training.ws.rest.util;

import org.apache.commons.codec.binary.Base64;

public class Authorization {

	public static String[] validarAutorizacion(String str) {
		System.out.println(str);
		String[] ret = new String[2];
		String sb = str.substring(str.lastIndexOf(" ") + 1);
		System.out.println(sb);

		try {
			Base64 decoder = new Base64();
			byte[] bytes = decoder.decode(sb);
			String decode = new String(bytes);
			System.out.println(decode);
			String strUsuario = decode.substring(0, decode.indexOf(':'));
			String strClave = decode.substring(decode.indexOf(':') + 1);
			System.out.println("usuario: " + strUsuario);
			System.out.println("clave: " + strClave);
			ret[0] = strUsuario;
			ret[1] = strClave;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return ret;
	}

}
