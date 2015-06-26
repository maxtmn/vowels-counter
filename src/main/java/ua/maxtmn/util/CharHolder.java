package ua.maxtmn.util;

import java.util.Set;
import java.util.TreeSet;

public class CharHolder extends TreeSet<String> implements
		Comparable<CharHolder> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CharHolder(Set<String> chSet) {
		super(chSet);
	}

	/*
	 * always return false. it never will be used for search in Maps.
	 */
	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	public int compareTo(CharHolder o) {
		return 0;
	}
}
