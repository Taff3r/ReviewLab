import java.util.*;
import java.io.*;
import java.util.regex.*;

/**
 * Class for searching a file for a regex pattern.
 *
 */
public class Searcher {
    private Pattern pat;
    private String path; 

    /**
     * Creates a Searcher looking for pattern pat in file filePath.
     */
    public Searcher(String pat, String filePath) {
        this.pat = Pattern.compile("(?=.*" + pat + ")"); // Add flags to regex
        this.path = filePath;
    }

    /**
     * Searches the file for lines matching the pattern in the file.
     * @return List<String> the matched lines.
     * @throws FileNotFoundException if the file cannot be found 
     * @throws IOException If the file cannot be read properly 
     */
    public List<String> search() throws IOException, FileNotFoundException {
        List<String> matchedLines = new ArrayList<>();
        BufferedReader reader;

        reader = new BufferedReader(new FileReader(this.path));
        String line;
        while((line = reader.readLine()) != null) {
            Matcher m = this.pat.matcher(line);
            if (m.find())
                matchedLines.add(line);
        }
        reader.close(); // Close file
        return matchedLines; 
    }
}
