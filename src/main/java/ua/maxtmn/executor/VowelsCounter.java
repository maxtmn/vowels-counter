package ua.maxtmn.executor;

import java.util.*;
import java.util.Map.Entry;

import ua.maxtmn.util.CharHolder;
import ua.maxtmn.util.VowelAverageDecorator;
import ua.maxtmn.util.VowelCortegeDecorator;

public class VowelsCounter {

	public static Collection<String> countAverageVowelsInWords(
			Collection<String> words) {
		Map<String, Float> map = VowelsCounter.countAverage(VowelsCounter
				.countVowels(words));
		Set<String> set = new TreeSet<>();
		for (Entry<String, Float> entry : map.entrySet()) {
			set.add(new VowelAverageDecorator(entry.toString()).toString());
		}
		return set;

	}

	private static Map<String, Float> countAverage(
			Map<CharHolder, Integer> vowels) {
		Map<String, Float> cortege = new TreeMap<>();
		for (Entry<CharHolder, Integer> vowels_entry : vowels.entrySet()) {
			if (!cortege.containsKey(vowels_entry.getKey().toString())) {
				cortege.put(new VowelCortegeDecorator(vowels_entry.toString())
						.toString(), new Float(vowels_entry.getValue())
						/ vowels_entry.getKey().size());
			}

		}

		return cortege;
	}

	private static Map<CharHolder, Integer> countVowels(Collection<String> words) {
		Map<CharHolder, Integer> cortege = new HashMap<>();
		for (String word : words) {
			Set<String> charset = new TreeSet<>();
			for (char ch : word.toCharArray()) {
				if (isVowel(ch)) {
					charset.add(Character.toString(ch));
				}

			}
			cortege.put(new CharHolder(charset), new Integer(word.length()));

		}

		return cortege;

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
