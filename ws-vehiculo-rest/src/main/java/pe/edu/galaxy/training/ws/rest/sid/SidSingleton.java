package pe.edu.galaxy.training.ws.rest.sid;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class SidSingleton {

    @Resource(name = "propertiesHttpResponseCod")
    private Properties propertiesHttpResponseCod;

    private Map<String, Entry<String, String>> mapCodigosRespuestaHttp;

    public SidSingleton() {
    }

    @PostConstruct
    public void init() {
        buildMapCodigosRespuestaHttp();
    }

    private void buildMapCodigosRespuestaHttp() {
        String[] respuestaHttp;
        Map<String, String> mapTemp = null;
        Entry<String, String> entryRespuestaHttp = null;
        try {
            mapCodigosRespuestaHttp = new HashMap<>();
            for (String key : propertiesHttpResponseCod.stringPropertyNames()) {
                mapTemp = new HashMap<>();
                respuestaHttp = propertiesHttpResponseCod.getProperty(key).split(":");
                entryRespuestaHttp = new SimpleEntry<>(respuestaHttp[0], respuestaHttp[1]);
                mapCodigosRespuestaHttp.put(key, entryRespuestaHttp);
            }
        } finally {
            propertiesHttpResponseCod = null;
        }
    }

    public Entry<String, String> getEntryRespuestaHttp(String key) {
        return mapCodigosRespuestaHttp.get(key);
    }

}
