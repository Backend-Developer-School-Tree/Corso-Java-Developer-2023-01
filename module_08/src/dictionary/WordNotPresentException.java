package dictionary;

public class WordNotPresentException extends ElementNotPresentException {
    WordNotPresentException(String word) {
        super("Word \"" + word + "\" is not present in the dictionary");
    }
}
