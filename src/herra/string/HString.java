package herra.string;

public class HString {
/**
 * <h2>occ</h2> {@link herra.string.HString#occ(String, char)}<p>
 * Search the occurence of {@code which} in {@code from}
 * 
 * @param from 
 * @param which
 * @return {@code int} occurence of {@code which} in {@code from}
 */
    public static int occ(String from, char which) {
        int occurence = 0;

        for(int i = 0; i < from.length(); i++) {
            if(from.charAt(i) == which)
                occurence++;
        }

        return occurence;
    }
}