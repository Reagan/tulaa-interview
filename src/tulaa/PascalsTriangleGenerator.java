package tulaa;

public class PascalsTriangleGenerator {

    public static void main(String[] args) {
        PascalsTriangleGenerator generator = new PascalsTriangleGenerator();
        generator.generate(3);
    }

    private void generate(int level) {
        level += 1;
        for (int i = 0; i < level; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == level - 1)
                    System.out.print(pascal(i, j) + " ");
            }
        }
    }

    public static int pascal(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        } else {
            return pascal(i - 1, j - 1) + pascal(i - 1, j);
        }
    }
}
