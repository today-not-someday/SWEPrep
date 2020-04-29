package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroRowCoulun {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1)));

        setZeroes(A);
    }


    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {


        int m = a.size();
        int n = a.get(0).size();
        boolean[] x = new boolean[m];
        boolean[] y = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (a.get(i).get(j) == 0) {
                    x[i] = true;
                    y[j] = true;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] || y[j]) {
                        a.get(i).set(j,0);
                }
            }
        }
    }

}
