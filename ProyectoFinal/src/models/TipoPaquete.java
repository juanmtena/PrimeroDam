package models;

public class TipoPaquete implements ITipoPaquete {

    private String sNombrePaquete; // PK
    private String sDescripcion; // NN

    public TipoPaquete(String sNombrePaquete) {
        setSNombrePaquete(sNombrePaquete);
    }

    public TipoPaquete(String sNombrePaquete, String sDescripcion) {
        setSNombrePaquete(sNombrePaquete);
        setsDescripcion(sDescripcion);
    }

    public String getSNombrePaquete() {
        return this.sNombrePaquete;
    }

    public void setSNombrePaquete(String sNombrePaquete) {
        if (sNombrePaquete != null && !sNombrePaquete.isEmpty() && sNombrePaquete.length() < MAXCARACTERENOMBRE) {
            this.sNombrePaquete = sNombrePaquete;
        }
    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        if (sDescripcion != null && !sDescripcion.isEmpty() && sNombrePaquete.length() < MAXCARACTEREDESC) {
            this.sDescripcion = sDescripcion;
        }
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### TIPO DE PAQUETE #####\n";
        sResultado += "Tipo de Paquete: " + getSNombrePaquete() + "\n";
        sResultado += "Descripcion del Paquete: " +getsDescripcion() + "\n\n";

        return sResultado;
    }

    public boolean checkTipoPaquete() {
        boolean bExito = false;
        if (this.getSNombrePaquete() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        TipoPaquete oTipoPaquete = (TipoPaquete) obj;
        if (oTipoPaquete.getSNombrePaquete() != null && this.getSNombrePaquete() != null
                && this.getSNombrePaquete().equals(oTipoPaquete.getSNombrePaquete())) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombrePaquete == null) ? 0 : sNombrePaquete.hashCode());
        return result;
    }

}
