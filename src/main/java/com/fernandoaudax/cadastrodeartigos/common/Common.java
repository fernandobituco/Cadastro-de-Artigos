package com.fernandoaudax.cadastrodeartigos.common;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class Common {
    public static String generateSlug(String text) {

        final Pattern NONLATIN = Pattern.compile("[^\\w-]");
        final Pattern WHITESPACE = Pattern.compile("[\\s]");
        String nowhitespace = WHITESPACE.matcher(text).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        System.out.println(slug.toLowerCase(Locale.ENGLISH));
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String getTime() {
        TimeZone tz = TimeZone.getTimeZone("GMT-3:00");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        return df.format(new Date());
    }
}
