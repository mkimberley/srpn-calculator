/**
* References available in 'README.md'
*/

public class NumericOperations {

/**
* Class for numeric operations used in the SRPN calculator.
*
* This class contains methods for performing various numeric operations, such
* as addition, subtraction, multiplication, division and exponents.
*
*/

    private int currentIndex = 0; // Where we are in the random numbers array

    /**
     * Array of "random numbers" - Reference 3.
     * I initially tried to implement a LRG using Reference 4, however I could not
     * replicate the legacy libc rand() calls which the SRPN program appears to use. As the source SRPN
     * seems to only produce the same 22 numbers, this seemed more appropriate given time contraint of the assessment.
    */

    int[] randomNumnumbers = {
            1804289383,
            846930886,
            1681692777,
            1714636915,
            1957747793,
            424238335,
            719885386,
            1649760492,
            596516649,
            1189641421,
            1025202362,
            1350490027,
            783368690,
            1102520059,
            2044897763,
            1967513926,
            1365180540,
            1540383426,
            304089172,
            1303455736,
            35005211,
            521595368
    };
    
    // Mimic legacy srand(1) and rand() by iterating through the array
    public int rand() {      
        int number = randomNumnumbers[currentIndex];
        currentIndex++;
        if (currentIndex >= randomNumnumbers.length) {
            currentIndex = 0; // Loop around to the start of the array, mimicking the source SRPN
        }
        return number;
    }

    public int add(int a, int b) {

        // Used to ensure appropriate saturation is followed
        long sum = (long) a + (long) b;
        if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) sum;
        }
    }

    public int subtract(int a, int b) {

        // Used to ensure appropriate saturation is followed
        long diff = (long) a - (long) b;
        if (diff < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) diff;
        }
    }

    public int multiply(int a, int b) {

        // Used to ensure appropriate saturation is followed
        try {
            return Math.multiplyExact(a, b);
        } catch (ArithmeticException e) {
            return (a > 0 && b > 0) || (a < 0 && b < 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE; // Ternary operator to check if the result is positive or negative, and return the apprropriate integer value

        }

    }

    public int divide(int a, int b) {
        // Catch division by zero and throw an exception, handled in the SRPN class
        if (b == 0 || a == 0) {
            throw new ArithmeticException("Divide by 0.");
        }
        return a / b;
    }

    public int power(int a, int b) {

        // Used to ensure appropriate saturation is followed
        double result = Math.pow(a, b);
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

}
