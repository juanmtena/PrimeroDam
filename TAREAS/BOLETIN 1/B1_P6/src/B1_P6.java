import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P6 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		//Declaro variables
		float fRadio, fLongitud, fArea;
		
		//Declaro constantes
		final float PI=3.14f;
		
		//Escribe radio
		System.out.println("Introduce el valor del radio:");
		
		//Leer por teclado
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting
		fRadio=Float.parseFloat(sCadenaLeida);
		
		//Calculo
		fLongitud=(2*PI*fRadio);
		fArea=(PI*(fRadio*fRadio));
		
		//Escribir solucion
		System.out.println("Longitud = " +fLongitud+ " y el Area = " +fArea);
		
	}

}
