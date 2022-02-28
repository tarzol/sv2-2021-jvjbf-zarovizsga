package sentences;

public class SentenceTransformer {

    private static final String ENDING = ".?!";

    public String shortenSentence(String sentence) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        if ( sentence.charAt(0) != sentence.toUpperCase().charAt(0) ) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        char lastChar = sentence.charAt(sentence.length()-1);
        if (!ENDING.contains(Character.toString(lastChar))) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
        String[] sentenceArray = sentence.split(" ");
        int length = sentenceArray.length;
        if (length >= 5) {
            return sb.append(sentenceArray[0]).append(" ... ").append(sentenceArray[length-1]).toString();
        }
        return sentence;
    }
}
