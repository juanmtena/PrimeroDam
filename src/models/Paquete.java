package models;

public class Paquete implements IPaquete {

    private String sIdPaquete; // PK
    private String sDescripcion; // N
    private TipoPaquete oTipoPaquete; // FK

    public Paquete(String sIdPaquete) {
        setSIdPaquete(sIdPaquete);
    }

    public Paquete(String sIdPaquete, TipoPaquete oTipoPaquete) {
        setSIdPaquete(sIdPaquete);
        setOTipoPaquete(oTipoPaquete);
    }

    public Paquete(String sIdPaquete, String sDescripcion, TipoPaquete oTipoPaquete) {
        setSIdPaquete(sIdPaquete);
        setSDescripcion(sDescripcion);
        setOTipoPaquete(oTipoPaquete);
    }

    public String getSIdPaquete() {
        return this.sIdPaquete;
    }

    public void setSIdPaquete(String sIdPaquete) {
        if (sIdPaquete != null && !sIdPaquete.isEmpty() && sIdPaquete.length() < MAXCARACTERES) {
            this.sIdPaquete = sIdPaquete;
        }
    }

    public String getSDescripcion() {
        return this.sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        if (sDescripcion != null && !sDescripcion.isEmpty() && sDescripcion.length() < MAXCARACTEREDESC) {
            this.sDescripcion = sDescripcion;
        }
    }

    public TipoPaquete getOTipoPaquete() {
        return this.oTipoPaquete;
    }

    public void setOTipoPaquete(TipoPaquete oTipoPaquete) {
        this.oTipoPaquete = oTipoPaquete;
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### DETALLES DEL PAQUETE #####\n";
        sResultado += "ID: " + getSIdPaquete() + "\n\n";
        if (getSDescripcion() != null) {
            sResultado += "Descripcion: " + getSDescripcion() + "\n\n";
        }        
        sResultado += getOTipoPaquete() + "\n";

        return sResultado;
    }

    public boolean checkPaquete() {
        boolean bExito = false;
        if (this.getSIdPaquete() != null && this.getSDescripcion() != null
                && this.getOTipoPaquete().checkTipoPaquete()) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Paquete oPaquete = (Paquete) obj;
        if (oPaquete.getSIdPaquete() != null && this.getSIdPaquete() != null
                && this.getSIdPaquete().equals(oPaquete.getSIdPaquete())) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sIdPaquete == null) ? 0 : sIdPaquete.hashCode());
        return result;
    }

}