package models;

public interface IMonumento {
    
    public final int MAXCARACTERES = 250;
    public String getSNombreMonumento();
    public void setSNombreMonumento(String sNombreMonumento);
    public String getSDireccion();
    public void setSDireccion(String sDireccion);
    public Ciudad getOCiudad();
    public void setOCiudad(Ciudad oCiudad);
    public String toString();
    public boolean checkMonumento();

}
