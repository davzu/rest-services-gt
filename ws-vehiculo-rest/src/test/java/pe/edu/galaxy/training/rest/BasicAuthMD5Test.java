package pe.edu.galaxy.training.rest;

import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author User 1
 */
public class BasicAuthMD5Test {
    
    public BasicAuthMD5Test() {
    }
    
//    @Test
    public void coincidenciaClaves() throws IOException {
        String clave = "abcde12345";
        String claveCodificada = DigestUtils.md5Hex(clave);
        String claveCodificada2 = DigestUtils.md5Hex(clave);
        System.out.println("claveCodificada: " + claveCodificada);
        System.out.println("claveCodificada2: " + claveCodificada2);
        Assert.assertEquals(claveCodificada, claveCodificada2);
    }

//    @Test
    public void noCoincidenciaClaves() throws IOException {
        String clave = "abcde12345";
        String clave2 = "abcde12345xz91";
        String claveCodificada = DigestUtils.md5Hex(clave);
        String claveCodificada2 = DigestUtils.md5Hex(clave2);
        System.out.println("claveCodificada: " + claveCodificada);
        System.out.println("claveCodificada2: " + claveCodificada2);
        Assert.assertFalse(claveCodificada.equals(claveCodificada2));
    }
    
}
