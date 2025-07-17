import java.util.*;

public class VocabularyManager {
    private static VocabularyManager instance;
    private List<Word> words;
    private List<ProgressObserver> observers;

    private VocabularyManager() {
        words = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static VocabularyManager getInstance() {
        if (instance == null) {
            instance = new VocabularyManager();
        }
        return instance;
    }

    public void addWord(Word word) {
        words.add(word);
        for (ProgressObserver obs : observers) {
            obs.onWordAdded(word);
        }
    }
    
    public List<Word> getAllWords() {
        return words;
    }

    public void registerObserver(ProgressObserver observer) {
        observers.add(observer);
    }
public boolean isWordExists(String term) {
    for (Word word : words) {
        if (word.getTerm().equalsIgnoreCase(term)) {
            return true;
        }
    }
    return false;
}

}
