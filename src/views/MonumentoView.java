package views;

import controllers.Controller;
import models.Monumento;
import models.Ciudad;

public class MonumentoView {

    public static byte subMenuMonumento() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Monumentos");
        System.out.println("-----------------------");
        System.out.println("1. Añadir Monumento");
        System.out.println("2. Buscar Monumentos");
        System.out.println("3. Borrar Monumentos");
        System.out.println("4. Actualizar Monumento");
        System.out.println("5. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionMonumento(Controller oCtrl) {
        switch (MonumentoView.subMenuMonumento()) {
        case 1: // Añadir
            if (create(oCtrl)) {
                System.out.println("El Monumento ha sido creada con exito.");
            } else {
                System.out.println("El Monumento no se ha podido crear.");
            }
            break;
        case 2: // Buscar
            Monumento oMonumento = searchMonumento(oCtrl);
            if (oMonumento != null) {
                System.out.println("El Monumento buscada existe en la base de datos.");
            } else {
                System.out.println("El Monumento no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("El Monumento ha sido eliminada con exito.");
            } else {
                System.out.println("El Monumento no se ha podido eliminar.");
            }
            break;
        case 4: //Actualizar
            if (update(oCtrl)) {
                System.out.println("El Monumento ha sido eliminada con exito.");
            } else {
                System.out.println("El Monumento no se ha podido eliminar.");
            }
        }
    }

    private static boolean create(Controller oCtrl) {
        String sNombreMonumento, sDireccion, sNombreCiudad;

        System.out.println("\nIntroduce los datos basicos del Paquete");
        sNombreMonumento = String.valueOf(Libreria.leer("Nombre del Monumento", 1, 250, -1, -1, (byte) 6));
        sDireccion = String.valueOf(Libreria.leer("Direccion del Monumento", 1, 1000, -1, -1, (byte) 6));
        sNombreCiudad = String.valueOf(Libreria.leer("Introduce el nombre de la Ciudad", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getOMonumentoCtrl().add(new Monumento(sNombreMonumento, sDireccion, new Ciudad(sNombreCiudad)));
    }

    private static Monumento searchMonumento(Controller oCtrl) {
        String sNombreMonumento = String.valueOf(Libreria.leer("Nombre del Monumento", 1, 250, -1, -1, (byte) 6));
        return oCtrl.getOMonumentoCtrl().searchByPk(new Monumento(sNombreMonumento));
    }

    private static boolean remove(Controller oCtrl) {
        String sNombreMonumento = String.valueOf(Libreria.leer("Nombre del Monumento", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOMonumentoCtrl().remove(new Monumento(sNombreMonumento));
    }

    private static boolean update(Controller oCtrl) {
        String sDireccion;

        System.out.println("\nIntroduce los datos basicos del Monumento");
        sDireccion = String.valueOf(Libreria.leer("Direccion del Monumento", 1, 800, -1, -1, (byte) 6));

        return oCtrl.getOMonumentoCtrl().update(new Monumento(sDireccion));
    }

}