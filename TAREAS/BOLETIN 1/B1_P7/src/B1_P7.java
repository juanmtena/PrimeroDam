import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P7 {

	public static void main(String[] args) {
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		
		//Declaro variables
		int iSegundos;
		short shMinutos;
		byte bResto;
		
		//Escribe Segundos
		System.out.println("Numero de segundos:");
		
		//Leer Segundos
		try {
			sCadenaLeida = teclado.readLine();
		} catch (Exception e) {
			sCadenaLeida = "";
		}
		
		//Casting Segundos
		iSegundos=Integer.parseInt(sCadenaLeida);
		
		//Pasar de segundos a minutos 
		shMinutos=(short) (iSegundos/60);
		bResto=(byte) (iSegundos%60);
		
		//Escribe minutos y segundos
		System.out.println(+iSegundos+ " segundos equivalen a " +shMinutos+ " minutos y " +bResto+ " segundos.");
		
		
		

	}

}
