package com.zjw.security.totp;

import java.util.Arrays;

/**
 * Minimal RFC 4648 Base32 encoder/decoder (no third-party libs).
 * - Alphabet: "A–Z2–7"
 * - Case-insensitive on decode
 * - Ignores spaces and '-' on decode
 * - Supports padding ('=') on encode; decode accepts with/without padding
 */
public final class Base32 {

    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".toCharArray();
    // ASCII lookup table: value = 0..31 for valid chars, -1 invalid
    private static final int[] DECODE_TABLE = new int[128];

    static {
        Arrays.fill(DECODE_TABLE, -1);
        for (int i = 0; i < ALPHABET.length; i++) {
            char uc = ALPHABET[i];
            DECODE_TABLE[uc] = i;
            char lc = (char) (uc | 0x20); // lowercase
            if (lc < DECODE_TABLE.length) DECODE_TABLE[lc] = i;
        }
        // Allow common separators to be skipped in decode (handled in sanitize step)
    }

    private Base32() {}

    /** Base32 encode with padding ('='). */
    public static String encode(byte[] data) {
        return encode(data, true);
    }

    /**
     * Base32 encode.
     * @param data input bytes
     * @param pad  whether to append '=' padding to multiples of 8 chars
     */
    public static String encode(byte[] data, boolean pad) {
        if (data == null || data.length == 0) return "";

        StringBuilder out = new StringBuilder(((data.length + 4) / 5) * 8);
        int i = 0;
        while (i < data.length) {
            int b0 = data[i++] & 0xFF;
            int b1 = (i < data.length) ? (data[i++] & 0xFF) : -1;
            int b2 = (i < data.length) ? (data[i++] & 0xFF) : -1;
            int b3 = (i < data.length) ? (data[i++] & 0xFF) : -1;
            int b4 = (i < data.length) ? (data[i++] & 0xFF) : -1;

            // 5 bytes -> 8 symbols (or fewer if tail)
            int i0 = (b0 >>> 3) & 0x1F;
            int i1 = ((b0 & 0x07) << 2) | ((b1 >= 0 ? b1 : 0) >>> 6);
            int i2 = (b1 >= 0) ? ((b1 >>> 1) & 0x1F) : -1;
            int i3 = (b1 >= 0)
                    ? (((b1 & 0x01) << 4) | ((b2 >= 0 ? b2 : 0) >>> 4))
                    : -1;
            int i4 = (b2 >= 0)
                    ? (((b2 & 0x0F) << 1) | ((b3 >= 0 ? b3 : 0) >>> 7))
                    : -1;
            int i5 = (b3 >= 0) ? ((b3 >>> 2) & 0x1F) : -1;
            int i6 = (b3 >= 0)
                    ? (((b3 & 0x03) << 3) | ((b4 >= 0 ? b4 : 0) >>> 5))
                    : -1;
            int i7 = (b4 >= 0) ? (b4 & 0x1F) : -1;

            // Emit chars with optional padding
            out.append(ALPHABET[i0]);
            out.append(ALPHABET[i1 & 0x1F]);

            if (b1 < 0) {
                if (pad) out.append("======");
                break;
            }
            out.append(ALPHABET[i2]);

            if (b2 < 0) {
                if (pad) out.append('=').append("====");
                break;
            }
            out.append(ALPHABET[i3]);

            if (b3 < 0) {
                if (pad) out.append(ALPHABET[i4]).append("===");
                else     out.append(ALPHABET[i4]);
                break;
            }
            out.append(ALPHABET[i4]);
            out.append(ALPHABET[i5]);

            if (b4 < 0) {
                if (pad) out.append(ALPHABET[i6]).append('=');
                else     out.append(ALPHABET[i6]);
                break;
            }
            out.append(ALPHABET[i6]);
            out.append(ALPHABET[i7]);
        }
        return out.toString();
    }

    /** Base32 decode (accepts upper/lower case, with/without padding). */
    public static byte[] decode(String input) {
        if (input == null || input.isEmpty()) return new byte[0];

        String s = sanitize(input);
        if (s.isEmpty()) return new byte[0];

        // If not multiple of 8, pad to next multiple (RFC allows omitting '=' in practice)
        int rem = s.length() % 8;
        if (rem != 0) {
            int need = 8 - rem;
            StringBuilder sb = new StringBuilder(s.length() + need);
            sb.append(s);
            for (int k = 0; k < need; k++) sb.append('=');
            s = sb.toString();
        }

        // Each 8 chars -> up to 5 bytes
        byte[] out = new byte[(s.length() / 8) * 5];
        int outPos = 0;

        for (int p = 0; p < s.length(); p += 8) {
            int[] v = new int[8];
            int padCount = 0;
            for (int j = 0; j < 8; j++) {
                char c = s.charAt(p + j);
                if (c == '=') {
                    v[j] = 0; // value not used; keep 0
                    padCount++;
                } else if (c < 128 && DECODE_TABLE[c] >= 0) {
                    v[j] = DECODE_TABLE[c];
                } else {
                    throw new IllegalArgumentException("Invalid Base32 character: '" + c + "' at pos " + (p + j));
                }
            }

            int b0 = (v[0] << 3) | (v[1] >>> 2);
            int b1 = ((v[1] & 0x03) << 6) | (v[2] << 1) | (v[3] >>> 4);
            int b2 = ((v[3] & 0x0F) << 4) | (v[4] >>> 1);
            int b3 = ((v[4] & 0x01) << 7) | (v[5] << 2) | (v[6] >>> 3);
            int b4 = ((v[6] & 0x07) << 5) | v[7];

            switch (padCount) {
                case 0: // 8 symbols -> 5 bytes
                    out[outPos++] = (byte) b0;
                    out[outPos++] = (byte) b1;
                    out[outPos++] = (byte) b2;
                    out[outPos++] = (byte) b3;
                    out[outPos++] = (byte) b4;
                    break;
                case 1: // "xxxxxxx=" -> 4 bytes
                    out[outPos++] = (byte) b0;
                    out[outPos++] = (byte) b1;
                    out[outPos++] = (byte) b2;
                    out[outPos++] = (byte) b3;
                    break;
                case 3: // "xxxxx===" -> 3 bytes
                    out[outPos++] = (byte) b0;
                    out[outPos++] = (byte) b1;
                    out[outPos++] = (byte) b2;
                    break;
                case 4: // "xxxx====" -> 2 bytes
                    out[outPos++] = (byte) b0;
                    out[outPos++] = (byte) b1;
                    break;
                case 6: // "xx======" -> 1 byte
                    out[outPos++] = (byte) b0;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Base32 padding at block starting " + p);
            }
        }
        return Arrays.copyOf(out, outPos);
    }

    /** Remove spaces, hyphens, collapse padding in the middle, trim trailing padding. */
    private static String sanitize(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Skip common separators/whitespace
            if (c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '-') continue;
            sb.append(c);
        }
        // Trim trailing '=' (we handle per-block padding anyway)
        int end = sb.length();
        while (end > 0 && sb.charAt(end - 1) == '=') end--;
        return sb.substring(0, end);
    }

    // --- quick self-test ---
    public static void main(String[] args) {
        roundtrip("HelloWorld");
        roundtrip("");
        roundtrip("f");
        roundtrip("fo");
        roundtrip("foo");
        roundtrip("foob");
        roundtrip("fooba");
        roundtrip("foobar");

        // Example without padding
        byte[] raw = "HelloWorld".getBytes();
        String noPad = Base32.encode(raw, false);
        System.out.println("NoPad  : " + noPad);
        System.out.println("Decoded: " + new String(Base32.decode(noPad)));
    }

    private static void roundtrip(String s) {
        byte[] raw = s.getBytes();
        String enc = Base32.encode(raw, true);
        byte[] dec = Base32.decode(enc);
        System.out.printf("'%s' -> %s -> '%s'%n", s, enc, new String(dec));
    }
}
