package tulaa;

import java.util.ArrayList;

public class ParenthesisCombinationGenerator {

    public static void main(String[] args) {
        ParenthesisCombinationGenerator generator = new ParenthesisCombinationGenerator();
        System.out.println(generator.generate(2).toString());
    }

    private ArrayList<String> generate(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addParenthesis(list, count, count, str, 0);
        return list;
    }

    void addParenthesis(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem <leftRem)
            return;
        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParenthesis(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')';
            addParenthesis(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
