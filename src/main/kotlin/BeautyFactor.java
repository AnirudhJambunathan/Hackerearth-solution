import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Pair1 {
    int first;
    int second;
    public Pair1(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class BeautyFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int b = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        HashMap<Integer, Pair1> digitLimitMapping = new HashMap<>();
        digitLimitMapping.put(1, new Pair1(1, 9));
        digitLimitMapping.put(2, new Pair1(12, 98));
        digitLimitMapping.put(3, new Pair1(123, 987));
        digitLimitMapping.put(4, new Pair1(1234, 9876));
        digitLimitMapping.put(5, new Pair1(12345, 98765));
        digitLimitMapping.put(6, new Pair1(123456, 987654));
        digitLimitMapping.put(7, new Pair1(1234567, 9876543));
        digitLimitMapping.put(8, new Pair1(12345678, 98765432));
        digitLimitMapping.put(9, new Pair1(123456789, 987654321));

        Pair1 reqPair1 = digitLimitMapping.get(k);

        for(int i = reqPair1.first; i<= reqPair1.second; i++) {
            if(anyDigitRepeatingOrContainsZero(i)) {
                int rem9= i%9;
                if((rem9 == 0 && b == 9) || (rem9 == b)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    static boolean anyDigitRepeatingOrContainsZero(int num) {
        int[] digitCount = new int[10];
        while(num != 0) {
            int rem = num%10;
            if(rem == 0)
                return false;
            else if(digitCount[rem] == 0)
                digitCount[rem]++;
            else
                return false;
            num/=10;
        }
        return true;
    }
}