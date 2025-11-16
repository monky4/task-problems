import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class task3 {
    public static void main(String[] args) throws Exception {
        String valuesJson = Files.readString(Paths.get("values.json"));
        String testsJson = Files.readString(Paths.get("tests.json"));
        Map<String, String> idToValue = new HashMap<>();
        String[] lines = valuesJson.split("\n");

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("\"id\"")) {
                String id = lines[i].replaceAll("[^0-9]", "");
                String value = lines[i + 1].split("\"")[3];
                idToValue.put(id, value);
            }
        }

        String[] testLines = testsJson.split("\n");
        StringBuilder result = new StringBuilder();
        String currentId = null;

        for (String line : testLines) {
            if (line.contains("\"id\"")) {
                currentId = line.replaceAll("[^0-9]", "");
            }
            if (line.contains("\"value\": \"\"") && currentId != null && idToValue.containsKey(currentId)) {
                line = line.replace("\"\"", "\"" + idToValue.get(currentId) + "\"");
            }
            result.append(line).append("\n");
        }
        Files.write(Paths.get("report.json"), result.toString().getBytes());
    }
}