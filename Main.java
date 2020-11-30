import java.util.List;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Missing input parameters!");
            System.out.println("Usage: java Main <pattern> <file>");
            System.exit(1);
        }

        Searcher s = new Searcher(args[0], args[1]);
        try {

        List<String> matchedLines = s.search();
        System.out.println("Matched lines in file " + args[1] + ":");
        for (String l : matchedLines) 
            System.out.println("\t" + l);
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found!");
            System.exit(1); 
        } catch (IOException e) {
            System.err.println("File was incorrectly formatted!");
            System.exit(1);
        }
    }
}
