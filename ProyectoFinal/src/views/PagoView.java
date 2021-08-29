package views;

import controllers.Controller;
import models.Pago;
import models.MetodoPago;
import models.Paquete;
import models.Cliente;

public class PagoView {
    
    public static byte subMenuPago() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Pagos");
        System.out.println("-----------------------");
        System.out.println("1. Añadir Pago");
        System.out.println("2. Buscar Pago");
        System.out.println("3. Borrar Pago");
        System.out.println("4. Actualizar Pago");
        System.out.println("5. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionPago(Controller oCtrl) {
        switch (PagoView.subMenuPago()) {
        case 1: // Añadir
            if (create(oCtrl)) {
                System.out.println("El Pago ha sido creado con exito.");
            } else {
                System.out.println("El Pago no se ha podido crear.");
            }
            break;
        case 2: // Buscar
            Pago oPago = searchPago(oCtrl);
            if (oPago != null) {
                System.out.println("El Pago buscado existe en la base de datos.");
            } else {
                System.out.println("El Pago no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("El Pago ha sido eliminado con exito.");
            } else {
                System.out.println("El Pago no se ha podido eliminar.");
            }
            break;
        case 4: //Actualizar
            if (update(oCtrl)) {
                System.out.println("El Pago ha sido eliminado con exito.");
            } else {
                System.out.println("El Pago no se ha podido eliminar.");
            }
        }
    }

    private static boolean create(Controller oCtrl) {
        String sIdPago, sFechaPago, sNombreMetodoPago, sIdPaquete, sDniCliente;

        System.out.println("\nIntroduce los datos basicos del Pago");
        sIdPago = String.valueOf(Libreria.leer("ID del Pago", 1, 250, -1, -1, (byte) 6));
        sFechaPago = String.valueOf(Libreria.leer("Fecha del Pago", 1, 1000, -1, -1, (byte) 6));
        sNombreMetodoPago = String.valueOf(Libreria.leer("Nombre del Metodo de Pago", 1, 100, -1, -1, (byte) 6));
        sIdPaquete = String.valueOf(Libreria.leer("ID del Paquete", 1, 250, -1, -1, (byte) 6));
        sDniCliente = String.valueOf(Libreria.leer("DNI Cliente", 1, 100, -1, -1, (byte) 6));

        return oCtrl.getOPagoCtrl().add(new Pago(sIdPago, sFechaPago, new MetodoPago(sNombreMetodoPago), new Paquete(sIdPaquete), new Cliente(sDniCliente)));
    }

    private static Pago searchPago(Controller oCtrl) {
        String sIdPago = String.valueOf(Libreria.leer("ID del Pago", 1, 250, -1, -1, (byte) 6));
        return oCtrl.getOPagoCtrl().searchByPk(new Pago(sIdPago));
    }

    private static boolean remove(Controller oCtrl) {
        String sIdPago = String.valueOf(Libreria.leer("ID del Pago", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOPagoCtrl().remove(new Pago(sIdPago));
    }

    private static boolean update(Controller oCtrl) {
        String sIdPago;

        System.out.println("\nIntroduce los datos basicos del Pago");
        sIdPago = String.valueOf(Libreria.leer("ID del Pago", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getOPagoCtrl().update(new Pago(sIdPago));
    }

}
