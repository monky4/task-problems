import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class task2 {
    public static void main(String[] args) throws Exception{
        double xCenter;
        double yCenter;
        double a;
        double b;

        List<String> lines1 = Files.readAllLines(Paths.get("file1.txt"));

        String[] firstLine = lines1.get(0).split("\\s+");
        xCenter = Double.parseDouble(firstLine[0]);
        yCenter = Double.parseDouble(firstLine[1]);

        String[] secondLine = lines1.get(1).split("\\s+");
        a = Double.parseDouble(secondLine[0]);
        b = Double.parseDouble(secondLine[1]);

        List<String> lines2 = Files.readAllLines(Paths.get("file2.txt"));
        for (String line : lines2) {
            String[] parts = line.trim().split("\\s+");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            System.out.println(findPosition(xCenter, yCenter, a, b, x, y));
        }
    }

    public static int findPosition(double xCenter, double yCenter, double a,
                                   double b, double x, double y) {
        double equation = Math.pow(x - xCenter, 2) / (a * a) + Math.pow(y - yCenter, 2) / (b *b);
        int result;

        if (equation == 1) {
            result = 0;
        } else if (equation < 1) {
            result = 1;
        } else {
            result = 2;
        }
        return result;
    }
}
