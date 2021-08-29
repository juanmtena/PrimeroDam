import java.io.*;

public class B1_E4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;

		// Declaracion de variables
		short shHoras;
		byte bMinutos;
		byte bSegundos;
		int iResultado;

		// Escribe horas
		System.out.println("Introduce las horas: ");

		// Leer por teclado horas
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		shHoras = Short.parseShort(sCadenaLeida);
		
		// Escribe minutos
		System.out.println("Introduce los minutos: ");

		// Leer por teclado minutos
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		bMinutos = Byte.parseByte(sCadenaLeida);

		// Escribe segundos
		System.out.println("Introduce los segundos: ");

		// Leer por teclado segundos
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		bSegundos = Byte.parseByte(sCadenaLeida);
		
		//Calculo para pasar horas y minutos a segundos
		iResultado = (shHoras*3600)+(bMinutos*60)+bSegundos;
		
		System.out.println(+shHoras+ " horas " +bMinutos+ " minutos y " +bSegundos+ " segundos equivalen a " +iResultado+ " segundos");

	}

}
