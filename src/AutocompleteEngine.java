import java.util.List;

public class AutocompleteEngine {
    private Trie hotTrie = new Trie();
    private Trie coldTrie = new Trie();
    
    public void loadData() {
        Thread hotLoader = new FileLoader(hotTrie, "C:/Users/Vinee/OneDrive/Desktop/AutoShelf/data/hot_data.txt");
        Thread coldLoader = new FileLoader(coldTrie, "C:/Users/Vinee/OneDrive/Desktop/AutoShelf/data/cold-data.txt");
        hotLoader.start();
        coldLoader.start();
        try {
            hotLoader.join();
            coldLoader.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getSuggestions(String prefix) {
        List<String> hotResults = hotTrie.getWordsByPrefix(prefix);
        if(! hotResults.isEmpty()) {
            System.out.println("Hot Suggestions:");
            hotResults.forEach(word -> System.out.println(word));
        }
        else {
            List<String> coldResults = coldTrie.getWordsByPrefix(prefix);
            if (!coldResults.isEmpty()) {
                System.out.println("Cold Suggestions:");
                coldResults.forEach(word -> System.out.println(word));
            }
            else {
                System.out.println("No suggestions found.");
            }
        }
    }
}
