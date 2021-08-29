package models;

public class Ruta implements IRuta {

    private String sIdRuta; // PK
    private String sNombreRuta, sDuracion; // NN
    private Parada oParada; // FK

    public Ruta(String sNombreRuta) {
        setSIdRuta(sIdRuta);
    }

    public Ruta(String sIdRuta, String sNombreRuta, String sDuracion, Parada oParada) {
        setSIdRuta(sIdRuta);
        setSNombreRuta(sNombreRuta);
        setSDuracion(sDuracion);
        setoParada(oParada);
    }

    public String getSIdRuta() {
        return this.sIdRuta;
    }

    public void setSIdRuta(String sIdRuta) {
        if (sIdRuta != null && !sIdRuta.isEmpty() && sIdRuta.length() <= 6) {
            this.sIdRuta = sIdRuta;
        }
    }

    public String getSNombreRuta() {
        return this.sNombreRuta;
    }

    public void setSNombreRuta(String sNombreRuta) {
        if (sNombreRuta != null && !sNombreRuta.isEmpty() && sNombreRuta.length() < MAXCARACTERES) {
            this.sNombreRuta = sNombreRuta;
        }
    }

    public String getSDuracion() {
        return this.sDuracion;
    }

    public void setSDuracion(String sDuracion) {
        if (sDuracion != null && !sDuracion.isEmpty() && sDuracion.length() < MAXCARACTERESDESC) {
            this.sDuracion = sDuracion;
        }
    }

    public Parada getoParada() {
        return oParada;
    }

    public void setoParada(Parada oParada) {
        this.oParada = oParada;
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### DETALLES DE LA RUTA #####\n";
        sResultado += "ID de la Ruta: " + getSIdRuta() + "\n";
        sResultado += "Nombre de la Ruta: " + getSNombreRuta() + "\n";
        sResultado += "Duracion: " + getSDuracion() + "\n";
        sResultado +=  getoParada() + "\n\n";

        return sResultado;
    }

    public boolean checkRuta() {
        boolean bExito = false;
        if (this.getSIdRuta() != null && this.getSNombreRuta() != null && this.getSDuracion() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sIdRuta == null) ? 0 : sIdRuta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Ruta oRuta = (Ruta) obj;
        if (oRuta.getSIdRuta() != null && this.getSIdRuta() != null && this.getSIdRuta().equals(oRuta.getSIdRuta())) {
            bExito = true;
        }
        return bExito;
    }

}
