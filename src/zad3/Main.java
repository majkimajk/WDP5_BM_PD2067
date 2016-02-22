/**
 *
 *  @author Baran Michał PD2067
 *
 */

package zad3;


public class Main {

  public static void main(String[] args) {
	 
	 Towar t = new Towar();
	 WątekA a = new WątekA(t);
	 WątekB b = new WątekB(t);
	 a.start();
	 b.start();

	  
  }
}
