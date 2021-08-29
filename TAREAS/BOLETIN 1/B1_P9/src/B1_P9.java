import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P9 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		int iNumero;
		byte bPosicion, bDigito;
		
		System.out.print("Introduce numero positivo de 9 cifras: ");
		
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		iNumero=Integer.parseInt(sCadenaLeida);
		
		System.out.print("Introduce una posicion (1-10): ");
		
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		bPosicion=Byte.parseByte(sCadenaLeida);

		System.out.print("El numero que esta en esa posicion es: ");
		
	}

}
