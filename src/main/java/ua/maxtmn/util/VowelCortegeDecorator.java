package ua.maxtmn.util;

public class VowelCortegeDecorator {

	String result;

	public VowelCortegeDecorator(String result) {
		super();
		this.result = result;
	}

	@Override
	public String toString() {
		if (result == null) {
			return "";
		}
		return "("
				+ result.replace("=", ", ").replace("[", "{").replace("]", "}")
				+ ")";
	}
}
