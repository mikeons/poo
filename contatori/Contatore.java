package contatori;

import banca.ContoBancario;
import banca.Test;

public class Contatore {
	public Contatore() {
		System.out.println("sono il contatore di default");
	}
	
	public Contatore(int c) {}
	public static void main(String [] args) {
		Contatore c = new Contatore();
		ContatoreModulare c1 = new ContatoreModulare();
		Contatore c2 = new Contatore();
		
		System.out.println(c.getClass());		
		System.out.println(c1.getClass());		
		System.out.println(c2.getClass());		
		System.out.println(c.getClass()==Contatore.class);		
		
		
	}
	
}
