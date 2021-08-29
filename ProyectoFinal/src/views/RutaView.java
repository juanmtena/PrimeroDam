package views;

import controllers.Controller;
import models.Parada;
import models.Ruta;

public class RutaView {

    public static byte subMenuRuta() {

        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Ruta");
        System.out.println("-----------------------");
        System.out.println("1. Crear Ruta");
        System.out.println("2. Buscar Ruta");
        System.out.println("3. Borrar Ruta");
        System.out.println("4. Actualizar descripcion");
        System.out.println("5. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionRuta(Controller oCtrl) {
        switch (RutaView.subMenuRuta()) {
        case 1: // Crear
            if (create(oCtrl)) {
                System.out.println("La Ruta ha sido creada con exito.");
            } else {
                System.out.println("La Ruta no se ha podido crear.");
            }
            break;
        case 2: // Buscar
            Ruta oRuta = searchRuta(oCtrl);
            if (oRuta != null) {
                System.out.println("La Ruta buscada existe en la base de datos.");
            } else {
                System.out.println("La Ruta no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("La Ruta ha sido eliminada con exito.");
            } else {
                System.out.println("La Ruta no se ha podido eliminar.");
            }
            break;
        case 4: // Actualizar Duracion
        if (update(oCtrl)) {
            System.out.println("La Duracion de la Ruta ha sido modificada con exito.");
        } else {
            System.out.println("La Duracion de la Ruta no se ha podido modificar.");
        }
            break;
        }
    }

    private static boolean create(Controller oCtrl) {
        String sIdRuta, sNombreRuta, sDuracion, sNombreParada;

        System.out.println("\nIntroduce los datos basicos de la Ruta");
        sIdRuta = String.valueOf(Libreria.leer("ID de la Ruta", 1, 250, -1, -1, (byte) 6));
        sNombreRuta = String.valueOf(Libreria.leer("Nombre de la Ruta", 1, 250, -1, -1, (byte) 6));
        sDuracion = String.valueOf(Libreria.leer("Duracion de la Ruta", 1, 1000, -1, -1, (byte) 6));
        sNombreParada = String.valueOf(Libreria.leer("Nombre de la Parada", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getORutaCtrl().add(new Ruta(sIdRuta, sNombreRuta, sDuracion, new Parada(sNombreParada)));
    }

    private static Ruta searchRuta(Controller oCtrl) {
        String sIdRuta = String.valueOf(Libreria.leer("ID de la Ruta", 1, 250, -1, -1, (byte) 6));
        return oCtrl.getORutaCtrl().searchByPk(new Ruta(sIdRuta));
    }

    private static boolean remove(Controller oCtrl) {
        String sIdRuta = String.valueOf(Libreria.leer("Introduce una ID de la Ruta", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getORutaCtrl().remove(new Ruta(sIdRuta));
    }

    private static boolean update(Controller oCtrl) {
        String sDuracion;

        System.out.println("\nIntroduce los datos basicos del Paquete");
        sDuracion = String.valueOf(Libreria.leer("Duracion de la Ruta", 1, 1000, -1, -1, (byte) 6));

        return oCtrl.getORutaCtrl().update(new Ruta(sDuracion));
    }
    
}
