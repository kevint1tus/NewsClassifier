package uob.oop;

public class NLP {
    /***
     * Clean the given (_content) text by removing all the characters that are not 'a'-'z', '0'-'9' and white space.
     * @param _content Text that need to be cleaned.
     * @return The cleaned text.
     */
    public static String textCleaning(String _content) {
        StringBuilder sbContent = new StringBuilder();
        //TODO Task 2.1 - 3 marks
        for (char c : _content.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || Character.isWhitespace(c)) {
                sbContent.append(c);
            }
        }

        return sbContent.toString().trim();
    }

    /***
     * Text lemmatization. Delete 'ing', 'ed', 'es' and 's' from the end of the word.
     * @param _content Text that need to be lemmatized.
     * @return Lemmatized text.
     */
    public static String textLemmatization(String _content) {
        StringBuilder sbContent = new StringBuilder();
        //TODO Task 2.2 - 3 marks
        String[] arrayTokenized = _content.split(" ");
        for (String s : arrayTokenized) {
            if (s.endsWith("ing")) {
                sbContent.append(s, 0, s.length() - 3).append(" ");
            } else if (s.endsWith("ed") || s.endsWith("es")) {
                sbContent.append(s, 0, s.length() - 2).append(" ");
            } else if (s.endsWith("s")) {
                sbContent.append(s, 0, s.length() - 1).append(" ");
            } else {
                sbContent.append(s).append(" ");
            }
        }

        return sbContent.toString().trim();
    }

    /***
     * Remove stop-words from the text.
     * @param _content The original text.
     * @param _stopWords An array that contains stop-words.
     * @return Modified text.
     */
    public static String removeStopWords(String _content, String[] _stopWords) {
        StringBuilder mySB = new StringBuilder();
        //TODO Task 2.3 - 3 marks
        String[] wordsList = _content.split(" ");
        for (String word : wordsList) {
            if (notContains(_stopWords, word)) {
                mySB.append(word).append(" ");
            }
        }

        return mySB.toString().trim();
    }

    private static boolean notContains(String[] _arrayTarget, String _searchValue) {
        for (String element : _arrayTarget) {
            if (_searchValue.equals(element)) {
                return false;
            }
        }
        return true;
    }

}
