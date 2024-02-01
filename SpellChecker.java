
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		String tail = "";
		if (str.length() == 1){
			return tail;
		} else {
			tail += str.substring(1);
		}
		return tail;
		
	}

	public static int levenshtein(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if (word2.length() == 0){
			return word1.length();
		}
		else if (word1.length() == 0){
			return word2.length();
		}
		else if (word1.charAt(0) == word2.charAt(0)) {
			return levenshtein(tail(word1), tail(word2));
		} else {
			int lev1 = levenshtein(tail(word1), word2);
			int lev2 = levenshtein(word1, tail(word2));
			int lev3 = levenshtein(tail(word1), tail(word2));

		    int minimum = (Math.min (Math.min(lev1, lev2), lev3));

			return 1 + minimum;

		}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readLine();
			
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int minDistance = levenshtein(word,dictionary[0]);
		int indexMinimum = 0;

		for (int i = 0; i < dictionary.length; i++) {
			int lev = levenshtein(word, dictionary[i]);
			if (lev < minDistance){
				indexMinimum = i;
			    minDistance = lev;
			}	
			 
		}

		if (minDistance <= threshold){
			return dictionary[indexMinimum];
		} else {
			return word;
		}

		
	}

}
