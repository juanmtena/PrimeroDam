package models;

public interface IRuta {

    public final int MAXCARACTERES = 100;
    public final int MAXCARACTERESDESC = 1000;
    public String getSIdRuta();
    public void setSIdRuta(String sIdRuta);
    public String getSNombreRuta();
    public void setSNombreRuta(String sNombreRuta);
    public String getSDuracion();
    public void setSDuracion(String sDuracion);
    public Parada getoParada();
    public void setoParada(Parada oParada);
    public String toString();
    public boolean checkRuta();

}