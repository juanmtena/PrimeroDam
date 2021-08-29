package views;

import controllers.Controller;
import models.Ubicacion;

public class UbicacionView { // ENTREGADO

    public static byte subMenuUbicacion() {

        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Ubicacion");
        System.out.println("-----------------------");
        System.out.println("1. Crear Ubicacion");
        System.out.println("2. Buscar Ubicacion");
        System.out.println("3. Borrar Ubicacion");
        System.out.println("4. Actualizar Coordenadas de la Ubicacion");
        System.out.println("5. Volver atras");

        return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);
    }

    public static void gestionUbicacion(Controller oCtrl) {
        switch (UbicacionView.subMenuUbicacion()) {
        case 1: // Crear
            if (create(oCtrl)) {
                System.out.println("La Ubicacion ha sido creada con exito.");
            } else {
                System.out.println("La Ubicacion no se ha podido crear.");
            }
            break;
        case 2: // Buscar
            Ubicacion oUbicacion = searchUbicacion(oCtrl);
            if (oUbicacion != null) {
                System.out.println("La Ubicacion buscada existe en la base de datos.");
                System.out.println(oUbicacion);
            } else {
                System.out.println("La Ubicacion no existe en la base de datos.");
            }
            break;
        case 3: // Borrar
            if (remove(oCtrl)) {
                System.out.println("La Ubicacion ha sido eliminada con exito.");
            } else {
                System.out.println("La Ubicacion no se ha podido eliminar.");
            }
            break;
        case 4: // Actualizar
            if (update(oCtrl)) {
                System.out.println("La Coordenada ha sido actualizada con exito.");
            } else {
                System.out.println("La Coordenada no se ha podido actualizar.");
            }
        }
    }

    private static boolean create(Controller oCtrl) {
        String sCoordenadas;

        System.out.println("\nIntroduce los datos basicos de la Ubicacion");
        sCoordenadas = String.valueOf(Libreria.leer("Coordenadas de la Ubicacion", 8, 8, -1, -1, (byte) 6));

        return oCtrl.getOUbicacionCtrl().add(new Ubicacion(sCoordenadas));
    }

    private static Ubicacion searchUbicacion(Controller oCtrl) {
        String sCoordenadas = String.valueOf(Libreria.leer("Introduce las Coordenadas", 8, 8, -1, -1, (byte) 6));
        return oCtrl.getOUbicacionCtrl().searchByPk(new Ubicacion(sCoordenadas));
    }

    private static boolean remove(Controller oCtrl) {
        String sCoordenadas = String.valueOf(Libreria.leer("Introduce un pais", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOUbicacionCtrl().remove(new Ubicacion(sCoordenadas));
    }

    private static boolean update(Controller oCtrl) {
        String sCoordenadas;

        System.out.println("\nIntroduce los datos basicos de la Ubicacion");
        sCoordenadas = String.valueOf(Libreria.leer("Coordenadas de la Ubicacion", 1, 8, -1, -1, (byte) 6));

        return oCtrl.getOUbicacionCtrl().update(new Ubicacion(sCoordenadas));
    }

}
