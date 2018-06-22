package tulaa;

public class SumCountExtractor {

    public void getCombinations(int arr[], int data[], int startIndex,
                                int endIndex, int currIndex, int combinationSize,
                                int threshhold) {
        if (currIndex == combinationSize) {
            int sum = 0;
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < combinationSize; j++) {
                buffer.append(data[j] + " ");
                sum += data[j];
            }

            if (sum < threshhold)
                System.out.println(buffer);
            return;
        }

        for (int i = startIndex; i <= endIndex && endIndex - i + 1 >= combinationSize - currIndex; i++) {
            data[currIndex] = arr[i];
            getCombinations(arr, data, i + 1, endIndex, currIndex+1, combinationSize, threshhold);
        }
    }

    public void printCombinations(int arr[], int combinationGroupSize, int threshhold) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int currIndex = 0;
        int data[] = new int[combinationGroupSize];
        getCombinations(arr, data, startIndex, endIndex, currIndex, combinationGroupSize, threshhold);
    }

    public static void main (String[] args) {
        int arr[] = { 5, 1, 3, 4, 7 };
        int combinationGroupSize = 3;
        int threshhold = 12;
        SumCountExtractor extractor = new SumCountExtractor();
        extractor.printCombinations(arr, combinationGroupSize, threshhold);

        arr = new int[]{-2, 0, 1, 3};
        threshhold = 2;
        extractor.printCombinations(arr, combinationGroupSize, threshhold);
    }
}
