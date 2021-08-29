package models;

public interface IParada {
    
    public final int MAXCARACTERES = 255;
    public final int MAXNUMEROPARADAS = 50;
    public final int MAXDESCRIPCION = 1000;
    public String getSNombreParada();
    public void setSNombreParada(String sNombreParada);
    public String getsNumeroParada();
    public void setsNumeroParada(String sNumeroParada);
    public String getSDescripcion();
    public void setSDescripcion(String sDescripcion);
    public Ubicacion getOUbicacion();
    public void setOUbicacion(Ubicacion oUbicacion);
    public Ruta getoRuta();
    public void setoRuta(Ruta oRuta);
    public String toString();
    public boolean checkParada();

}
