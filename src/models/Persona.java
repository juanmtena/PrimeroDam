package models;

import java.util.regex.Pattern;

public abstract class Persona implements IPersona {

	private String sDni; // PK
	private String sNombre, sApellidos, sFechaNacimiento, sTelefono, sDireccion, sProvincia, sPais; // NN
	private Usuario oUsuario; // FK

	public Persona(String sDni) {
		setsDni(sDni);
	}

	public Persona(String sDni, String sNombre, String sApellidos, String sFechaNacimiento, String sDireccion, String sProvincia, String sPais, String sTelefono, Usuario oUsuario) {
		setsDni(sDni);
		setsNombre(sNombre);
		setsApellidos(sApellidos);
        setsFechaNacimiento(sFechaNacimiento);
        setsTelefono(sTelefono);
        setsDireccion(sDireccion);
        setsProvincia(sProvincia);
        setsPais(sPais);
		setoUsuario(oUsuario);
	}

	public String getsDni() {
		return sDni;
	}

	public void setsDni(String sDni) {
		String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
		if (Pattern.matches(dniRegexp, sDni)) {
			this.sDni = sDni;
		}
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		if (sNombre != null && !sNombre.isEmpty() && sNombre.length() < MAXCARACTERES) {
			this.sNombre = sNombre;
		}
	}

	public String getsApellidos() {
		return sApellidos;
	}

	public void setsApellidos(String sApellidos) {
		if (sApellidos != null && !sApellidos.isEmpty() && sApellidos.length() < MAXCARACTERES) {
			this.sApellidos = sApellidos;
		}
	}

	public String getsFechaNacimiento() {
        return sFechaNacimiento;
    }

    public void setsFechaNacimiento(String sFechaNacimiento) {
        this.sFechaNacimiento = sFechaNacimiento;
    }

	public String getsProvincia() {
        return sProvincia;
    }

    public void setsProvincia(String sProvincia) {
        if (sProvincia != null && !sProvincia.isEmpty() && sProvincia.length() < MAXCARACTERES) {
			this.sProvincia = sProvincia;
		}
    }

    public String getsTelefono() {
		return sTelefono;
	}

	public void setsTelefono(String sTelefono) {
		if (sTelefono != null && !sTelefono.isEmpty() && sTelefono.length() == 9)
			this.sTelefono = sTelefono;
	}

	public String getsDireccion() {
        return sDireccion;
    }

    public void setsDireccion(String sDireccion) {
        if (sDireccion != null && !sDireccion.isEmpty() && sDireccion.length() < MAXCARACTERES) {
			this.sDireccion = sDireccion;
		}
    }

    public String getsPais() {
        return sPais;
    }

    public void setsPais(String sPais) {
        if (sPais != null && !sPais.isEmpty() && sPais.length() < MAXCARACTERES) {
			this.sPais = sPais;
		}
    }

    public Usuario getoUsuario() {
		return oUsuario;
	}

	public void setoUsuario(Usuario oUsuario) {
		this.oUsuario = oUsuario;
	}

	public String toString() {
		String sResultado = "";
		if (checkPersona()) {
            sResultado += "##### USUARIO #####\nUsuario: \n\n";
			sResultado += "Usuario: " + this.getoUsuario().getsEmail() + "\n";
			sResultado += "DNI: " + this.getsDni() + "\n";
			sResultado += "Nombre: " + this.getsNombre() + " " + this.getsApellidos() + "\n";
            sResultado += "FechaNacimiento: " + this.getsFechaNacimiento() + "\n";
            sResultado += "Telefono: " + this.getsTelefono() + "\n";
            sResultado += "Direccion: " + this.getsDireccion() + "\n";
            sResultado += "Provincia: " + this.getsProvincia() + "\n";
            sResultado += "Pais: " + this.getsPais() + "\n";
		}

		return sResultado;
	}

	public boolean checkPersona() {
		boolean bExito = false;
		if (this.getsDni() != null && this.getsNombre() != null && this.getsApellidos() != null
				&& this.getoUsuario() != null && this.getoUsuario().checkUsuario()) {
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sDni == null) ? 0 : sDni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Cliente oCliente = (Cliente) obj;
		if (oCliente.getsDni() != null && this.getsDni() != null && this.getsDni().equals(oCliente.getsDni())) {
			bExito = true;
		}
		return bExito;
	}

}