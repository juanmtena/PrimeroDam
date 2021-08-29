import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P1 {

	public static void main(String[] args) {

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;

		// Declaracion de variables
		byte bDiaNacimiento, bMesNacimiento, bDiaActual, bMesActual;
		short shAnoNacimiento, shAnoActual;

		// Escribir por pantalla
		System.out.println("Dia de nacimiento: ");

		// Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		bDiaNacimiento = Byte.parseByte(sCadenaLeida);

		// Escribir por pantalla
		System.out.println("Mes de nacimiento (1....12): ");

		// Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		bMesNacimiento = Byte.parseByte(sCadenaLeida);

		// Escribir por pantalla
		System.out.println("Año de nacimiento: ");

		// Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		// Casting
		shAnoNacimiento = Short.parseShort(sCadenaLeida);

		// Escribir por pantalla
		System.out.println("Dia de hoy: ");

		// Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		bDiaActual = Byte.parseByte(sCadenaLeida);

		// Escribir por pantalla
		System.out.println("Mes actual: ");

		// Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		bMesActual = Byte.parseByte(sCadenaLeida);

		// Escribir por pantalla
		System.out.println("Año actual: ");

		// Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		shAnoActual = Short.parseShort(sCadenaLeida);
		
		//Declaro variable dias viviendo
		int iDiasViviendo;
		
		//Calculo dias viviendo
		iDiasViviendo=(shAnoActual-shAnoNacimiento)*365+(bMesActual-bMesNacimiento)*30+(bDiaActual-bDiaNacimiento);
		
		//Escribir por pantalla resultado final
		System.out.println("LLeva vividos " +iDiasViviendo+ " dias");

	}

}
