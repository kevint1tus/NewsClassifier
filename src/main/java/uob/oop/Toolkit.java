package uob.oop;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class Toolkit {
    private String resourcesDirectory = "src/main/resources/News";
    private int currentIndex = 0;
    private final String FILENAME_STOPWORDS = "stopwords.csv";

    public String[] loadHTML() {
        String[] myHTML = new String[9999];

        try (Stream<Path> paths = Files.walk(Paths.get(resourcesDirectory))) {
            paths.filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".htm"))
                    .sorted(Comparator.comparing(Path::getFileName))
                    .forEach(p -> {
                        StringBuilder content = new StringBuilder();
                        try (BufferedReader br = Files.newBufferedReader(p)) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                content.append(line).append("\n");
                            }
                            myHTML[currentIndex++] = content.toString();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }


        return trimArray(myHTML, currentIndex);
    }

    private String[] trimArray(String[] _arrayTarget, int _newSize) {
        String[] trimmedArray = new String[_newSize];
        System.arraycopy(_arrayTarget, 0, trimmedArray, 0, _newSize);
        return trimmedArray;
    }

    public String[] loadStopWords() {
        String[] listStopWords = new String[127];

        try (BufferedReader myReader = new BufferedReader(new FileReader(Toolkit.getFileFromResource(FILENAME_STOPWORDS)))) {
            String resultLine = myReader.readLine();
            int i = 0;
            while (resultLine != null) {
                listStopWords[i] = resultLine;
                resultLine = myReader.readLine();
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        return listStopWords;
    }

    private static File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = Toolkit.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }
}
