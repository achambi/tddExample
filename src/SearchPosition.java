/**
 * Util class to search end and start positions.
 */
class SearchPosition {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    static int searchEndPosition(int start, String input) {
        int endPosition = start + 1;
        boolean finish = false;
        for (int cont = start + 2; cont <= input.length() && !finish; cont++) {
            String character = input.substring(cont - 1, cont);
            try {
                Integer.parseInt(character);
                endPosition = cont;
            } catch (NumberFormatException e) {
                if (!isPoint(character)) {
                    finish = true;
                }
            }
        }
        return endPosition;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    static int searchStartPosition(int start, String input) {
        int startPosition = start - 1;
        boolean finish = false;
        for (int cont = start - 1; cont >= 0 && !finish; cont--) {
            String character = input.substring(cont, cont + 1);
            try {
                Integer.parseInt(character);
                startPosition = cont;
            } catch (NumberFormatException e) {
                if (!isPoint(character)) {
                    finish = true;
                }
            }
        }
        return startPosition;
    }

    private static boolean isPoint(String character) {
        return ".".equals(character);
    }
}
