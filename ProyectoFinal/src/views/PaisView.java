package views;

import controllers.Controller;
import models.Pais;

public class PaisView {

	public static byte subMenuPais() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de Paises");
		System.out.println("-----------------------");
		System.out.println("1. Crear Pais");
		System.out.println("2. Buscar Pais");
		System.out.println("3. Borrar Pais");
		System.out.println("4. Volver atras");

		return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);
	}

	public static void gestionPais(Controller oCtrl) {
		switch (PaisView.subMenuPais()) {
		case 1: // Crear
			if (create(oCtrl)) {
				System.out.println("El Pais ha sido creado con exito.");
			} else {
				System.out.println("El Pais no se ha podido crear.");
			}
			break;
		case 2: // Buscar
			Pais oPais = searchPais(oCtrl);
			if (oPais != null) {
				System.out.println("El Pais buscado existe en la base de datos.");
				System.out.println(oPais);
			} else {
				System.out.println("El Pais no existe en la base de datos.");
			}
			break;
		case 3: // Borrar
			if (remove(oCtrl)) {
				System.out.println("El Pais ha sido eliminado con exito.");
			} else {
				System.out.println("El Pais no se ha podido eliminar.");
			}
			break;
		case 4: //Actualizar
            if (update(oCtrl)) {
                System.out.println("El Pais ha sido modificado con exito.");
            } else {
                System.out.println("El Pais no se ha podido modificar.");
            }
		}
	}

	private static boolean create(Controller oCtrl) {
		String sNombrePais;

		System.out.println("Introduce los datos basicos del Pais: ");
		sNombrePais = String.valueOf(Libreria.leer("Nombre del Pais", 1, 250, -1, -1, (byte) 6));

		return oCtrl.getOPaisCtrl().add(new Pais(sNombrePais));
	}

	private static Pais searchPais(Controller oCtrl) {
		String sNombrePais = String.valueOf(Libreria.leer("Introduce un pais", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOPaisCtrl().searchByPk(new Pais(sNombrePais));
	}

	private static boolean remove(Controller oCtrl) {
		String sNombrePais = String.valueOf(Libreria.leer("Introduce un pais", 1, 250, -1, -1, (byte) 6));
		return oCtrl.getOPaisCtrl().remove(new Pais(sNombrePais));
	}

	private static boolean update(Controller oCtrl) {
        String sNombrePais;

        System.out.println("\nIntroduce los datos basicos del Pais");
        sNombrePais = String.valueOf(Libreria.leer("Introduce un pais", 1, 250, -1, -1, (byte) 6));

        return oCtrl.getOPaisCtrl().update(new Pais(sNombrePais));
    }

}
