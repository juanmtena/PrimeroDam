package models;

public class Cliente extends Persona implements ICliente {
	
	public Cliente(String sDni) {
		super(sDni);
	}
	
	public Cliente(String sDni, String sNombre, String sApellidos, String sFechaNacimiento, 
			String sTelefono, String sDireccion, String sProvincia, String sPais, Usuario oUsuario) {
		super(sDni, sNombre, sApellidos, sFechaNacimiento, sTelefono, sDireccion, sProvincia, sPais, oUsuario);
	}
	
	public boolean checkCliente() {
		return super.checkPersona();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}