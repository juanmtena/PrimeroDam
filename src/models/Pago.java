package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pago implements IPago {

    private String sIdPago; // PK
    private String sFechaPago; // NN
    private MetodoPago oMetodoPago; // FK
    private Paquete oPaquete; // FK
    private Cliente oCliente; // FK

    public Pago(String sIdPago) {
        setSIdPago(sIdPago);
    }

    public Pago(String sIdPago, String sFechaPago) {
        setSIdPago(sIdPago);
        setSFechaPago(sFechaPago);
    }

    public Pago(String sIdPago, String sFechaPago, MetodoPago oMetodoPago, Paquete oPaquete, Cliente oCliente) {
        setSIdPago(sIdPago);
        setSFechaPago(sFechaPago);
        setOMetodoPago(oMetodoPago);
        setOPaquete(oPaquete);
        setOCliente(oCliente);
    }

    public String getSIdPago() {
        return this.sIdPago;
    }

    public void setSIdPago(String sIdPago) {
        if (sIdPago != null && !sIdPago.isEmpty() && sIdPago.length() < MAXCARACTERES) {
            this.sIdPago = sIdPago;
        }
    }

    public String getSFechaPago() {
        return this.sFechaPago;
    }

    public void setSFechaPago(String sFechaPago) {
        if (isDateValid(sFechaPago) == true) {
            this.sFechaPago = sFechaPago;
        }
    }

    public MetodoPago getOMetodoPago() {
        return this.oMetodoPago;
    }

    public void setOMetodoPago(MetodoPago oMetodoPago) {
        this.oMetodoPago = oMetodoPago;
    }

    public Paquete getOPaquete() {
        return this.oPaquete;
    }

    public void setOPaquete(Paquete oPaquete) {
        this.oPaquete = oPaquete;
    }

    public Cliente getOCliente() {
        return this.oCliente;
    }

    public void setOCliente(Cliente oCliente) {
        this.oCliente = oCliente;
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### PAGO #####\n";
        sResultado += getOMetodoPago() + "\n";
        sResultado += "ID del Pago: " + getSIdPago() + "\n";
        sResultado += "Fecha del Pago: " + getSFechaPago() + "\n\n";
        sResultado += getOPaquete() + "\n";
        sResultado += getOCliente() + "\n";

        return sResultado;
    }

    public boolean checkPago() {
        boolean bExito = false;
        if (this.getSIdPago() != null && this.getSFechaPago() != null && this.getOMetodoPago().checkMetodoPago()
                && this.getOPaquete().checkPaquete() && this.getOCliente().checkCliente()) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Pago oPago = (Pago) obj;
        if (oPago.getSIdPago() != null && this.getSIdPago() != null && this.getSIdPago().equals(oPago.getSIdPago())) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sIdPago == null) ? 0 : sIdPago.hashCode());
        return result;
    }

    // Metodo para validar fecha
    public boolean isDateValid(String sFechaPago) {
        boolean bExito = false;
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(sFechaPago);
            bExito = true;
        } catch (ParseException e) {
            bExito = false;
        }
        return bExito;
    }

}