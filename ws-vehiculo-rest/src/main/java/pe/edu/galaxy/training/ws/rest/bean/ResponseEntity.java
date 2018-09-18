package pe.edu.galaxy.training.ws.rest.bean;

import java.util.Map.Entry;

public class ResponseEntity {

    private String codigo;

    private String mensaje;

    private Object data;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setRespuestaHttp(Entry<String, String> entry) {
        codigo = entry.getKey();
        mensaje = entry.getValue();
    }

}
