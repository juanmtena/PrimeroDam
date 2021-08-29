package models;

public interface IPago {

    public final int MAXCARACTERES = 255;
    public final String DATE_FORMAT = "dd-MM-yyyy";
    public String getSIdPago();
    public void setSIdPago(String sIdPago);
    public String getSFechaPago();
    public void setSFechaPago(String sFechaPago);
    public MetodoPago getOMetodoPago();
    public void setOMetodoPago(MetodoPago oMetodoPago);
    public Paquete getOPaquete();
    public void setOPaquete(Paquete oPaquete);
    public Cliente getOCliente();
    public void setOCliente(Cliente oCliente);
    public String toString();
    public boolean checkPago();
    public boolean isDateValid(String sFechaPago);

}