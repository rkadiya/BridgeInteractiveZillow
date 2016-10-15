
/*  Write a program that prints the numbers from 1 to 100. But for multiples of three print “Zil”
	instead of the number and for the multiples of five print “low”. For numbers which are multiples
	of both three and five print “Zillow”.
*/
public class Java1 {
	
	public static void printNumbers() {
		for (int i = 1 ; i <= 100; i++) {
			if (i%3==0 && i%5==0) {
				System.out.println("Zillow");
				continue;
			} else if (i%3==0 && i%5!=0) {
				System.out.println("Zil");
				continue;
			} else if (i%3!=0 && i%5==0) {
				System.out.println("low");
				continue;
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		printNumbers();
	}

}
