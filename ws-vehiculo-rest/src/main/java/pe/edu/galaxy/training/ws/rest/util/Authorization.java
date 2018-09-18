package pe.edu.galaxy.training.ws.rest.util;

import org.apache.commons.codec.binary.Base64;
import pe.edu.galaxy.training.ws.rest.entity.Usuario;

public class Authorization {

    public static Usuario getUsuarioFromBasicAuth(String str) {
        Usuario usuario = null;
        System.out.println(str);
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

            usuario = new Usuario();
            usuario.setId(strUsuario);
            usuario.setClave(strClave);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

}
