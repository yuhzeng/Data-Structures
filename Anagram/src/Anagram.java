import static org.junit.Assert.*;
import java.util.Arrays;

public class Anagram {
    public static boolean anagram(String s1, String s2) {
        //Remove all spaces in s1 and s2.
        String noSpaceS1 = s1.replaceAll("\\s","");
        String noSpaceS2 = s2.replaceAll("\\s", "");

        //If length of noSpaceS1 and noSpaceS2 are not equal, they must not be anagrams.
        if (noSpaceS1.length() !=noSpaceS2.length()) {
            return false;
        } else {
            //Change all characters in noSpaceS1 and noSpaceS2 to lowercase.
            //And convert strings to array in order to be sorted.
            char[] array1 = noSpaceS1.toLowerCase().toCharArray();
            char[] array2 = noSpaceS2.toLowerCase().toCharArray();

            //Sort array1 and array2.
            Arrays.sort(array1);
            Arrays.sort(array2);

            //Test if array1 and array2 are equal.
            if (array1.equals(array2)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "mary";
        String s2 = "army";
        Assert.assertEquals(anagram(s1, s2), true);

        String s3 = "doctor who";
        String s4 = "torchwood";
        Assert.assertEquals(anagram(s3, s4), true);

        String s5 = "Shakespeare";
        String s6 = "Keshareapes";
        Assert.assertEquals(anagram(s5, s6), true);
    }
}
