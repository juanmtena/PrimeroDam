package models;

public class MetodoPago implements IMetodoPago {

    private String sNombreMetodoPago; // PK

    public MetodoPago(String sNombreMetodoPago) {
        setSNombreMetodoPago(sNombreMetodoPago);
    }

    public String getSNombreMetodoPago() {
        return this.sNombreMetodoPago;
    }

    public void setSNombreMetodoPago(String sNombreMetodoPago) {
        if (sNombreMetodoPago != null && sNombreMetodoPago == "Tarjeta"
                || sNombreMetodoPago == "Paypal" && sNombreMetodoPago.length() < MAXCARACTERES) {
            this.sNombreMetodoPago = sNombreMetodoPago;
        }
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "Metodo de pago (Tarjeta o Paypal): " + getSNombreMetodoPago();

        return sResultado;
    }

    public boolean checkMetodoPago() {
        boolean bExito = false;
        if (this.getSNombreMetodoPago() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        MetodoPago oMetodoPago = (MetodoPago) obj;
        if (oMetodoPago.getSNombreMetodoPago() != null && this.getSNombreMetodoPago() != null
                && this.getSNombreMetodoPago().equals(oMetodoPago.getSNombreMetodoPago())) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombreMetodoPago == null) ? 0 : sNombreMetodoPago.hashCode());
        return result;
    }

}