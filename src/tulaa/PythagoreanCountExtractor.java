package tulaa;

public class PythagoreanCountExtractor {

    public void getCombinations(int arr[], int data[], int startIndex,
                                int endIndex, int currIndex, int combinationSize) {
        if (currIndex == combinationSize) {
            int calculated_c_squared = 0;
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < combinationSize - 1; j++) {
                buffer.append(data[j] + " ");
                calculated_c_squared += data[j] * data[j];
            }

            if (calculated_c_squared == (data[combinationSize - 1] * data[combinationSize - 1]))
                System.out.println(buffer.append(data[combinationSize - 1]));
            return;
        }

        for (int i = startIndex; i <= endIndex && endIndex - i + 1 >= combinationSize - currIndex; i++) {
            data[currIndex] = arr[i];
            getCombinations(arr, data, i + 1, endIndex, currIndex+1, combinationSize);
        }
    }

    public void printCombinations(int arr[], int combinationGroupSize) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int currIndex = 0;
        int data[] = new int[combinationGroupSize];
        getCombinations(arr, data, startIndex, endIndex, currIndex, combinationGroupSize);
    }

    public static void main (String[] args) {
        int arr[] = { 3, 1, 4, 6, 5 };
        int combinationGroupSize = 3;
        PythagoreanCountExtractor extractor = new PythagoreanCountExtractor();
        System.out.print("Pythogorean triplets: ");
        extractor.printCombinations(arr, combinationGroupSize);

        arr = new int[] { 10, 4, 6, 12, 5 };
        System.out.print("Pythogorean triplets: ");
        extractor.printCombinations(arr, combinationGroupSize);
    }
}
