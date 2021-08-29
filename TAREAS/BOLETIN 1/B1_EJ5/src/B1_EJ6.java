import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_EJ6 {

	public static void main(String[] args) {

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;

		// Declaracion de variables
		float fBase;
		float fAltura;
		float fArea;

		// Escribir por pantalla
		System.out.println("Introduce la base:");

		// Leer por teclado: la base
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		fBase = Float.parseFloat(sCadenaLeida);

		// Escribir por pantalla
		System.out.println("Introduce la altura:");

		// Leer por teclado: la altura
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		fAltura = Float.parseFloat(sCadenaLeida);

		// Operacion calculo del area
		fArea = fBase * fAltura;

		// Escribir mensaje final
		System.out.println("El area de rectangulo de base " + fBase + " y altura " + fAltura + " es " + fArea);

	}

}
