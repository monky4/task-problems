import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class task4 {
    public static void main(String[] args) throws Exception {
            List<String> lines = Files.readAllLines(Paths.get("numbers.txt"));
            int[] numbers = new int[lines.size()];

            for (int i = 0; i < lines.size(); i++) {
                numbers[i] = Integer.parseInt(lines.get(i).trim());
            }

            double sum = 0;
            for (int i : numbers) {
                sum += i;
            }

            int avrNumber = (int) Math.round(sum / numbers.length);
            int n = 0;

            while (n <= 20) {
                int k = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] > avrNumber) {
                        numbers[i] -= 1;
                        n += 1;
                    } else if (numbers[i] < avrNumber) {
                        numbers[i] += 1;
                        n += 1;
                    } else {
                        k += 1;
                    }
                }
                if (k == numbers.length) {
                    System.out.println(n);
                    System.exit(0);
                }
            }
            System.out.println("20 ходов недостаточно для приведения всех элементов массива к одному числу");
    }
}

