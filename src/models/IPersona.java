package models;

public interface IPersona {
	public final int MAXCARACTERES = 250;
	public String getsDni();
	public void setsDni(String sDni);
	public String getsNombre();
	public void setsNombre(String sNombre);
	public String getsApellidos();
	public void setsApellidos(String sApellidos);
	public String getsFechaNacimiento();
    public void setsFechaNacimiento(String sFechaNacimiento);
	public String getsProvincia();
    public void setsProvincia(String sProvincia);
    public String getsTelefono();
	public void setsTelefono(String sTelefono);
	public String getsDireccion();
    public void setsDireccion(String sDireccion);
    public String getsPais();
    public void setsPais(String sPais);
    public Usuario getoUsuario();
	public void setoUsuario(Usuario oUsuario);
	public String toString();
	public boolean checkPersona();	
}
