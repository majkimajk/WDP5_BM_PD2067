package zad1;


import java.util.TreeMap;

public class ShoppingCart {
	

	private TreeMap<String, Integer> koszyk;

	public ShoppingCart(TreeMap<String, Integer> koszyk) {
		this.koszyk = koszyk;
	}


	public String toString() {
		if (koszyk == null) {
			return "Wózek jest pusty";
		}
		return "Wózek = [" + koszyk + "]";
	}

	
	

	
}