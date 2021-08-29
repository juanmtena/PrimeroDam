package views;

import controllers.Controller;
import models.TipoPaquete;

public class TipoPaqueteView {
    
    public static byte subMenuTipoPaquete() {

        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Tipo de Paquete");
        System.out.println("-----------------------");
        System.out.println("1. Crear Tipo de Paquete");
        System.out.println("2. Buscar Tipo de Paquete");
        System.out.println("3. Borrar Tipo de Paquete");
        System.out.println("4. Actualizar descripción");
        System.out.println("5. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionTipoPaquete(Controller oCtrl) {
        switch (TipoPaqueteView.subMenuTipoPaquete()) {
        case 1: // Crear
            if (create(oCtrl)) {
                System.out.println("El Tipo de Paquete ha sido creado con exito.");
            } else {
                System.out.println("El Tipo de Paquete no se ha podido crear.");
            }
            break;
        case 2: // Buscar
            TipoPaquete oTipoPaquete = searchTipoPaquete(oCtrl);
            if (oTipoPaquete != null) {
                System.out.println("El Tipo de Paquete buscado existe en la base de datos.");
                System.out.println(oTipoPaquete);
            } else {
                System.out.println("El Tipo de Paquete no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("El Tipo de Paquete ha sido eliminado con exito.");
            } else {
                System.out.println("El Tipo de Paquete no se ha podido eliminar.");
            }
            break;
        case 4: // Actualizar Descripcion
        if (update(oCtrl)) {
            System.out.println("El Tipo de Paquete ha sido modificado con exito.");
        } else {
            System.out.println("El Tipo de Paquete no se ha podido modificar.");
        }
            break;
        }
    }

    private static boolean create(Controller oCtrl) {
        String sNombrePaquete, sDescripcion;

        System.out.println("\nIntroduce los datos basicos del Paquete");
        sNombrePaquete = String.valueOf(Libreria.leer("Nombre del Paquete", 1, 250, -1, -1, (byte) 6));
        sDescripcion = String.valueOf(Libreria.leer("Descripcion del Paquete", 1, 1000, -1, -1, (byte) 6));

        return oCtrl.getOTipoPaqueteCtrl().add(new TipoPaquete(sNombrePaquete, sDescripcion));
    }

    private static TipoPaquete searchTipoPaquete(Controller oCtrl) {
        String sNombrePaquete = String.valueOf(Libreria.leer("Nombre del Paquete", 1, 250, -1, -1, (byte) 6));
        return oCtrl.getOTipoPaqueteCtrl().searchByPk(new TipoPaquete(sNombrePaquete));
    }

    private static boolean remove(Controller oCtrl) {
        String sNombrePaquete, sDescripcion;

        sNombrePaquete = String.valueOf(Libreria.leer("Introduce un Tipo de Paquete", 1, 250, -1, -1, (byte) 6));
        sDescripcion = String.valueOf(Libreria.leer("Descripcion del Paquete", 1, 1000, -1, -1, (byte) 6));

		return oCtrl.getOTipoPaqueteCtrl().remove(new TipoPaquete(sNombrePaquete, sDescripcion));
    }

    private static boolean update(Controller oCtrl) {
        String sDescripcion;

        System.out.println("\nIntroduce los datos basicos del Paquete");
        sDescripcion = String.valueOf(Libreria.leer("Descripcion del Paquete", 1, 1000, -1, -1, (byte) 6));

        return oCtrl.getOTipoPaqueteCtrl().update(new TipoPaquete(sDescripcion));
    }

}
