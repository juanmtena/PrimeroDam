package models;

public interface IPaquete {

    public final int MAXCARACTERES = 250;
    public final int MAXCARACTEREDESC = 1000;
    public String getSIdPaquete();
    public void setSIdPaquete(String sIdPaquete);
    public String getSDescripcion();
    public void setSDescripcion(String sDescripcion);
    public TipoPaquete getOTipoPaquete();
    public void setOTipoPaquete(TipoPaquete oTipoPaquete);
    public String toString();
    public boolean checkPaquete();

}