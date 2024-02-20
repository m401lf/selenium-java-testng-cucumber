package testCases.Demos.DemoPractice.StringBuffer;

import org.testng.annotations.Test;

import java.util.Arrays;


public class ReverseAString {

    @Test
    public void reverseString() {
        String speech = "I love selenium Java";
        String speech1 = "avaJ muineles evol I";
        StringBuffer sb = new StringBuffer(speech);
        System.out.println(sb.reverse());
        System.out.println(sb.reverse());
    }

    @Test()
    public void reverseName() {
        String speech = "Benjamin";
        StringBuffer sb = new StringBuffer(speech);
        String message = sb.reverse().toString();
        System.out.println(message);
    }

    @Test
    public void generateNumbers() {
        for(int i = 1; i<11; i++){
            System.out.println(i);
        }
    }

    @Test
    public void ReverseNumbers() {
        int [] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(nums));
        }
    }



