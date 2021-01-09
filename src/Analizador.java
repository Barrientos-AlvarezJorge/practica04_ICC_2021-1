import java.util.Scanner;
    
/**
 *Clase que implementa los métodos de la interface AnalizadorDeCadenas
 *@author Jorge Miguel Aaron Barrientos Alvarez. NC:421111666
 *@version 1.0 Noviembre 2020
 *@since Laboratorio de ICC 2021-1
 */

public class Analizador implements AnalizadorDeCadenas{
    //Actividad 1
    @Override
    public int cuentaCaracter(String cadena, char c){
	int n1=cadena.length(), contador=0;

	for(int i=0; i<n1; i++){
	    if(cadena.charAt(i)==c)
		contador++;
	}

	return contador;
    }
    
    //Actividad 2
    @Override
    public boolean sonIguales(String cadena1, String cadena2){
	int n2=cadena1.length(), n2d=cadena2.length(), contador=0;
	boolean sonIguales=true;

	if(n2!=n2d)
	    sonIguales=false;
	
	else{
	    cadena1=cadena1.toLowerCase();
	    cadena2=cadena2.toLowerCase();

	    for(int i=0; i<n2; i++){
		if(cadena1.charAt(i)==cadena2.charAt(i))
		    contador++;
	    }
	}

	if(contador==n2)
	    sonIguales=true;

	return sonIguales;
	    
    }

    //Actividad 3
    @Override
    public String daSubcadena(String cadena, int inicio, int fin){
	int n3=cadena.length();
	String daSubcadena="indice invalido";
	
	if(inicio<0 || fin>n3)
	    return daSubcadena;

	else{
	    daSubcadena=cadena.substring(inicio, fin);
	    return daSubcadena;
	}
    }

    //Actividad 4
    /**
     * Verifica si una cadena contiene a otra.
     * @param cadena la cadena donde buscar la segunda cadena.
     * @param buscada la subcadena a buscar en la cadena.
     * @param true si cadena contiene la subcadena buscada.
     */
    public boolean esPalindromo(String cadena){
	int n4=cadena.length(), contador=0, n4d;
	boolean esPalindromo=false;
	String cadena2="";
	
	for(int i=0; i<n4; i++){
	    if(cadena.charAt(i)!=',' && cadena.charAt(i)!=' ')
		cadena2+=cadena.charAt(i);
	}
	
	cadena2=cadena2.toLowerCase();
	n4d=cadena2.length();

	for(int i=0; i<((n4d+1)/2); i++){
	    if(cadena2.charAt(i)==cadena2.charAt(n4d-(i+1)))
		contador++;
	}

	if(contador==((n4d+1)/2))
	    esPalindromo=true;

	return esPalindromo;
	
    }

    public static void main(String[] args){
	Scanner sc=new Scanner(System.in); 
	Analizador pruebas = new Analizador();
	int opcion=0;

	//Actividad 5 
	do{
	    System.out.print("\n[1] Cuenta caracter\n"+
			     "[2] Son iguales\n"+
			     "[3] Da subcadena\n"+
			     "[4] Es palindromo\n"+
			     "[5] Salir del programa\n"+
			     "Elige una opcion: ");
	    opcion=sc.nextInt();
	    sc.nextLine();

	    switch(opcion){
	    case 1:
		System.out.print("\nIngresa una cadena: ");
		String cadena=sc.nextLine();
		System.out.print("Ingresa un caracter para buscar en la cadena: ");
		char c=sc.next().charAt(0);
		System.out.println("El caracter aparece en la cadena: "+pruebas.cuentaCaracter(cadena, c)+" veces");
		break;

	    case 2:
		System.out.print("\nIngresa la primera cadena a comparar: ");
		String cadena1=sc.nextLine();
		System.out.print("Ingresa la segunda a cadena a comparar: ");
		String cadena2=sc.nextLine();
		System.out.println("¿Las cadenas que ingresaste son iguales? "+pruebas.sonIguales(cadena1, cadena2));
		break;

	    case 3:
		System.out.print("\nIngresa una cadena: ");
		String cadena3=sc.nextLine();
		System.out.print("Ingresa a partrir de donde: ");
		int inicio=sc.nextInt();
		System.out.print("Ingresa hasta donde: ");
		int fin=sc.nextInt();
		System.out.println("Cadena resultante: "+pruebas.daSubcadena(cadena3, inicio, fin));
		break;

	    case 4:
		System.out.print("\nIngresa una cadena: ");
		String cadena4=sc.nextLine();
		System.out.println("¿La cadena que ingresaste es un palindromo? "+pruebas.esPalindromo(cadena4));
		break;
	    case 5:
		System.out.println("Sale master te me kuidas.");
		break;
	    default:
		System.out.println("Lo siento, no tengo esa opcion.");
		
	    }
	}while(opcion!=5);
      
    }
}
