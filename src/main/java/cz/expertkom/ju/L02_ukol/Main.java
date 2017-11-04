package cz.expertkom.ju.L02_ukol;

/*
 * Aktuální počasí a jeho předpověď pomocí API portálu http://openweathermap.org/api
 * 
 * Aplikační logika je ve třídách
 * 	1. "Pocasi"  - stáhne Unirestem do HttpResponse<JsonNode>
 * 	2. PrehledPocasi -  transformuje do HttpResponse<JsonNode> Listu stringů
 * 	3. PrehledPocasiInterface - má pouze 2 metody get-y, které odkazují na List<stringů> Aktuálního počasí a Předpovědi počasí
 * 	4. Main vypíše seznamy čtyřmi různými iteracemi
 * 	5. V průběhu programu se vytváří Log programu (pro každý jeho běh nový), Log se na konci vypíše, obsahuje i případnou Exception hlášku 
 *  	 a značky o provedené sekvenci programu
 * 
 * Aplikace využívá Code page UTF-8. V Eclipse: 
 * Windows->Preferencies->General->Workspace->dole na stránce se dá přepnout * 
 */

public class Main  {

	public static void main(String[] args) throws MyException {

		ObsluhaLogu obsluhaLogu = new ObsluhaLogu();
		obsluhaLogu.zalozLog();
		obsluhaLogu.pridejZapisDoLogu("Začátek programu");
		
		/* tohle mi vnutila Eclipse */
		final PrehledPocasiInterface pocasi = new PrehledPocasi();
		
		//if (pocasi.nacteniOK())
		if ((pocasi.getOdpovedPredpovedPocasi()!=null)&&(pocasi.getOdpovedAktualniPocasi()!=null))
		{
							
		/* vypis aktuálního počasí přes cyklus for each...  */
		System.out.println("******************************************************");
		System.out.println("*  aktuální počasí (for each)                        *");
		System.out.println("******************************************************");
		for (String s:pocasi.getPrehledPocasiAktualni() ) {
			System.out.println(s);
		}
		
		System.out.println(""); // nový řadek
		
		System.out.println("******************************************************");
		System.out.println("*  aktuální počasí (while...)                        *");
		System.out.println("******************************************************");
		int i =0;
		while (i<pocasi.getPrehledPocasiAktualni().size()) {
			System.out.println(pocasi.getPrehledPocasiAktualni().get(i));
			i++;
		}
		
		System.out.println(""); // nový řadek
		
		/*vypis předpovědi počasí přes cyklus for (int i=0....  */
		System.out.println("******************************************************");
		System.out.println("*  předpověď počasí (for int i =0....                *");
		System.out.println("******************************************************");
		for ( i=0; i < pocasi.getPrehledPocasiPredpoved().size(); i++) {
			System.out.println(pocasi.getPrehledPocasiPredpoved().get(i));
		}
		
		System.out.println("******************************************************");
		System.out.println("*  předpověď počasí ( do...while.......              *");
		System.out.println("******************************************************");
		i=0;
		do {
			System.out.println(pocasi.getPrehledPocasiPredpoved().get(i));
			i++;
		} while(i<pocasi.getPrehledPocasiPredpoved().size());
		
		//if (true) {throw new MyException("Konec programu");}
		
		}
		
		System.out.println("******************************************************");
		System.out.println("*  soubor logu                                       *");
		System.out.println("******************************************************");
		obsluhaLogu.pridejZapisDoLogu("Konec programu");
		obsluhaLogu.vypisLog();
		
		
		
		
	
	}
		

		
		
		
		
		

}
