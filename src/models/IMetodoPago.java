package models;

public interface IMetodoPago {
    
    public final int MAXCARACTERES = 100;
    public String getSNombreMetodoPago();
    public void setSNombreMetodoPago(String sNombreMetodoPago);
    public String toString();
    public boolean checkMetodoPago();

}
