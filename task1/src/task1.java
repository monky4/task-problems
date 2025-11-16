import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите параметры для 1-го массива: ");
        System.out.print("n = ");
        int n1 = in.nextInt();
        System.out.print("m = ");
        int m1 = in.nextInt();

        System.out.println("Введите параметры для 2-го массива: ");
        System.out.print("n = ");
        int n2 = in.nextInt();
        System.out.print("m = ");
        int m2 = in.nextInt();

        String result = getPath(n1,m1) + getPath(n2,m2);
        System.out.println(result);
    }

    public static String getPath(int n, int m) {
        String path = "";
        int intSt = 0;
        do {
            path = path + (intSt + 1);
            intSt = (intSt + m - 1) % n;
        } while (intSt != 0);
        return path;
    }

}
