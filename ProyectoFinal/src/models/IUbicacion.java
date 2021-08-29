package models;

public interface IUbicacion {
    
    public final int COORDENADAS = 8;
    public String getSCoordenadas();
    public void setSCoordenadas(String sCoordenadas);
    public String toString();
    public boolean checkUbicacion();

}
