package dictionary;

import java.util.*;

public class Dictionary {

    Map<Character, Map<String, Set<String>>> dictionary;

    public Dictionary() {
        this.dictionary = new TreeMap<>();
    }

    public void insertWord(String word, String meaning) {
        if(word == null || meaning == null)
            return;
        word = word.toLowerCase();
        Character firstLetter = word.charAt(0);
        // letter already present
        if(dictionary.containsKey(firstLetter)) {
            // word already present
            if (dictionary.get(firstLetter).containsKey(word))
                dictionary.get(firstLetter).get(word).add(meaning);
                // word not present
            else {
                Set<String> meanings = new TreeSet<>();
                meanings.add(meaning);
                dictionary.get(firstLetter).put(word, meanings);
            }
        }
        // letter not present
        else {
            Map<String, Set<String>> words = new TreeMap<>();
            Set<String> meanings = new TreeSet<>();
            meanings.add(meaning);
            words.put(word, meanings);
            dictionary.put(firstLetter, words);
        }
    }

    public void addMeanings(String word, Set<String> meanings) throws CharacterNotPresentException, WordNotPresentException {
        if (word == null || meanings == null || meanings.isEmpty())
            return;
        word = word.toLowerCase();
        Character firstLetter = word.charAt(0);
        if(!dictionary.containsKey(firstLetter))
            throw new CharacterNotPresentException(firstLetter);
        if(!dictionary.get(firstLetter).containsKey(word))
            throw new WordNotPresentException(word);
        dictionary.get(firstLetter).get(word).addAll(meanings);
    }

    public String printDictionary() {
        StringBuilder text = new StringBuilder();
        for (Character letter : dictionary.keySet()) {
            Set<String> words = new HashSet<>();
            for (String word : dictionary.get(letter).keySet()) {
                String meanings = String.join(";", dictionary.get(letter).get(word));
                words.add(word + ": (" + meanings + ")");
            }
            text.append(letter).append(":[").append(String.join(", ", words)).append("]\n");
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.insertWord("retina", "Rete, spesso elastica, indossata sopra i capelli lunghi per tenerli in posizione");
        dictionary.insertWord("retina", "La rètina è la membrana più interna del bulbo oculare");
        dictionary.insertWord("calcio", "sport di squadra");
        dictionary.insertWord("calcio", "elemento chimico");
        dictionary.insertWord("calcio", "colpo dato col piede");
        dictionary.insertWord("calcio", "comune di 5353 abitanti");
        dictionary.insertWord("calcio", "impugnatura del fucile");
        dictionary.insertWord("circuito", "circuito elettrico");
        dictionary.insertWord("circuito", "circuito chiuso dove si svolgono corse");
        Set<String> meanings = new HashSet<>();
        meanings.add("circuito commerciale");
        try {
            dictionary.addMeanings("circuito", meanings);
        } catch (CharacterNotPresentException e) {
            System.out.println("letter c not found");
        } catch (WordNotPresentException e) {
            System.out.println("word circuito not found");
        }
        System.out.println(dictionary.printDictionary());
    }

}