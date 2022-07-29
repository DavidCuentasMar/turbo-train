import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args){
        System.out.println("GG");
    }

    public static String timeConversion(String s) {
        String[] str = s.split(":");
        if (s.contains("AM")){
            str[0] = (Integer.parseInt(str[0]) == 12) ? "00" : str[0];
        }else{
            str[0] = (Integer.parseInt(str[0]) != 12) ? ""+(Integer.parseInt(str[0]) + 12) : "12";
        }
        str[0] = str[0].length() == 2 ? str[0] : "0"+str[0];
        return str[0] +":"+str[1]+":"+str[2].substring(0,str[2].length()-2);    
    }

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        k = k % a.size();
        Integer[] nums = new Integer[a.size()];
        Integer[] nums2 = new Integer[a.size()];
        List<Integer> finalNums = new ArrayList<Integer>();
        a.toArray(nums);
        Integer counter = 0;
        for(Integer i = Math.abs(a.size()-k); i<a.size(); i++){
            nums2[counter]=nums[i];
            counter++;
        }

        for(Integer i = 0; i< Math.abs(a.size()-k); i++){
            nums2[counter]=nums[i];
            counter++;
        }

        for (Integer q : queries) {
            finalNums.add(nums2[q]);
        }

        return  finalNums;
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