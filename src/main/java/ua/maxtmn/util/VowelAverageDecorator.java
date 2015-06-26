package ua.maxtmn.util;

public class VowelAverageDecorator {

	String result;

	public VowelAverageDecorator(String result) {
		super();
		this.result = result;
	}

	@Override
	public String toString() {
		if (result == null) {
			return "";
		}
		return result.replace("=", " -> ");
	}
}
