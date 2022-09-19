class Solution {
    static public int maxLengthBetweenEqualCharacters(String s) {
        Map<String, List<Integer>> map = new LinkedHashMap<String, List<Integer>>();
        for (int i =0; i< s.length(); i++){
            map.put(s.charAt(i),11);
            System.out.println("map:", map);
        }
    }
}

public class Test{
    public static void main(String[] args){
        string s = "abcdefgaefb";
        Solution.maxLengthBetweenEqualCharacters(s);
    }
}
