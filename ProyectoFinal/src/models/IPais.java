package models;

public interface IPais {
    
    public final int MAXCARACTERES = 250;
    public String getSNombrePais();
    public void setSNombrePais(String sNombrePais);
    public String toString();
    public boolean checkPais();

}
