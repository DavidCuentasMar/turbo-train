import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args){
        List<Integer> z =  new ArrayList<Integer>();
        z.add(1);
        z.add(2);
        z.add(3);
        List<Integer> q =  new ArrayList<Integer>();
        q.add(0);
        q.add(1);
        q.add(2);
        System.out.println(circularArrayRotation(z,16,q));
    }

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        Integer[] nums = new Integer[a.size()];
        List<Integer> z =  new ArrayList<Integer>();
        a.toArray(nums);
        Integer limit = k % a.size() == 0 ? k : k % a.size();
        System.out.println(limit);
        for(Integer i=0; i<limit;i++){
            Integer aux = nums[0];
            for(Integer j=1; j <= a.size()-1;j++){
                Integer aux2 = nums[j];
                nums[j] = aux;
                aux = aux2;
            }
            nums[0] = aux;
        }
        for (Integer f : queries) {
            z.add(nums[f]);
        }
        return z;
    }
    
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> newGrades = new ArrayList<Integer>();
        for (Integer gradNum : grades) {
            if(gradNum >= 38){
                gradNum +=  gradNum % 5 >= 3 ? (5 - gradNum % 5) : 0;
            }
            newGrades.add(gradNum);
        }
        return newGrades;
    }
    
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        return v2 < v1 && (x2 - x1) % (v1 - v2) == 0 ? "YES" : "NO";

    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        Integer applesCounter = 0;    
        Integer orangesCounter = 0;

        for (Integer pos : apples) {
            if(pos + a >= s && pos + a <= t){
                applesCounter+=1;
            }
        }

        for (Integer pos : oranges) {
            if(pos + b >= s && pos + b <= t){
                orangesCounter+=1;
            }
        }
        System.out.println(applesCounter);
        System.out.println(orangesCounter);
    }

    public static String catAndMouse(int x, int y, int z) { 
        if(Math.abs(z-x)<Math.abs(z-y)){
            return "Cat A";
        }
        if(Math.abs(z-y)<Math.abs(z-x)){
            return "Cat B";
        }
        return "Mouse C";
    }
}