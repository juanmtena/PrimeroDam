package models;

public class Ciudad implements ICiudad {

    private String sNombreCiudad; // PK
    private Pais oPais; // FK

    public Ciudad(String sNombreCiudad) {
        setSNombreCiudad(sNombreCiudad);
    }

    public Ciudad(String sNombreCiudad, Pais oPais) {
        setSNombreCiudad(sNombreCiudad);
        setOPais(oPais);
    }

    public String getSNombreCiudad() {
        return this.sNombreCiudad;
    }

    public void setSNombreCiudad(String sNombreCiudad) {
        if (sNombreCiudad != null && !sNombreCiudad.isEmpty() && sNombreCiudad.length() < MAXCARACTERES) {
            this.sNombreCiudad = sNombreCiudad;
        }
    }

    public Pais getOPais() {
        return this.oPais;
    }

    public void setOPais(Pais oPais) {
        this.oPais = oPais;
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### CIUDAD #####\n";
        sResultado += "Nombre de la Ciudad: " + getSNombreCiudad() + "\n\n";
        sResultado += getOPais() + "\n";

        return sResultado;
    }

    public boolean checkCiudad() {
        boolean bExito = false;
        if (this.getSNombreCiudad() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Ciudad oCiudad = (Ciudad) obj;
        if (oCiudad.getSNombreCiudad() != null && this.getSNombreCiudad() != null
                && this.getSNombreCiudad().equals(oCiudad.getSNombreCiudad())) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombreCiudad == null) ? 0 : sNombreCiudad.hashCode());
        return result;
    }

}
