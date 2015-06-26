package ua.maxtmn.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;

public class FileHelperTest extends TestCase {

	public void test_type() throws Exception {
		assertNotNull(FileHelper.class);
	}

	public void test_instantiation() throws Exception {
		FileHelper target = new FileHelper();
		assertNotNull(target);
	}

	public void test_readWordsFromFile_A$String() throws Exception {
		String pathToFile = "src/test/resources/input.txt";
		Collection<String> actual = FileHelper.readWordsFromFile(pathToFile);
		Collection<String> expected = Arrays.asList("Platon", "made", "bamboo",
				"boats");
		assertEquals(expected, actual);
	}

	public void test_writeResultToFile_A$String$Collection() throws Exception {
		String pathToFile = "src/test/resources/output.txt";
		Collection<String> content = Arrays.asList("({a, e},4)->2.0",
				"({a, o},5)->2.5", "({a, o},6)->3.0");
		boolean actual = FileHelper.writeResultToFile(pathToFile, content);
		boolean expected = true;
		assertEquals(expected, actual);
		Files.delete(Paths.get(pathToFile));
	}

}
