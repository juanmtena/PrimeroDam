import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P2 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		//Declaracion de variables
		short shAnoNacimiento;
		
		//Escribir por pantalla
		System.out.println("Introduzca su año de nacimiento: ");
		
		//Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		shAnoNacimiento=Short.parseShort(sCadenaLeida);
		
		//Declarar las constantes
		final short ANO_ACTUAL;
		
		//Valor año actual
		ANO_ACTUAL=(short)2020f;
		
		//Declarar los datos de salida
		short shEdad;
		
		//Casting
		shEdad=Short.parseShort(sCadenaLeida);
		
		//Calcular la edad
		shEdad=(short)(ANO_ACTUAL-shAnoNacimiento);
		
		//Escribir por pantalla la edad
		System.out.println("Usted tiene " +shEdad+ " años");

	}

}
