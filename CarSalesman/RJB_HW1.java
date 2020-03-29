
/**
 * Write a description of class RJB_HW1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RJB_HW1
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RJB_HW1
     */
    public RJB_HW1()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * calcualtes the number of divisors
     *
     * @param  y  a sample parameter for a method
     * @return    number of divisors
     */
    public int numDiv(int n)
    {
        // put your code here
        int div = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                div++;
            }
        }
        return div;
    }
    
    /**
     * calculates the sum of squares up to n
     */
    public int sumSquares (int n)
    {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += (i * i);
        }
        return sum;
    }
    
    public static void main (String [] args) {
        int count = 0;
        int totalDiv = 0;
        int avgDiv = 0;
        RJB_HW1 obj = new RJB_HW1();
        for (int num = 10; num <= 50; num++) {
            int x = obj.sumSquares(num);
            int y = obj.numDiv(num);
            totalDiv += y;
            count ++;
            System.out.println("Num= " + num + " sumSquares= " + x +
                " numDiv= " + y);
        }
        avgDiv = totalDiv / count;
        System.out.println("Avg Div= " + avgDiv);
    }
}
