package models;

public interface ICiudad {

    public final int MAXCARACTERES = 250;
    public String getSNombreCiudad();
    public void setSNombreCiudad(String sNombreCiudad);
    public Pais getOPais();
    public void setOPais(Pais oPais);
    public String toString();
    public boolean checkCiudad();

}
