package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDuplicate {

    public static void main(String[] args){
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(1,22,1,2));
        System.out.println(repeatedNumber(list));

    }
    public static int repeatedNumber(final ArrayList<Integer> A) {
        int slow =0, fast =0;
        do{
            slow= A.get(slow);
            fast= A.get(A.get(fast));
        }while(slow!=fast);

        slow =0;

        while(slow!=fast){
            slow = A.get(slow);
            fast= A.get(fast);
        }
        return slow;
    }

}
