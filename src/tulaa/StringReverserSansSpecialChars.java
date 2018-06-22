package tulaa;

public class StringReverserSansSpecialChars {

    public static void main(String[] args) {
        StringReverserSansSpecialChars reverser = new StringReverserSansSpecialChars();
        System.out.println(String.format("%s => %s", "Tes!t$", reverser.swap("Tes!t$")));
        System.out.println(String.format("%s => %s", "a,b$c", reverser.swap("a,b$c")));
        System.out.println(String.format("%s => %s", "Ab,c,de!$", reverser.swap("Ab,c,de!$")));
    }

    public String swap(String input) {
        if (null != input && input.trim().length() > 0) {
            char[] elems = input.toCharArray();
            for (int startCounter = 0, endCounter = input.length() - 1;
                 startCounter < input.length()/2; ) {
                char startCurr = elems[startCounter];
                char endCurr = elems[endCounter];
                if  (withinASCIIRange(startCurr)) {
                    if (withinASCIIRange(endCurr)) {
                        elems[startCounter] = elems[endCounter];
                        elems[endCounter] = startCurr;
                        startCounter++;
                        endCounter--;
                    } else
                        endCounter--;
                } else
                    startCounter++;
            }
            return String.valueOf(elems);
        } else
            return input;
    }

    private boolean withinASCIIRange(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
