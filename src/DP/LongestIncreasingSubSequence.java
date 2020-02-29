package DP;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {

        int[] seq = {5, 7, 4, -3, 9, 1, 10, 4, 5, 8, 9, 3};
        int longestSeq = findSequence(seq);
        System.out.printf("The Longest Sequence is : %d%n", longestSeq);
    }

    private static int findSequence(int[] seq) {

        int[] aux = new int[seq.length]; // Auxilary array to keep track of max length for each element
        int max = 1; // Global variable to keep track of max length

        /**
        1. For the first element, max length is 1 ,and we will save this in the auxiliary array
         2. The idea to traverse each element of the input array and check if this element is bigger than previous elements
            if yes, then use it's auxilary value and add 1
         3. Keep track of maximum lenghth in a global variable
         **/

        for (int i = 0; i < seq.length; i++) {

            aux[i] = 1;

            for (int j = 0; j <= i - 1; j++) {
                if (seq[j] < seq[i] && aux[i] < aux[j] + 1)
                    aux[i] = aux[j] + 1;
            }
            if (aux[i] > max)
                max = aux[i];

        }

        return max;
    }
}
