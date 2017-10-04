package com.bocobi2.orientation.util;

public class Cryptage {
	public static String cryptographe(String text) {

		// char crypte;
		String cryptef = "";

		int nbre = text.length();
		
		String crypte = "";
		for (int i = 0; i < text.length(); i++) {
			int c = text.charAt(i) ^ 48;
			char crypteC = (char) c;
			if (crypteC == '\\') {
				crypte = crypte + "\\" + crypteC;
			} else {
				crypte = crypte + crypteC;
			}

		}

		return crypte;
	}

	public static String decryptographe(String text) {
		String aCrypter = "";
		for (int i = 0; i < text.length(); i++) {
			int c = text.charAt(i) ^ 48;
			aCrypter = aCrypter + (char) c;
		}

		return aCrypter;
	}

}
