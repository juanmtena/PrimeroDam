import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P3 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		//Declarar constantes
		byte bHoras, bHorasExtras;
		
		//Declarar Salario semanal
		short shSalario;
		
		//Escribir Horas
		System.out.println("Total horas normales:");
		
		//Leer horas
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		bHoras=Byte.parseByte(sCadenaLeida);
		
		//Escribir Horas Extras
		System.out.println("Total extras:");
		
		
		//Leer Horas Extras
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		bHorasExtras=Byte.parseByte(sCadenaLeida);
		
		//Calculo Salario
		shSalario=(short) ((bHoras*10)+(bHorasExtras*20));
		
		//Escribe Salario semanal
		System.out.println("Total " +shSalario+ " euros/semana");
		
	}

}
