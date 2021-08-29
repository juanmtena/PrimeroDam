 import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P4 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		//Declarar variables
		byte bVariable1, bVariable2, bVariable3;
		
		//Escribe
		System.out.println("Introduzca el primer numero entero:");
		
		//Leer
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		bVariable1=Byte.parseByte(sCadenaLeida);
		
		//Escribe
		System.out.println("Introduzca el segundo numero entero:");
		
		//Leer
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
				
		//Casting
		bVariable2=Byte.parseByte(sCadenaLeida);
		
		//Conversion
		bVariable3=bVariable1;
		bVariable1=bVariable2;
		bVariable2=bVariable3;
						
		//Escribe
		System.out.println("Los valores se han cambiado " +bVariable1+ " , " +bVariable2);

	}

}
