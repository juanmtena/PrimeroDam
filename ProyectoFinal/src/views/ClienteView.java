package views;

import controllers.Controller;
import models.Cliente;
import models.Usuario;

public class ClienteView {
	public static byte subMenuClientes() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de Clientes");
		System.out.println("-----------------------");
		System.out.println("1. Alta Cliente");
		System.out.println("2. Modificar datos Cliente");
		System.out.println("3. Buscar Cliente");
		System.out.println("4. Borrar Cliente");
		System.out.println("5. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
	}

	public static void gestionClientes(Controller oCtrl) {
		switch (ClienteView.subMenuClientes()) {
		case 1: // Alta
			if (create(oCtrl)) {
				System.out.println("El cliente ha sido creado con exito.");
			} else {
				System.out.println("El cliente no se ha podido crear.");
			}
			break;
		case 2: // Modificar
			if (update(oCtrl)) {
				System.out.println("El cliente ha sido modificado con exito.");
			} else {
				System.out.println("El cliente no se ha podido modificar.");
			}
			break;
		case 3: // Buscar
			Cliente oCliente = searchByDni(oCtrl);
			if (oCliente != null) {
				System.out.println("El cliente buscado existe en la base de datos.");
				System.out.println(oCliente);
			} else {
				System.out.println("El cliente no existe en la base de datos.");
			}
			break;
		case 4: // Borrar
			if (remove(oCtrl)) {
				System.out.println("El cliente ha sido eliminado con exito.");
			} else {
				System.out.println("El cliente no se ha podido eliminar.");
			}
			break;
		}
	}

	private static boolean create(Controller oCtrl) {
		String sDni, sNombre, sApellidos, sFechaNacimiento, sDireccion, sPais, sProvincia, sTelefono, sEmail, sPass;

		System.out.println("Introduce los datos basicos del cliente: ");
		sDni = String.valueOf(Libreria.leer("Introduce un dni (12345678A)", 9, 9, -1, -1, (byte) 6));
		sNombre = String.valueOf(Libreria.leer("Introduce un nombre", 1, 250, -1, -1, (byte) 6));
		sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos", 1, 250, -1, -1, (byte) 6));
		sFechaNacimiento = String
				.valueOf(Libreria.leer("Introduce una fecha de nacimiento (dd/mm/aaaa)", 0, 16, -1, -1, (byte) 6));

		System.out.println("\nIntroduce ahora los datos del usuario asociado: ");
		sEmail = String.valueOf(Libreria.leer("Introduce un eMail", 1, 250, -1, -1, (byte) 6));
		sPass = String.valueOf(Libreria.leer("Introduce una contrasena", 5, 12, -1, -1, (byte) 6));

		sDireccion = String.valueOf(Libreria.leer("Introduce una direccion", 0, 250, -1, -1, (byte) 6));
		sPais = String.valueOf(Libreria.leer("Introduce un pais", 0, 250, -1, -1, (byte) 6));
		sProvincia = String.valueOf(Libreria.leer("Introduce una provinicia", 0, 250, -1, -1, (byte) 6));
		sTelefono = String.valueOf(Libreria.leer("Introduce un telefono", 0, 9, -1, -1, (byte) 6));

		return oCtrl.getOPersonasCtrl().getoClientCtrl().add(new Cliente(sDni, sNombre, sApellidos, sFechaNacimiento,
				sDireccion, sProvincia, sPais, sTelefono, new Usuario(sEmail, sPass)));
	}

	private static boolean update(Controller oCtrl) {
		String sDni, sNombre, sApellidos, sFechaNacimiento, sDireccion, sPais, sProvincia, sTelefono;
		boolean bExito = false;
		sDni = String.valueOf(Libreria.leer("Introduce un DNI", 9, 9, -1, -1, (byte) 6));
		Cliente oCliente = oCtrl.getOPersonasCtrl().searchCliente(new Cliente(sDni));
		
		if (oCliente != null) {

			sNombre = String.valueOf(
					Libreria.leer("Introduce un nombre (" + oCliente.getsNombre() + ")", 0, 250, -1, -1, (byte) 6));
			oCliente.setsNombre(sNombre);

			sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oCliente.getsApellidos() + ")", 0,
					250, -1, -1, (byte) 6));
			oCliente.setsApellidos(sApellidos);

			sFechaNacimiento = String
					.valueOf(Libreria.leer("Introduce una fecha de nacimiento (" + oCliente.getsFechaNacimiento() + ")",
							0, 250, -1, -1, (byte) 6));
			oCliente.setsFechaNacimiento(sFechaNacimiento);

			sDireccion = String.valueOf(Libreria.leer("Introduce una direccion (" + oCliente.getsDireccion() + ")", 0,
					250, -1, -1, (byte) 6));
			oCliente.setsDireccion(sDireccion);

			sPais = String.valueOf(
					Libreria.leer("Introduce un pais (" + oCliente.getsPais() + ")", 0, 250, -1, -1, (byte) 6));
			oCliente.setsPais(sPais);

			sProvincia = String.valueOf(Libreria.leer("Introduce una provincia (" + oCliente.getsProvincia() + ")", 0,
					250, -1, -1, (byte) 6));
			oCliente.setsProvincia(sProvincia);

			sTelefono = String.valueOf(
					Libreria.leer("Introduce un telefono (" + oCliente.getsTelefono() + ")", 0, 9, -1, -1, (byte) 6));
			oCliente.setsTelefono(sTelefono);

			bExito = oCtrl.getOPersonasCtrl().getoClientCtrl().update(oCliente);
		}
		return bExito;
	}

	private static Cliente searchByDni(Controller oCtrl) {
		String sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte) 6));
		return oCtrl.getOPersonasCtrl().searchCliente(new Cliente(sDni));
	}

	private static boolean remove(Controller oCtrl) {
		String sEmail = String.valueOf(Libreria.leer("Introduce un email", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOPersonasCtrl().getoUserCtrl().remove(new Usuario(sEmail, ""));
	}
}
