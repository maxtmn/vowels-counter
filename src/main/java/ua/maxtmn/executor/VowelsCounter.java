package ua.maxtmn.executor;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ua.maxtmn.util.VowelAverageDecorator;
import ua.maxtmn.util.VowelCortegeDecorator;

public class VowelsCounter {

	public static Collection<String> countAverageVowelsInWords(
			Collection<String> words) {
		return VowelsCounter.countVowels(words);

	}

	private static Collection<String> countVowels(Collection<String> words) {
		Map<String, Float> result = new TreeMap<>();
		for (String word : words) {
			Set<String> charset = new TreeSet<>();
			int count = 0;
			int wordLength = word.length();
			for (char ch : word.toCharArray()) {
				if (isVowel(ch)) {
					count++;
					charset.add(Character.toString(ch));
				}

			}

			String key = new VowelCortegeDecorator(charset.toString() + ", "
					+ wordLength).toString();
			Float average = null;
			if (!result.containsKey(key)) {
				average = new Float(wordLength / count);

			} else {
				Float prev = result.get(key);
				Float current = new Float(wordLength / count);
				average = new Float(
						(prev.doubleValue() + current.doubleValue()) / 2);

			}

			result.put(key, average);
		}

		Set<String> set = new TreeSet<>();
		for (Entry<String, Float> entry : result.entrySet()) {
			set.add(new VowelAverageDecorator(entry.toString()).toString());
		}
		return set;

	}

	private static boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i'
				|| ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u'
				|| ch == 'U') {
			return true;
		}
		return false;
	}

}
