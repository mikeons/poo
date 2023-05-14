package banca;

/* Questa è una classe specializzata di conto bancario che permette agli utenti di andare in rosso:
 * 1. ogni utente possiede un "fido" che indica quanto un conto può scendere in rosso;
 * 2. il bilancio non può scendere ad un valore negativo ma può essere espresso tramte lo "scoperto"
 */

public class ContoConFido extends ContoBancario{
	private double fido = 1000;//fido di default
	private double scoperto = 0;//scoperto di default
	
	public ContoConFido(String numero) {super(numero);}//costruttore
	
	public ContoConFido(String numero, double bilancio) {super(numero,bilancio);}//costruttore
	
	public ContoConFido(String numero, double bilancio, double fido) {
		super(numero,bilancio);
		this.fido = fido;
	}//costruttore 
	
	@Override
	public boolean deposita(double quanto) {
		if (quanto < 0) return false;
		
		if (quanto <= scoperto) {
			scoperto -= quanto;
			return true;
		}
		
		double residuo = quanto - scoperto;
		scoperto = 0;
		super.deposita(residuo);
		
		return true;	
	}//deposita
	
	
	/* super.preleva() rifiuta l'operazione quando si desidera di prelevare più del bilancio
	 * la classe ContoConFido offre la possibilità di prelevare di più, ma salvaguardato 
	 * dallo "scoperto", per soddisfare tali esigenze occorre fare un @Override del metodo
	 */
	@Override
	public boolean preleva(double quanto) {
		if (quanto < 0) return false;
		
		double bilancio = getBilancio();
		
		if (quanto <= bilancio) {
			super.preleva(quanto);
			return true;
		}
		
		//la parte in rosso si segnala con lo "scoperto"
		if (quanto <= bilancio+fido-scoperto) {
			super.preleva(bilancio);
			scoperto = quanto - bilancio;
			return true;	
		}
		
		return false;
	}//preleva
	
	public double getFido() {return fido;}//getFido
	
	public double getScoperto() {return scoperto;}//getScoperto
	
	public void nuovoFido(double fido) {this.fido = fido;}//nuovoFido
	
	public String toString() {
		return String.format("conto=%s, bilancio=%1.2f€, fido=%1.2f€,scoperto=%1.2f€.",
				getNumero(),getBilancio(),fido,scoperto);
	}//toString
}
