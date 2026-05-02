package herra.string;

public class HString {
    public static int occ(String from, char which) {
        int occurence = 0;

        for(int i = 0; i < from.length(); i++) {
            if(from.charAt(i) == which)
                occurence++;
        }

        return occurence;
    }
}