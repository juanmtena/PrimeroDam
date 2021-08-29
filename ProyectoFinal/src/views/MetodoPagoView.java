package views;

import controllers.Controller;
import models.MetodoPago;

public class MetodoPagoView {
    
    public static byte subMenuMetodoPago() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de Metodo de Pago");
		System.out.println("-----------------------");
		System.out.println("1. Crear Metodo de Pago");
		System.out.println("2. Buscar Metodo de Pago");
		System.out.println("3. Borrar Metodo de Pago");
		System.out.println("4. Volver atras");
        
		return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);
	}

    public static void gestionMetodoPago(Controller oCtrl) {
		switch (MetodoPagoView.subMenuMetodoPago()) {
		case 1: // Crear
			if (create(oCtrl)) {
				System.out.println("El Metodo de Pago ha sido creado con exito.");
			} else {
				System.out.println("El Metodo de Pago no se ha podido crear.");
			}
			break;
		case 2: // Buscar
            MetodoPago oMetodoPago = searchMetodoPago(oCtrl);
			if (oMetodoPago != null) {
				System.out.println("El Metodo de Pago buscado existe en la base de datos.");
				System.out.println(oMetodoPago);
			} else {
				System.out.println("El Metodo de Pago no existe en la base de datos.");
			}
			break;
		case 3: // Borrar
			if (remove(oCtrl)) {
				System.out.println("El Metodo de Pago ha sido eliminado con exito.");
			} else {
				System.out.println("El Metodo de Pago no se ha podido eliminar.");
			}
			break;
		case 4: //Actualizar
            if (update(oCtrl)) {
                System.out.println("El Metodo de Pago ha sido eliminado con exito.");
            } else {
                System.out.println("El Metodo de Pago no se ha podido eliminar.");
            }
	    }
    } 

    private static boolean create(Controller oCtrl) {
		String sNombreMetodoPago;

		System.out.println("\n$$$$$ Introduce los datos basicos del Metodo de Pago $$$$$");
		sNombreMetodoPago = String.valueOf(Libreria.leer("Nombre del Metodo de Pago", 1, 250, -1, -1, (byte) 6));
		
		return oCtrl.getOMetodoPagoCtrl().add(new MetodoPago(sNombreMetodoPago));
	}

    private static MetodoPago searchMetodoPago(Controller oCtrl) {
		String sNombreMetodoPago = String.valueOf(Libreria.leer("Introduce un Metodo de Pago", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOMetodoPagoCtrl().searchByPk(new MetodoPago(sNombreMetodoPago));
	}

	private static boolean remove(Controller oCtrl) {
		boolean bExito = false;
		MetodoPago oMetodoPago = searchMetodoPago(oCtrl);
		String sNombreMetodoPago = String.valueOf(Libreria.leer("Metodo de Pago", 1, 250, -1, -1, (byte) 6));

		if (oMetodoPago != null) {
			oMetodoPago.getSNombreMetodoPago();
			bExito = oCtrl.getOMetodoPagoCtrl().remove(new MetodoPago(sNombreMetodoPago));
		}
		return bExito;
    }

	private static boolean update(Controller oCtrl) {
        String sNombreMetodoPago;

        System.out.println("\nIntroduce los datos basicos del Metodo de Pago");
        sNombreMetodoPago = String.valueOf(Libreria.leer("Metodo de Pago", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getOMetodoPagoCtrl().update(new MetodoPago(sNombreMetodoPago));
    }

}
