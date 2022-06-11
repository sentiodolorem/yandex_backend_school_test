package solutions;

import java.util.Scanner;

public class A {
    private final static Scanner scanner = new Scanner(System.in);

    public static void solve() {
        String fi = scanner.nextLine();
        String se = scanner.nextLine();
        int n = fi.length();
        int[] have = new int[256];
        for (int i = 0; i < n; ++i) {
            ++have[fi.charAt(i)];
        }
        String[] answers = new String[fi.length()];
        for (int i = 0; i < n; ++i) {
            if (fi.charAt(i) == se.charAt(i)) {
                answers[i] = "correct";
                --have[se.charAt(i)];
            }
        }
        for (int i = 0; i < n; ++i) {
            if (answers[i] != null) {
                continue;
            }
            if (have[se.charAt(i)] > 0) {
                answers[i] = "present";
                --have[se.charAt(i)];
            }
            else {
                answers[i] = "absent";
            }
        }
        for (int i = 0; i < n; ++i) {
            System.out.println(answers[i]);
        }
    }
}
