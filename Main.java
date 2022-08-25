import java.util.*;

public class Main{

    public static void main(String[] args){
        System.out.println("GG");
        int f[] = new int[2];
        f[0] = 0;
        f[1] = 4;
        System.out.println(flatlandSpaceStations(5, f));
    }

    string dayOfProgrammer(int year) {

    }
    
    
    static int flatlandSpaceStations(int n, int[] c) {
        Integer gmin = 0;
        for (int i = 0; i < n; i++) {
            Integer lmin = n;
            for (int j = 0; j < c.length; j++) {
                if(Math.abs(i - c[j])<lmin){
                    lmin = Math.abs(i - c[j]);
                }
            }
            if(gmin<lmin){
                gmin = lmin;
            }
        }
        return gmin;
    }

    public static int migratoryBirdsOk(List<Integer> arr) {
        int counter[] = new int[6];
        int result = 1; int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            counter[arr.get(i)]++;
        }

        for (int i = 1; i <= 5; i++) {
            if (counter[i] > max) {
                result = i;
                max = counter[i];
            }
        }

        return result;
    }
    
    public static int migratoryBirdsNOK2(List<Integer> arr) {
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        Integer c = -1;
        Integer minId = arr.get(0);
        for (Integer num : arr) {
            if(map.get(num) == null){
                map.put(num, 0);
            }
            map.put(num, map.get(num)+1);
            if(map.get(num)>c || map.get(num) == c && num < minId){
                minId = num;
                c = map.get(num);
            }
        }
        return minId;
    }

    public static int migratoryBirdsNOK(List<Integer> arr) {
            HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
            Integer c = 0;
            Integer minId=null;
            for (Integer num : arr) {
                if(map.get(num) == null){
                    map.put(num, 0);
                }
                map.put(num, map.get(num)+1);
                if (map.get(num) > c){
                    c = map.get(num);
                }
            }
    
            for (Integer num : map.keySet()) {
                if(map.get(num)==c){
                    if (minId == null){
                        minId = num;
                    }
                    else if(num < minId){
                        minId = num;
                    }
                }
            }
            return minId;
    }

    static int solveMeFirst(int a, int b) {
        return a + b;
    }

    public static int countingValleys(int steps, String path) {
        steps = 0;
        Integer f=0;
        for (int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == 'U'){
                f++;
                if(f==0){
                    steps++;
                }
            }else{
                f--;
            }

        }
        return steps;
    }

    public static int birthday(List<Integer> s, int d, int m) {
        Integer flag = 0;
        Integer sum = 0;
        Integer counter = 0;
        Integer p = 0;
        Integer mn = m;
        while(mn <= s.size()){
            for(Integer i = flag; i<mn; i++){
                sum += s.get(i);
                counter++;
            }
            if(sum == d && counter == m){
                p ++;
            }
            sum = 0;
            counter = 0;
            flag++;
            mn++;
        }
        return p;
    }

    public static String misereNim(List<Integer> s) {
        if(s.size()  == 1){
            return s.get(0) > 1 ? "First" : "Second";
        }
        Integer sum = 0;
        Integer xorCount=0;
        for (Integer num : s) {
            xorCount = xorCount ^ num;
            sum += num;
        }
        if(sum == s.size()) {
            return sum % 2 == 0 ? "First" : "Second";
        }
        return xorCount > 0 ? "First" : "Second";
    }

    public static int lonelyinteger(List<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : a) {
            if(map.get(num)!=null) map.put(num, map.get(num)+1);
            if(map.get(num)==null) map.put(num, 1);
        }
        for (Integer num : map.keySet()) {
            if(map.get(num) == 1) return num;
        }
        return 0;
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // CURRENT CODE IS O(N2) HOWEVER THIS CAN BE SOLVED AS O(N) --- TODO
        Integer counter=0;
        for(Integer i = 0; i<ar.size(); i++){
            for(Integer j = 1; j<ar.size(); j++){
                if(i < j && (ar.get(i) + ar.get(j))% k==0){
                    counter++;
                }
            }
        }

        return counter;
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        Integer[] records = new Integer[2];
        records[0] = 0;
        records[1] = 0;
        int max = scores.get(0);
        int min = scores.get(0);
        for(Integer i=1;i<scores.size(); i++){
            if(scores.get(i) > max){
                max = scores.get(i);
                records[0]+=1;
            }
            if(scores.get(i) < min){
                min = scores.get(i);
                records[1]+=1;

            }
        }
        return Arrays.asList(records);
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