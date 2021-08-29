package models;

public class Monumento implements IMonumento {

    private String sNombreMonumento; // PK
    private String sDireccion; // NN
    private Ciudad oCiudad; // FK

    public Monumento(String sNombreMonumento) {
        setSNombreMonumento(sNombreMonumento);
    }

    public Monumento(String sNombreMonumento, String sDireccion) {
        setSNombreMonumento(sNombreMonumento);
        setSDireccion(sDireccion);
    }

    public Monumento(String sNombreMonumento, String sDireccion, Ciudad oCiudad) {
        setSNombreMonumento(sNombreMonumento);
        setSDireccion(sDireccion);
        setOCiudad(oCiudad);
    }

    public String getSNombreMonumento() {
        return this.sNombreMonumento;
    }

    public void setSNombreMonumento(String sNombreMonumento) {
        if (sNombreMonumento != null && !sNombreMonumento.isEmpty() && sNombreMonumento.length() < MAXCARACTERES) {
            this.sNombreMonumento = sNombreMonumento;
        }
    }

    public String getSDireccion() {
        return this.sDireccion;
    }

    public void setSDireccion(String sDireccion) {
        if (sDireccion != null && !sDireccion.isEmpty() && sDireccion.length() < MAXCARACTERES) {
            this.sDireccion = sDireccion;
        }
    }

    public Ciudad getOCiudad() {
        return this.oCiudad;
    }

    public void setOCiudad(Ciudad oCiudad) {
        this.oCiudad = oCiudad;
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### MONUMENTO #####\n";
        sResultado += "Nombre del Monumento: " + getSNombreMonumento() + "\n";
        sResultado += "Direccion: " + getSDireccion() + "\n\n";
        sResultado += getOCiudad() + "\n";

        return sResultado;
    }

    public boolean checkMonumento() {
        boolean bExito = false;
        if (this.getSNombreMonumento() != null && this.getSDireccion() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Monumento oMonumento = (Monumento) obj;
        if (oMonumento.getSNombreMonumento() != null && this.getSNombreMonumento() != null
                && this.getSNombreMonumento().equals(oMonumento.getSNombreMonumento())) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombreMonumento == null) ? 0 : sNombreMonumento.hashCode());
        return result;
    }

}
