import java.io.*;

public class FileLoader extends Thread {
    private Trie trie ;
    private String filePath ;

    public FileLoader(Trie trie,String filePath) {
        this.trie = trie;
        this.filePath = filePath;
    }

    public void run() {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while((word = br.readLine()) != null) {
                trie.insert(word.trim());
                System.out.println("Inserted: " + word);
            } 
        }
        catch(IOException ie) {
            System.out.println("Error loading file: " + filePath);
        }
    }
}
