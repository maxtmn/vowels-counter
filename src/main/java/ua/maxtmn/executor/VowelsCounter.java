package ua.maxtmn.executor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import ua.maxtmn.util.VowelAverageDecorator;
import ua.maxtmn.util.VowelCortegeDecorator;

public class VowelsCounter {

	public static Collection<String> countAverageVowelsInWords(
			Collection<String> words) {
		return VowelsCounter.decorateVowelsResult(VowelsCounter
				.countVowels(words));

	}

	public static Collection<String> countAverageVowelsInWordsPure(
			Collection<String> words) {
		return VowelsCounter.countVowels(words);

	}

	private static Collection<String> countVowels(Collection<String> words) {
		Map<String, Float> result = new HashMap<String, Float>();
		for (String word : words) {
			Set<String> charset = new TreeSet<>();
			int vowels_quantity = 0;
			int wordLength = word.length();
			for (char ch : word.toCharArray()) {
				if (isVowel(ch)) {
					vowels_quantity++;
					charset.add(Character.toString(ch).toLowerCase());
				}

			}
			if (vowels_quantity != 0) {
				countAverageVowels(result, charset, vowels_quantity, wordLength);
			}

		}
		Set<String> response = new TreeSet<String>();

		for (Entry<String, Float> entry : result.entrySet()) {
			response.add(entry.toString());
		}
		return response;

	}

	private static Float countAverage(Map<String, Float> result,
			int vowels_quantity, int wordLength, String key) {
		Float average = null;
		if (!result.containsKey(key)) {
			average = new Float(wordLength / vowels_quantity);

		} else {
			Float prev = result.get(key);
			Float current = new Float(wordLength / vowels_quantity);
			average = new Float(
					(prev.doubleValue() + current.doubleValue()) / 2);

		}
		return average;
	}

	private static void countAverageVowels(Map<String, Float> result,
			Set<String> charset, int count, int wordLength) {
		String key = charset.toString() + ", " + wordLength;
		Float average = countAverage(result, count, wordLength,
				key);

		result.put(key, average);
	}

	private static Collection<String> decorateVowelsResult(
			Collection<String> result) {
		Collection<String> decoratedResult = new TreeSet<String>();
		for (String entry : result) {
			decoratedResult.add(VowelAverageDecorator
					.decorateResult(VowelCortegeDecorator.decorateResult(entry
							.toString())));
		}
		return decoratedResult;
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
