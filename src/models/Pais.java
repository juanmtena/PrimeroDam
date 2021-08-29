package models;

public class Pais implements IPais {

    private String sNombrePais; // PK

    public Pais(String sNombrePais) {
        setSNombrePais(sNombrePais);
    }

    public String getSNombrePais() {
        return this.sNombrePais;
    }

    public void setSNombrePais(String sNombrePais) {
        if (sNombrePais != null && !sNombrePais.isEmpty() && sNombrePais.length() < MAXCARACTERES) {
            this.sNombrePais = sNombrePais;
        }
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### PAIS #####\n";
        sResultado += "Nombre del Pais: " + getSNombrePais();

        return sResultado;
    }

    public boolean checkPais() {
        boolean bExito = false;
        if (this.getSNombrePais() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Pais oPais = (Pais) obj;
        if (oPais.getSNombrePais() != null && this.getSNombrePais() != null
                && this.getSNombrePais().equals(oPais.getSNombrePais())) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombrePais == null) ? 0 : sNombrePais.hashCode());
        return result;
    }

}
