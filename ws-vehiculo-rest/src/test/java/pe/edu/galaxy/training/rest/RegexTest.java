package pe.edu.galaxy.training.rest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class RegexTest {
    
    public RegexTest() {
    }
    
//    @Test
    public void formatoPlacaCorrecta() {
        String placa = "D3F-365";
        String patron = "[a-zA-Z0-9]{3}-[0-9]{3}";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(placa);
        boolean coincide = matcher.matches();
        Assert.assertTrue(coincide);
    }
    
//    @Test
    public void formatoPlacaIncorrecta() {
        String placa = "D3F-363D"; // D3F3635 D3FT-365 D3T-3635
        String patron = "[a-zA-Z0-9]{3}-[0-9]{3}";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(placa);
        boolean coincide = matcher.matches();
        Assert.assertTrue(!coincide);
    }
    
}
