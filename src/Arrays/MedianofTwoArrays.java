package Arrays;

public class MedianofTwoArrays {

    public static void main(String[] args) {
        int[] aa = new int[]{1, 3, 5};
        int[] bb = new int[]{2, 4, 6};
        int[] cc = new int[aa.length + bb.length];
        // 1 2 3 4 5 6
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < aa.length && j < bb.length) {
            if (aa[i] < bb[j]) {
                cc[k] = aa[i];
                i++;
                k++;
            } else {
                cc[k] = bb[j];
                j++;
                k++;
            }
        }
        if (i < aa.length) {
            while (i < aa.length) {
                cc[k] = aa[i];
                i++;
                k++;
            }
        } else {

            while (j < bb.length) {
                cc[k] = aa[j];
                j++;
                k++;
            }
        }

        int size=cc.length;
        int half=size/2;
        if (size%2==0) {
            float f= (float) (cc[half- 1] + cc[half]) / 2;
            System.out.println(f);

        }
        else System.out.println(cc[size/2]);
    }
}

