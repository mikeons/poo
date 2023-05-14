package banca;

public class Test {

	public static void main(String [] args) {		
		ContoBancario c1 = new ContoBancario("111",100);
		ContoConFido c2 = new ContoConFido("111");
		ContoBancario c3 = new ContoConFido("2022");
		
		BancaArray banca = new BancaArray();
		
		banca.add_conto(c1);
		banca.add_conto(c2);
		banca.add_conto(c3);
		
		System.out.println(banca);

	}

}
