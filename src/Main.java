import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AutocompleteEngine engine = new AutocompleteEngine();
        engine.loadData();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a prefix to search (or 'exit'): ");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")) break;
            engine.getSuggestions(input);
        }

        sc.close();
    }
}
