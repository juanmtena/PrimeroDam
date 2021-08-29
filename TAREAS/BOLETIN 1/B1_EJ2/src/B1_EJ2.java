import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_EJ2 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		//Declarar variable
		float fRadio;
		
		//Escribe
		System.out.println("Introduce el radio del circulo: ");
		
		//Leer
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		fRadio=Float.parseFloat(sCadenaLeida);
		
		//Declarar constante
		final float fPI=3.14f;
		
		//Declarar datos de salida
		float fArea;
		
		//Calcular Area
		fArea=fPI*(fRadio*fRadio);
		
		//Escribe Area
		System.out.println("El area del circulo es: " +fArea);		

	}

}
