package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ranson {

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        boolean result = CheckRansomNote.canConstruct(ransomNote, magazine);
        System.out.println(result);
    }
}
class CheckRansomNote {
	
    public static boolean canConstruct(String ransomNote, String magazine) {

        List<Character> ls2 = new ArrayList<>();

        for(int i=0;i<magazine.length();i++) {
            ls2.add(magazine.charAt(i));
        }

        for(int i=0;i<ransomNote.length();i++) {
            if(ls2.contains(ransomNote.charAt(i))) {
              int index = ls2.indexOf(ransomNote.charAt(i));
              ls2.remove(index);
            }else {
                return false;
            }
        }
        return true;
    }
}