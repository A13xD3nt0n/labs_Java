import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class TI5 {

    private static int[][] h = {{0, 0, 0, 0, 1, 1, 0, 0, 0}, {0, 1, 1, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 1, 0, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 0, 0, 1}};
    private static int[][] ptran = new int[4][5];
    private static int[][] dp = new int[5][4];
    private static int[][] g = new int[5][9];
    private static ArrayList<String> list = new ArrayList<String>();
    private static ArrayList<String> errors = new ArrayList<String>();
    private static HashMap<Character, String> codes = new HashMap<Character, String>();

    private static String readLine() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static void makeChars(int[] xd, char xdd) {
        int[] res1 = multiplyMatrix(xd, g);
        String kek = "";
        for (int i = 0; i < g[0].length; i++) {
            kek += Integer.toString(res1[i]);
        }
        codes.put(xdd, kek);
        //   System.out.println(xdd + " - " + codes.get(xdd));
    }

    public static void main(String args[]) {
        setCodes(h);
        System.out.print("Введите строку для кодирования: ");
        String coding = readLine();
        System.out.println(coding);
        String resultCoding = "";
        for (int i = 0; i < coding.length(); i++) {
            resultCoding += codes.get(coding.charAt(i));
        }
        System.out.println("Код Хэмминга: " + resultCoding);
        System.out.print("Введите строку для декодирования: ");
        String decoding = readLine();
        String res12 = decode(decoding);
        if (res12 != null) {
            System.out.println("Закодированное сообщение: " + res12);
        } else {
            System.out.println("Данное сообщение раскодировать невозможно!");
        }
    }

    private static void setCodes(int[][] H) {
        for (int i = 0; i < ptran.length; i++) {
            for (int j = 0; j < ptran[0].length; j++) {
                ptran[i][j] = h[i][j];
            }
        }
        int[][] pt = transp(ptran);
        int[][] i = createI(5);
        for (int k = 0; k < 5; k++) {
            for (int j = 0; j < 9; j++) {
                if (j < 4) {
                    g[k][j] = pt[k][j];
                } else {
                    g[k][j] = i[k][j - 4];
                }
            }
        }
        makeChars(new int[]{0, 0, 0, 0, 0}, 'а');
        makeChars(new int[]{0, 0, 0, 0, 1}, 'б');
        makeChars(new int[]{0, 0, 0, 1, 0}, 'в');
        makeChars(new int[]{0, 0, 0, 1, 1}, 'г');
        makeChars(new int[]{0, 0, 1, 0, 0}, 'д');
        makeChars(new int[]{0, 0, 1, 0, 1}, 'е');
        makeChars(new int[]{0, 0, 1, 1, 0}, 'ж');
        makeChars(new int[]{0, 0, 1, 1, 1}, 'з');
        makeChars(new int[]{0, 1, 0, 0, 0}, 'и');
        makeChars(new int[]{0, 1, 0, 0, 1}, 'й');
        makeChars(new int[]{0, 1, 0, 1, 0}, 'к');
        makeChars(new int[]{0, 1, 0, 1, 1}, 'л');
        makeChars(new int[]{0, 1, 1, 0, 0}, 'м');
        makeChars(new int[]{0, 1, 1, 0, 1}, 'н');
        makeChars(new int[]{0, 1, 1, 1, 0}, 'о');
        makeChars(new int[]{0, 1, 1, 1, 1}, 'п');
        makeChars(new int[]{1, 0, 0, 0, 0}, 'р');
        makeChars(new int[]{1, 0, 0, 0, 1}, 'с');
        makeChars(new int[]{1, 0, 0, 1, 0}, 'т');
        makeChars(new int[]{1, 0, 0, 1, 1}, 'у');
        makeChars(new int[]{1, 0, 1, 0, 0}, 'ф');
        makeChars(new int[]{1, 0, 1, 0, 1}, 'х');
        makeChars(new int[]{1, 0, 1, 1, 0}, 'ц');
        makeChars(new int[]{1, 0, 1, 1, 1}, 'ч');
        makeChars(new int[]{1, 1, 0, 0, 0}, 'ш');
        makeChars(new int[]{1, 1, 0, 0, 1}, 'щ');
        makeChars(new int[]{1, 1, 0, 1, 0}, 'ъ');
        makeChars(new int[]{1, 1, 0, 1, 1}, 'ы');
        makeChars(new int[]{1, 1, 1, 0, 0}, 'ь');
        makeChars(new int[]{1, 1, 1, 0, 1}, 'э');
        makeChars(new int[]{1, 1, 1, 1, 0}, 'ю');
        makeChars(new int[]{1, 1, 1, 1, 1}, 'я');
    }

    private static int[][] createI(int count) {
        int[][] b = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        for (int i = 0; i < count; i++) {
            b[i][i] = 1;
        }
        return b;
    }

    private static int[][] transp(int[][] input) {
        int[][] result = new int[input[0].length][input.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = input[j][i];
            }
        }
        return result;
    }

    private static void printMatrix(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] multiplyMatrix(int[] inp, int[][] pr) {
        int[] result = new int[pr[0].length];
        int k = 0;
        int buf = 0;
        for (int j = 0; j < result.length; j++) {
            for (int i = 0; i < inp.length; i++) {
                buf = buf + inp[i] * pr[i][j];
            }
            result[k] = buf % 2;
            buf = 0;
            k++;
        }
        return result;
    }

    private static String decode(String input) {
        String result = "";
        if (input.length() % 9 != 0) {
            return "В введенном тексте не хватает символов!";
        } else {
            int kol = 1;
            String buffer = "";
            for (int i = 0; i < input.length(); i++) {
                if (kol != 9) {
                    buffer += input.charAt(i);
                } else {
                    buffer += input.charAt(i);
                    list.add(buffer);
                    buffer = "";
                    kol = 0;
                }
                kol++;
            }

            HashMap<String, Character> rever = new HashMap<String, Character>();
            for (int i = 0; i < codes.size(); i++) {
                rever.put(codes.get((char) ((int) ('а') + i)), (char) ((int) ('а') + i));
            }
            for (int k = 0; k < list.size(); k++) {
                if ("0000".equals(toStringInt(multiplyMatrix(toIntString01(list.get(k)), transp(h))))) {
                    result += rever.get(list.get(k));
                } else {
                    result += rever.get(findError(list.get(k), rever, k));
                }
            }
            if (errors.size() != 0) {
                System.out.print("Ошибки обнаружены в ");
                for (int i = 0; i < errors.size(); i++) {
                    System.out.print(errors.get(i) + " ");
                }
                System.out.println();
            }
            return result;
        }
    }

    private static String toStringInt(int[] inp) {
        String result = "";
        for (int i = 0; i < inp.length; i++) {
            result += Integer.toString(inp[i]);
        }
        return result;
    }

    private static int[] toIntString01(String text) {
        int[] result = new int[text.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) text.charAt(i) - 48;
        }
        return result;
    }

    private static String findError(String text, HashMap<String, Character> rever, int k) {
        String result = "";
        String rofl = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '0') {
                rofl = new StringBuilder(text).insert(i, '1').replace(i + 1, i + 2, "").toString();
            } else {
                rofl = new StringBuilder(text).insert(i, '0').replace(i + 1, i + 2, "").toString();
            }
            if (rever.get(rofl) != null) {
                errors.add(Integer.toString(1 + i + k * 9));
                return rofl;
            }
        }
        return result;
    }
}
