package de.ub0r.android.websms.connector.betamax;

import java.util.HashMap;
import java.util.Map;

public class CharacterTable {
	
	private static final Map<String, String> map = new HashMap<String, String>(512);
	
	private static final String UNKNOWN_CHAR = "%3F"; // ?

	private static String VALID_CHARACTERS = null;
	
	static {
		map.put("£", "\u0001");
		map.put("$", "\u0002");
		map.put("¥", "\u0003");
		map.put("è", "\u0004");
		map.put("é", "\u0005");
		map.put("ù", "\u0006");
		map.put("ì", "\u0007");
		map.put("ò", "\u0008");
		map.put("Ç", "\u0009");
		map.put("Ø", "\u000B");
		map.put("ø", "\u000C");
		map.put("Å", "\u000E");
		map.put("å", "\u000F");
		map.put("_", "\u0011");
		map.put("Æ", "\u001C");
		map.put("æ", "\u001D");
		map.put("ß", "\u001E");
		map.put("É", "\u001F");
		map.put(" ", "\u0020");
		map.put("!", "\u0021");
		map.put("\"", "\""); // \u0022
		map.put("#", "\u0023");
		map.put("%", "\u0025");
		map.put("&", "\u0026");
		map.put("'", "\u0027");
		map.put("(", "\u0028");
		map.put(")", "\u0029");
		map.put("*", "\u002A");
		map.put("+", "\u002B");
		map.put(",", "\u002C");
		map.put("-", "\u002D");
		map.put(".", "\u002E");
		map.put("/", "\u002F");
		map.put("0", "\u0030");
		map.put("1", "\u0031");
		map.put("2", "\u0032");
		map.put("3", "\u0033");
		map.put("4", "\u0034");
		map.put("5", "\u0035");
		map.put("6", "\u0036");
		map.put("7", "\u0037");
		map.put("8", "\u0038");
		map.put("9", "\u0039");
		map.put(":", "\u003A");
		map.put(";", "\u003B");
		map.put("<", "\u003C");
		map.put("=", "\u003D");
		map.put(">", "\u003E");
		map.put("?", "\u003F");
		map.put("¡", "\u0040");
		map.put("A", "\u0041");
		map.put("B", "\u0042");
		map.put("C", "\u0043");
		map.put("D", "\u0044");
		map.put("E", "\u0045");
		map.put("F", "\u0046");
		map.put("G", "\u0047");
		map.put("H", "\u0048");
		map.put("I", "\u0049");
		map.put("J", "\u004A");
		map.put("K", "\u004B");
		map.put("L", "\u004C");
		map.put("M", "\u004D");
		map.put("N", "\u004E");
		map.put("O", "\u004F");
		map.put("P", "\u0050");
		map.put("Q", "\u0051");
		map.put("R", "\u0052");
		map.put("S", "\u0053");
		map.put("T", "\u0054");
		map.put("U", "\u0055");
		map.put("V", "\u0056");
		map.put("W", "\u0057");
		map.put("X", "\u0058");
		map.put("Y", "\u0059");
		map.put("Z", "\u005A");
		map.put("Ä", "\u005B");
		map.put("Ö", "\\"); // \u005C
		map.put("Ñ", "\u005D");
		map.put("Ü", "\u005E");
		map.put("§", "\u005F");
		map.put("¿", "\u0060");
		map.put("a", "\u0061");
		map.put("b", "\u0062");
		map.put("c", "\u0063");
		map.put("d", "\u0064");
		map.put("e", "\u0065");
		map.put("f", "\u0066");
		map.put("g", "\u0067");
		map.put("h", "\u0068");
		map.put("i", "\u0069");
		map.put("j", "\u006A");
		map.put("k", "\u006B");
		map.put("l", "\u006C");
		map.put("m", "\u006D");
		map.put("n", "\u006E");
		map.put("o", "\u006F");
		map.put("p", "\u0070");
		map.put("q", "\u0071");
		map.put("r", "\u0072");
		map.put("s", "\u0073");
		map.put("t", "\u0074");
		map.put("u", "\u0075");
		map.put("v", "\u0076");
		map.put("w", "\u0077");
		map.put("x", "\u0078");
		map.put("y", "\u0079");
		map.put("z", "\u007A");
		map.put("ä", "\u007B");
		map.put("ö", "\u007C");
		map.put("ñ", "\u007D");
		map.put("ü", "\u007E");
		map.put("à", "\u007F");
		map.put("\n", "\n"); // \u000A
		map.put("\r", "");
		
		String[] arr = map.keySet().toArray(new String[0]);
		StringBuffer strb = new StringBuffer(map.size());
		for (String vc: arr) {
			strb.append(vc);
		}
		VALID_CHARACTERS = strb.toString();
	}

	public static String encodeString(String str) {
		StringBuffer strb = new StringBuffer(str.length()*3+4);

		final int length = str.length();
		for (int offset = 0; offset < length; ) {
		   final int codepoint = str.codePointAt(offset);
		   offset += Character.charCount(codepoint);
		   String chr = map.get(String.valueOf((char) codepoint));
		   if (chr == null) {
			   strb.append(UNKNOWN_CHAR);
		   } else {
				strb.append(chr);   
		   }
		}
		return strb.toString();
	}

	public static String getValidCharacters() {
		return CharacterTable.VALID_CHARACTERS;
	}


	
}
