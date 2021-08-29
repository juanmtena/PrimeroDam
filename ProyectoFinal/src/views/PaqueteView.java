package views;

import controllers.Controller;
import models.Paquete;
import models.TipoPaquete;

public class PaqueteView {
    
    public static byte subMenuPaquete() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Paquetes");
        System.out.println("-----------------------");
        System.out.println("1. Crear Paquetes");
        System.out.println("2. Buscar Paquetes");
        System.out.println("3. Borrar Paquetes");
        System.out.println("4. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);
    }

    public static void gestionPaquete(Controller oCtrl) {
        switch (PaqueteView.subMenuPaquete()) {
        case 1: // Crear
            if (create(oCtrl)) {
                System.out.println("El Paquete ha sido creado con exito.");
            } else {
                System.out.println("El Paquete no se ha podido crear.");
            }
            break;
        case 2: // Buscar
            Paquete oPaquete = searchPaquete(oCtrl);
            if (oPaquete != null) {
                System.out.println("El Paquete buscado existe en la base de datos.");
            } else {
                System.out.println("El Paquete no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("El Paquete ha sido eliminado con exito.");
            } else {
                System.out.println("El Paquete no se ha podido eliminar.");
            }
            break;
        case 4: // Actualizar
            if (update(oCtrl)) {
                System.out.println("La Ciudad ha sido eliminada con exito.");
            } else {
                System.out.println("La Ciudad no se ha podido eliminar.");
            }
        }
    }

    private static boolean create(Controller oCtrl) {
        String sIdPaquete, sNombrePaquete;

        System.out.println("Introduce los datos basicos de la Ciudad: ");
        sIdPaquete = String.valueOf(Libreria.leer("ID del Paquete", 1, 250, -1, -1, (byte) 6));
        sNombrePaquete = String.valueOf(Libreria.leer("Nombre del Tipo de Paquete", 1, 250, -1, -1, (byte) 6));
       
        
        return oCtrl.getOPaqueteCtrl().add(new Paquete(sIdPaquete, new TipoPaquete(sNombrePaquete)));
    }

    private static Paquete searchPaquete(Controller oCtrl) {
        String sIdPaquete = String.valueOf(Libreria.leer("Introduce un ID del Paquete", 1, 250, -1, -1, (byte) 6));
        return oCtrl.getOPaqueteCtrl().searchByPk(new Paquete(sIdPaquete));
    }

    private static boolean remove(Controller oCtrl) {
        String sIdPaquete = String.valueOf(Libreria.leer("Introduce un ID del Paquete", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOPaqueteCtrl().remove(new Paquete(sIdPaquete));
    }

    private static boolean update(Controller oCtrl) {
        String sIdPaquete;

        System.out.println("\nIntroduce los datos basicos del Paquete");
        sIdPaquete = String.valueOf(Libreria.leer("Introduce un ID del Paquete", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getOPaqueteCtrl().update(new Paquete(sIdPaquete));
    }

}
