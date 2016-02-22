package zad1;


import java.util.TreeMap;

public class Box {
	
	private String wlasciciel;
	protected TreeMap<String, Integer> zawartosc;
	protected TreeMap<String, String> kolory;

	public Box(Customer ktoś) {
		
		wlasciciel = ktoś.name;
		kolory = ktoś.nazwyKolory;
		
	}

	@Override
	public String toString() {
		return "Pudełko = [" + zawartosc + "]";
	}
	
	
}
