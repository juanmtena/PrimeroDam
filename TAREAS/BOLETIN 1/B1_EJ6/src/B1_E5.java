import java.io.*;

public class B1_E5 {

	public static void main(String[] args) {

		// Declaramos las variables
		int iDorsal;
		float fEstatura;
		float fPeso;

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;

		// Escribir: Introduzca dorsal
		System.out.println("Introduce el numero de dorsal: ");

		// Leer
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		iDorsal = Integer.parseInt(sCadenaLeida);

		// Escriba: Introduzca estatura
		System.out.println("Introduce la estatura: ");

		// Leer
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		fEstatura = Float.parseFloat(sCadenaLeida);

		// Escribir: Introduzca peso
		System.out.println("Introduce el peso: ");

		// Leer
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		fPeso = Float.parseFloat(sCadenaLeida);
		
		//Escribir el mesaje: El dorsal numero iNumero mide fEstatura cm y pesa fPeso kg
		System.out.println("El dorsal " +iDorsal+ " mide " +fEstatura+ "cm y pesa " +fPeso+ "kg");
		
		//FIN

	}

}
