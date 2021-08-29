package views;

import controllers.*;

public class MonumentosSVQ {

	public static void main(String[] args) throws Exception {

		byte bOpcion;
		Controller oCtrl = new Controller();

		if (oCtrl.init()) {
			do {
				bOpcion = menu();

				switch (bOpcion) {
				case 1: // Gestion de usuarios
					UsuarioView.gestionUsuarios(oCtrl);
					break;
				case 2: // Gestion de Paises
					PaisView.gestionPais(oCtrl);
					break;
				case 3: // Gestion Metodo de Pago
					MetodoPagoView.gestionMetodoPago(oCtrl);
					break;
				case 4: // Gestion Ubicacion
					UbicacionView.gestionUbicacion(oCtrl);
					break;
				case 5: // Gestion de Usuarios
					ClienteView.gestionClientes(oCtrl);
					break;
				case 6: // Gestion de Ciudades
					CiudadView.gestionCiudad(oCtrl);
					break;
				case 7: // Gestion de Tipo de Paquetes
					TipoPaqueteView.gestionTipoPaquete(oCtrl);
					break;
				case 8: // Gestion de Monumentos
					MonumentoView.gestionMonumento(oCtrl);
					break;
				case 9: // Gestion de Rutas
					RutaView.gestionRuta(oCtrl);
					break;
				case 10: // Gestion de Pagos
					PagoView.gestionPago(oCtrl);
					break;
				case 11: // Gestion de Paradas
					ParadaView.gestionParada(oCtrl);
					break;
				default:
					System.out.println("Hasta pronto.");
				}

			} while (bOpcion != 12);
			oCtrl.closeDb();
		} else {
			System.out.println("Error al conectar con la base de datos.");
		}
	}

	public static byte menu() {

		System.out.println("##################################");
		System.out.println("Bienvenido a Monumentos SVQ");
		System.out.println("##################################");
		System.out.println("   1. Gestion de Usuarios");
		System.out.println("   2. Gestion de Paises");
		System.out.println("   3. Gestion Metodo de Pago");
		System.out.println("   4. Gestion Ubicacion");
		System.out.println("   5. Gestion Clientes");
		System.out.println("   6. Gestion de Ciudades");
		System.out.println("   7. Gestion de Tipo de Paquetes");
		System.out.println("   8. Gestion de Monumentos");
		System.out.println("   9. Gestion de Rutas");
		System.out.println("  10. Gestion de Pagos");
		System.out.println("  11. Gestion de Paradas");
		System.out.println("  12. Salir");

		return (byte) Libreria.leer("Introduce una opcion", 1, 12, -1, -1, (byte) 1);
	}
}