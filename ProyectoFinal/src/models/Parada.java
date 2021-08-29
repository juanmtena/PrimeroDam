package models;

public class Parada implements IParada {

    private String sNumeroParada; // PK
    private String sNombreParada; // NN
    private String sDescripcion; // NN
    private Ruta oRuta; // FK
    private Ubicacion oUbicacion; // FK

    public Parada(String sNombreParada) {
        setSNombreParada(sNombreParada);
    }

    public Parada(String sNumeroParada, String sNombreParada, String sDescripcion, Ruta oRuta, Ubicacion oUbicacion) {
        setsNumeroParada(sNumeroParada);
        setSNombreParada(sNombreParada);
        setSDescripcion(sDescripcion);
        setoRuta(oRuta);
        setOUbicacion(oUbicacion);
    }

    public String getsNumeroParada() {
        return sNumeroParada;
    }

    public void setsNumeroParada(String sNumeroParada) {
        if (sNumeroParada != null && sNumeroParada.isEmpty() && sNumeroParada.length() < MAXNUMEROPARADAS) {
            this.sNumeroParada = sNumeroParada;
        }
    }

    public String getSNombreParada() {
        return this.sNombreParada;
    }

    public void setSNombreParada(String sNombreParada) {
        if (sNombreParada != null && !sNombreParada.isEmpty() && sNombreParada.length() < MAXCARACTERES) {
            this.sNombreParada = sNombreParada;
        }
    }

    public String getSDescripcion() {
        return this.sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        if (sDescripcion != null && !sDescripcion.isEmpty() && sDescripcion.length() < MAXDESCRIPCION) {
            this.sDescripcion = sDescripcion;
        }
    }

    public Ruta getoRuta() {
        return oRuta;
    }

    public void setoRuta(Ruta oRuta) {
        this.oRuta = oRuta;
    }

    public Ubicacion getOUbicacion() {
        return this.oUbicacion;
    }

    public void setOUbicacion(Ubicacion oUbicacion) {
        this.oUbicacion = oUbicacion;
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### DETALLES DE LA PARADA #####\n";
        sResultado += "Numero de Parada: " + getsNumeroParada() + "\n";
        sResultado += "Nombre de la Parada: " + getSNombreParada() + "\n";
        sResultado += "Descripcion: " + getSDescripcion() + "\n\n";
        sResultado += getoRuta() + "\n";
        sResultado += getOUbicacion() + "\n";

        return sResultado;
    }

    public boolean checkParada() {
        boolean bExito = false;
        if (this.getsNumeroParada() != null && this.getSDescripcion() != null
                && this.getOUbicacion().checkUbicacion() && this.getoRuta().checkRuta()) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNumeroParada == null) ? 0 : sNumeroParada.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Parada oParada = (Parada) obj;
        if (oParada.getsNumeroParada() != null && this.getsNumeroParada() != null
                && this.getsNumeroParada().equals(oParada.getsNumeroParada())) {
            bExito = true;
        }
        return bExito;
    }

}