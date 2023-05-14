package banca;

/* Simulare il funzionamento di una banca:
 * 1. Avere una lista "clientela" che permette di aggiungere o rimuovere un conto dalla lista
 * 2. Se nell'aggiunta di un nuovo conto, la clientela è satura allora la capacità si raddoppia
 * 3. Se si rimuove un conto, allora tutti i conti si spostano in avanti di uno
 */

public class BancaArray {
	private ContoBancario []clientela;
	private int size = 0, capacita;
	
	public BancaArray() {this(10);
	}//costruttore di default
	
	public BancaArray(int capacita) {
		this.capacita = capacita;
		clientela = new ContoBancario[capacita];
	}//costruttore
	
	public void add_conto(ContoBancario cb) {
		if (size == capacita) {
			ContoBancario []clientela_vecchia = clientela;
			capacita *= 2;
			clientela = new ContoBancario[capacita];
			System.arraycopy(clientela_vecchia,0,clientela,0,size);
		}
		clientela[size] = cb;
		size ++;
	}//add_conto
	
	public void remove_conto(ContoBancario cb) {
		int indice = indexOf(cb);
		
		if (indice < 0) throw new IllegalArgumentException();
		
		for(int j=indice; j<size-1; j++)
			clientela[j] = clientela[j+1];
		size --;
	}//remove_conto
	
	public int indexOf(ContoBancario cb) {
		for (int i=0;i<size; i++) {
			if(clientela[i].equals(cb))
				return i;
		}
		return -1;
	}//indexOf
	
	public String toString() {
		String s ="";
		for(int i=0; i<size; i++) {
			s += clientela[i]+"\n";
		}
		return s;
	}//toString
}//BancaArray
