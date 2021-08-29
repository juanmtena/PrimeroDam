package views;

import controllers.Controller;
import models.Ciudad;
import models.Pais;

public class CiudadView { 

    public static byte subMenuCiudad() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Ciudades");
        System.out.println("-----------------------");
        System.out.println("1. Crear Ciudad");
        System.out.println("2. Buscar Ciudad");
        System.out.println("3. Borrar Ciudad");
        System.out.println("4. Actualizar nombre de la Ciudad");
        System.out.println("5. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionCiudad(Controller oCtrl) {
        switch (CiudadView.subMenuCiudad()) {
        case 1: // Crear
            if (create(oCtrl)) {
                System.out.println("La Ciudad ha sido creada con exito.");
            } else {
                System.out.println("La Ciudad no se ha podido crear.");
            }
            break;
        case 2: // Buscar
            Ciudad oCiudad = searchCiudad(oCtrl);
            if (oCiudad != null) {
                System.out.println("La Ciudad buscada existe en la base de datos.");
            } else {
                System.out.println("La Ciudad no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("La Ciudad ha sido eliminada con exito.");
            } else {
                System.out.println("La Ciudad no se ha podido eliminar.");
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
        String sNombreCiudad ,sNombrePais;

        System.out.println("Introduce los datos basicos de la Ciudad: ");
        sNombreCiudad = String.valueOf(Libreria.leer("Nombre de la Ciudad", 1, 250, -1, -1, (byte) 6));
        sNombrePais = String.valueOf(Libreria.leer("Nombre del Pais", 1, 250, -1, -1, (byte) 6));
       
        return oCtrl.getOCiudadCtrl().add(new Ciudad(sNombreCiudad, new Pais(sNombrePais)));
    }

    private static Ciudad searchCiudad(Controller oCtrl) {
        String sNombreCiudad = String.valueOf(Libreria.leer("Nombre de la Ciudad", 1, 250, -1, -1, (byte) 6));
        return oCtrl.getOCiudadCtrl().searchByPk(new Ciudad(sNombreCiudad));
    }

    private static boolean remove(Controller oCtrl) {
        String sNombreCiudad = String.valueOf(Libreria.leer("Nombre de la Ciudad", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOCiudadCtrl().remove(new Ciudad(sNombreCiudad));
    }

    private static boolean update(Controller oCtrl) {
        String sNombreCiudad;

        System.out.println("\nIntroduce los datos basicos de la Ciudad");
        sNombreCiudad = String.valueOf(Libreria.leer("Nombre de la Ciudad", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getOCiudadCtrl().update(new Ciudad(sNombreCiudad));
    }
}
