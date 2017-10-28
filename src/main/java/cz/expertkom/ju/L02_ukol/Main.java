    package cz.expertkom.ju.L02_ukol;

import java.lang.annotation.Repeatable;

/*
 * Aktuální počasí a jeho předpověď pomocí API portálu http://openweathermap.org/api
 * 
 * Aplikační logika je ve třídě "Pocasi" 
 * 
 * Aplikace využívá Code page UTF-8. V Eclipse: 
 * Windows->Preferencies->General->Workspace->dole na stránce se dá přepnout
 * 
 */

public class Main {

	public static void main(String[] args) {

		PrehledPocasiInterface pocasi = new PrehledPocasi();
		
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
		
		
		
		
		
		
		
	
	}
		

		
		
		
		
		

}
