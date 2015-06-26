package ua.maxtmn.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Provide additional util methods to file processing.
 * 
 * @author Tereshchenko
 * 
 */
public class FileHelper {

	public static Collection<String> readWordsFromFile(String pathToFile)
			throws IOException {
		Collection<String> words = new ArrayList<>();
		Path path = Paths.get(pathToFile);
		try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNext()) {
				words.add(scanner.next().replaceAll("[\\.,-]", ""));
			}
		}

		return words;

	}

	public static boolean writeResultToFile(String pathToFile,
			Collection<String> content) throws IOException {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(pathToFile),
					StandardCharsets.UTF_8.name()));
			for (String line : content) {
				writer.write(line);
				((BufferedWriter) writer).newLine();
			}
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
		return true;
	}

}
