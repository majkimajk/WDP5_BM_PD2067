package zad1;


import java.util.TreeMap;

public class Customer {
	
	protected String name;
	private int portfel;
	private TreeMap <String, Integer> wybraneKwiaty = new TreeMap <String, Integer>();
	protected TreeMap <String, String> nazwyKolory = new TreeMap <String, String>();
	private ShoppingCart koszyk;
	private Box pudelko;
	
	public Customer(String name, int portfel) {
		this.name = name;
		this.portfel = portfel;
	}
	
	
	public int getCash(){
		return portfel;
	}
	
	public void get(Flower kwiat){
		wybraneKwiaty.put(kwiat.nazwa, kwiat.ilosc);
		nazwyKolory.put(kwiat.nazwa, kwiat.color);
		
	}
	
	public ShoppingCart getShoppingCart() {
	
		ShoppingCart koszyk = new ShoppingCart(wybraneKwiaty);
		return koszyk;

	}

	public void pay() {
		
		double cenaWybranych = 0;
		double cena = 0;

		
		boolean dContinue = true;
		while (dContinue) {
			for (String nazwa : wybraneKwiaty.keySet()) {
				
				if (PriceList.getInstance().mapa.containsKey(nazwa) == false) {
					wybraneKwiaty.remove(nazwa, wybraneKwiaty.get(nazwa));
					break;
					
				}
				if (nazwa == wybraneKwiaty.lastKey()) {
					dContinue = false;
				}

				
			}
			
		}
		for (String nazwa : wybraneKwiaty.keySet()) {	// przechodzę po kluczach wybrancych kwiatów
			
			if (PriceList.getInstance().mapa.containsKey(nazwa)) {	//sprawdzam, czy klucze z wybranych kwiatów pokrywaja się z cennikiem
				
				cena = PriceList.getInstance().mapa.get(nazwa);		//jeśli tak, to wyciągma cenę z cennika i mnożę przez ilość kwiató
				cenaWybranych += cena * wybraneKwiaty.get(nazwa);
				
			}
			else {
				
				wybraneKwiaty.remove(nazwa, wybraneKwiaty.get(nazwa));	//jeśli nie ma nazwy w cenniku, to usuwam z wybranych		
			}
			
			}
			
		if (cenaWybranych > portfel){
			boolean bContinue = true;
			while (bContinue) {
				for (String nazwa : wybraneKwiaty.keySet()) {
					
					if (cenaWybranych > portfel) {
						cena = PriceList.getInstance().mapa.get(nazwa);
						cenaWybranych -= cena * wybraneKwiaty.get(nazwa);
						wybraneKwiaty.remove(nazwa, wybraneKwiaty.get(nazwa));
						break;
					}
					else {
						bContinue = false;
						break;
					}
				
				}
				
			
			}	
			}
			
		portfel -=(int) cenaWybranych;
					
	}
	
	public void pack(Box pudelko) {
		pudelko.zawartosc = wybraneKwiaty;
		wybraneKwiaty = null;
		

		
	}
	

}
