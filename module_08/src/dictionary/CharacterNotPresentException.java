package dictionary;

public class CharacterNotPresentException extends ElementNotPresentException {

    CharacterNotPresentException(char character) {
        super("Character \"" + character + "\" is not present in the dictionary");
    }

}
