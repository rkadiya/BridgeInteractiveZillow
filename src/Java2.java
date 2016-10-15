import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * 	The number of times a character occurs, upper or lower case
 *  The number of lines a character occurs on
 */

public class Java2 {
	
	public static HashMap<Character, Integer> totalCountMap = new HashMap<>();
	public static HashMap<Character, Set<Integer>> totalLinesMap = new HashMap<>();
	
	public static void fillInfo() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(new File("Text.txt")))) {
		    String line;
		    int presentLine = 1;
		    while ((line = br.readLine()) != null) {
		    	for (char ch : line.toCharArray()) {
					Character presentChar = Character.toLowerCase(ch);
					if (totalCountMap.containsKey(presentChar)) {
						totalCountMap.put(presentChar, totalCountMap.get(presentChar) + 1);
					} else {
						totalCountMap.put(presentChar, 1);
					}
				}
		    	
		    	for (char ch : line.toCharArray()) {
					Character presentChar = Character.valueOf(ch);
					Set<Integer> lines = new HashSet<>();
					if (totalLinesMap.containsKey(presentChar)) {
						totalLinesMap.get(presentChar).add(presentLine);
					} else {
						lines.add(presentLine);
						totalLinesMap.put(presentChar, lines);
					}
				}
		    	presentLine++;
		    }
		}
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		fillInfo();
		System.out.println("Please enter a character:");
		char c = (char) System.in.read();
		System.out.println("The number of times a character occurs, upper or lower case in the Text is:" + totalCountMap.get(Character.toLowerCase(c)));
		System.out.println("The number of lines a character occurs on is:" + totalLinesMap.get(Character.valueOf(c)).size());
	}

}
