package pe.edu.galaxy.training.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User 1
 */
public class BasicAuthMD5Test {

    public BasicAuthMD5Test() {
    }

//    @Test
    public void codificarString() throws IOException {
        String clave = "abcde12345";
//        InputStream inpStrClave = new ByteArrayInputStream(clave.getBytes());
//        String claveCodificada = DigestUtils.md5Hex(clave);
        String claveCodificada = Md5Crypt.md5Crypt(clave.getBytes());
        System.out.println("Clave codificada: " + claveCodificada);
        
        claveCodificada = Md5Crypt.md5Crypt(claveCodificada.getBytes(), clave,"$1$");
        System.out.println("Clave codificada: " + claveCodificada);
        
        
    }

//    @Test
    public void decodificarString() {

    }

}
