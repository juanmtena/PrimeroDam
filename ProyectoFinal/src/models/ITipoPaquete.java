package models;

public interface ITipoPaquete {
    
    public final int MAXCARACTERENOMBRE = 255;
    public final int MAXCARACTEREDESC = 1000;
    public String getSNombrePaquete();
    public void setSNombrePaquete(String sNombrePaquete);
    public String toString();
    public boolean checkTipoPaquete();

}
