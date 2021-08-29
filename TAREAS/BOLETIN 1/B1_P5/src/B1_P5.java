import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P5 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		short shA, shB, shC;
		float fR1, fR2;
		
		System.out.println("Introduzca coeficiente num. A:" );
		
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		shA=Short.parseShort(sCadenaLeida);
		
		System.out.println("Introduzca coeficiente num. B:" );
		
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		shB=Short.parseShort(sCadenaLeida);
		
		System.out.println("Introduzca coeficiente num. C:" );
		
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		shC=Short.parseShort(sCadenaLeida);
		
		 fR1=(float) ((-shB+Math.sqrt((shB*shB)-(4*shA*shC)))/(2*shA));
		 fR2=(float) ((-shB-Math.sqrt((shB*shB)-(4*shA*shC)))/(2*shA));
		
		System.out.println("El resultado 1 es " +fR1+ " y el resultado 2 es " +fR2);

	}

}
