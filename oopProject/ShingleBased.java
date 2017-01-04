package oopProject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


class ShingleBased {

    private final int k = 5;

    private static final Pattern SPACE_REG = Pattern.compile("\\s+");

    public final Map<String, Integer> getProfile(final String string) {
        HashMap<String, Integer> shingles = new HashMap<String, Integer>();

        String string_no_space = SPACE_REG.matcher(string).replaceAll(" ");
        for (int i = 0; i < (string_no_space.length() - k + 1); i++) {
            String shingle = string_no_space.substring(i, i + k);
            Integer old = shingles.get(shingle);
            if (old!=null) {
                shingles.put(shingle, old + 1);
            } else {
                shingles.put(shingle, 1);
            }
        }

        return Collections.unmodifiableMap(shingles);
    }

}
