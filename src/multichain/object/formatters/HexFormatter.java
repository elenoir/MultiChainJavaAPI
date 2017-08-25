package multichain.object.formatters;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class HexFormatter {

	private static final String CHARSET = "UTF-8";

	@Deprecated
	public static String toHexOld(String asciiValue) {
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < asciiValue.length(); i++) {
			hex.append(Integer.toHexString((int) asciiValue.charAt(i)));
		}
		return hex.toString();
	}

	public static String toHex(String asciiValue) {
		try {
			return Hex.encodeHexString(asciiValue.getBytes(CHARSET));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public static String fromHex(String hexValue) {
		try {
			final byte[] bytes = Hex.decodeHex(hexValue.toCharArray());
			return new String(bytes, CHARSET);
		} catch (DecoderException | UnsupportedEncodingException e) {
			return null;
		}
	}

}
