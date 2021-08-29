import java.io.*;

public class B1_E3 {

	public static void main(String[] args) {

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;

		// Declaracion de variables
		byte bDia;
		String sMes;
		short shAno;

		// Escribir dia
		System.out.println("Introduce dia de nacimiento:");

		// Leer dia
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting
		bDia = Byte.parseByte(sCadenaLeida);

		// Escribir mes
		System.out.println("Introduce mes de nacimiento (Enero....Diciembre):");

		// Leer mes
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Indicarle la variable que quiero que aparezca en pantalla
		sMes = sCadenaLeida;

		// Escribir año
		System.out.println("Introduce año de nacimiento:");

		// Leer por teclado año
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}

		// Casting y lo inicializa a la vez
		shAno = Short.parseShort(sCadenaLeida);
		
		System.out.println("Esta persona nació el día " +bDia+ " del mes de " +sMes+ " de " +shAno);

	}

}
