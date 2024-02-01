

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		In in = new In (fileName); 
		String[] dictionary = new String[3000];
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readLine();
			
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word)){
				return true;
			}
		}
			
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		String lowerCaseHashtag = hashtag.toLowerCase();

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
			boolean isExist = existInDictionary(lowerCaseHashtag.substring(0, i), dictionary);
			if (isExist) {
				System.out.println(lowerCaseHashtag.substring(0,i));
				breakHashTag(lowerCaseHashtag.substring(i), dictionary);
				
			}
		
        }
		return;
    }

}
