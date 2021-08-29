package views;

import controllers.Controller;
import models.Usuario;

public class UsuarioView {

	public static byte subMenuUsuario() {

		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de Usuario");
		System.out.println("-----------------------");
		System.out.println("1. Crear Usuario");
		System.out.println("2. Buscar Usuario");
		System.out.println("3. Borrar Usuario");
		System.out.println("4. Cambiar contraseña");
		System.out.println("5. Entrar");
		System.out.println("6. Volver atras");

		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
	}

	public static void gestionUsuarios(Controller oCtrl) {
		switch (UsuarioView.subMenuUsuario()) {
		case 1: // Crear
			if (create(oCtrl)) {
				System.out.println("El Usuario ha sido creado con exito.");
			} else {
				System.out.println("El Usuario no se ha podido crear.");
			}
			break;
		case 2: // Buscar
			Usuario oUsuario = searchUsuario(oCtrl);
			if (oUsuario != null) {
				System.out.println("El Usuario existe en la base de datos.");
			} else {
				System.out.println("El usuario no existe en la base de datos.");
			}
			break;
		case 3: // Borrar
			if (remove(oCtrl)) {
				System.out.println("El usuario ha sido eliminado con exito.");
			} else {
				System.out.println("El usuario no se ha podido eliminar.");
			}
			break;
		case 4: // Modificar contraseña
			if (update(oCtrl)) {
				System.out.println("La contrasena ha sido cambiada con exito.");
			} else {
				System.out.println("La contrasena no se ha podido cambiar.");
			}
			break;
		case 5: // Login
			if (update(oCtrl)) {
				System.out.println("Bienvenido.");
			} else {
				System.out.println("El usuario no existe en la base de datos.");
			}
			break;
		}
	}

	// Crear
	private static boolean create(Controller oCtrl) {
		String sEmail, sPassword;

		System.out.println("\nIntroduce los datos del usuario");
		sEmail = String.valueOf(Libreria.leer("Introduce un eMail: ", 1, 250, -1, -1, (byte) 6));
		sPassword = String.valueOf(Libreria.leer("Introduce una contrasena: ", 5, 12, -1, -1, (byte) 6));

		return oCtrl.getOPersonasCtrl().getoUserCtrl().add(new Usuario(sEmail, sPassword));
	}

	// Buscar
	private static Usuario searchUsuario(Controller oCtrl) {
		String sEmail = String.valueOf(Libreria.leer("Introduce un email", 1, 255, -1, -1, (byte) 6));
		return oCtrl.getOPersonasCtrl().getoUserCtrl().searchByPk(new Usuario(sEmail));
	}

	// Eliminar
	private static boolean remove(Controller oCtrl) {
		String sEmail = String.valueOf(Libreria.leer("Introduce un email", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOPersonasCtrl().getoUserCtrl().remove(new Usuario(sEmail, ""));
	}

	// Cambiar contraseña
	private static boolean update(Controller oCtrl) {
		String sEmail, sPassword;
		boolean bExito = false;

		sEmail = String.valueOf(Libreria.leer("Introduce un email", 0, 250, -1, -1, (byte) 6));
		sPassword = String.valueOf(Libreria.leer("Introduce la contrasena", 5, 12, -1, -1, (byte) 6));
		Usuario oUsuario = oCtrl.getOPersonasCtrl().getoUserCtrl().searchByPk(new Usuario(sEmail));

		if (oUsuario != null) {
			sPassword = String.valueOf(Libreria.leer("Introduce la nueva contrasena", 5, 12, -1, -1, (byte) 6));

			oUsuario.setsPassword(sPassword);

			bExito = oCtrl.getOPersonasCtrl().getoUserCtrl().update(oUsuario);
		}
		return bExito;
	}

	// Login
	/*
	 * private static Usuario login(Controller oCtrl) {
	 * oCtrl.searchUsuario(oUsuario);
	 * 
	 * }
	 */

}
