package banca;

/*creare una classe Conto Bancario che deve:
 * 1. dare un numero in stringa per identificare il conto
 * 2. avere il metodo di deposita e preleva
 * 3. l'operazione di preleva non deve andare in rosso, se succede rifiuta l'operazione e avverte l'utente
 * */

public class ContoBancario {
	private String numero;
	private double bilancio = 0; //valore di default quando si crea un conto bancario
	
	public ContoBancario(String numero) {
		this.numero = numero;
	}//costruttore che acquisisce il bilancio di default
	
	public ContoBancario(String numero, double bilancio ) {
		this.numero = numero;
		this.bilancio = bilancio;
	}//costruttore che acquisisce un bilancio diverso dal default
	
	public boolean deposita(double quanto) {
		if (quanto < 0)
			return false;
		
		bilancio += quanto;
		return true;
	}//deposita
	
	public boolean preleva(double quanto) {
		if (quanto < 0)
			return false;
		
		if (quanto > bilancio)
			return false;
		
		bilancio -= quanto;
		return true;
	}//preleva
	
	public double getBilancio() {return bilancio;}//getBilancio
	
	public String getNumero() {return numero;}//conto
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ContoBancario)) return false;
		
		if (this == o) return true;
		
		ContoBancario c = (ContoBancario) o;
		return this.numero.equals(c.numero);
		
	}//equals
	
	public String toString() {
		return String.format("conto=%s, bilancio=%1.2f€.", numero, bilancio);
	}//toString
		
}
