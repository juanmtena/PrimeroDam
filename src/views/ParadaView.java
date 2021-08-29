package views;

import controllers.Controller;
import models.Parada;
import models.Ruta;
import models.Ubicacion;

public class ParadaView {
    
    public static byte subMenuParada() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Paradas");
        System.out.println("-----------------------");
        System.out.println("1. Añadir Parada");
        System.out.println("2. Buscar Parada");
        System.out.println("3. Borrar Parada");
        System.out.println("4. Actualizar Numero de la Parada");
        System.out.println("5. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionParada(Controller oCtrl) {
        switch (ParadaView.subMenuParada()) {
        case 1: // Añadir
            if (create(oCtrl)) {
                System.out.println("La Parada ha sido creada con exito.");
            } else {
                System.out.println("La Parada no se ha podido crear.");
            }
            break;
        case 2: // Buscar
        Parada oParada = searchParada(oCtrl);
            if (oParada != null) {
                System.out.println("La Parada buscada existe en la base de datos.");
            } else {
                System.out.println("La Parada no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("La Parada ha sido eliminada con exito.");
            } else {
                System.out.println("La Parada no se ha podido eliminar.");
            }
            break;
        case 4: //Actualizar
            if (update(oCtrl)) {
                System.out.println("La Parada ha sido eliminada con exito.");
            } else {
                System.out.println("La Parada no se ha podido eliminar.");
            }
        }
    }

    private static boolean create(Controller oCtrl) {
        String sNumeroParada, sNombreParada, sDescripcion, sIdRuta, sCoordenadas;

        System.out.println("\nIntroduce los datos basicos del Paquete");
        sNumeroParada = String.valueOf(Libreria.leer("Numero de la Parada", 1, 250, -1, -1, (byte) 6));
        sNombreParada = String.valueOf(Libreria.leer("Nombre de la Parada", 1, 250, -1, -1, (byte) 6));
        sDescripcion = String.valueOf(Libreria.leer("Descripcion del Parada", 1, 1000, -1, -1, (byte) 6));
        sIdRuta = String.valueOf(Libreria.leer("Introduce el ID de la Ruta", 1, 100, -1, -1, (byte) 6));
        sCoordenadas = String.valueOf(Libreria.leer("Introduce las Coordenadas de la Ubicacion", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getOParadaCtrl().add(new Parada(sNumeroParada, sNombreParada, sDescripcion, new Ruta(sIdRuta), new Ubicacion(sCoordenadas)));
    }

    private static Parada searchParada(Controller oCtrl) {
        String sNumeroParada = String.valueOf(Libreria.leer("Numero de la Parada", 1, 250, -1, -1, (byte) 6));
        return oCtrl.getOParadaCtrl().searchByPk(new Parada(sNumeroParada));
    }

    private static boolean remove(Controller oCtrl) {
        String sNumeroParada = String.valueOf(Libreria.leer("Introduce un numero de Parada", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOParadaCtrl().remove(new Parada(sNumeroParada));
    }

    private static boolean update(Controller oCtrl) {
        String sNumeroParada;

        System.out.println("\nIntroduce los datos basicos del Monumento");
        sNumeroParada = String.valueOf(Libreria.leer("Numero del Parada", 1, 1000, -1, -1, (byte) 6));

        return oCtrl.getOParadaCtrl().update(new Parada(sNumeroParada));
    }

}
