import java.util.Arrays;

public class ArrayMethods
{
    private int[] values;

    public ArrayMethods(int[] initialValues)
    {
        this.values = initialValues;
    }

    public String toString()
    {
        String str = "[";
        for(int i = 0; i < values.length; i++)
        {
            str += values[i];
            if(i < values.length - 1)
            {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }
    
    /*
     * 1. Swap the first and last elements in the array.
     */
    public void swapFirstAndLast()
    {
        int lastIndex = this.values.length - 1;
        int temp = this.values[0];

        this.values[0] = this.values[lastIndex];
        this.values[lastIndex] = temp;
    }
    
    /*
     * 2. Shift all elements by one to the right and move the last element into
     *      the first position. For example, 1 4 9 16 25 would be transformed into
     *      25 1 4 9 16.
     */
    public void shiftRight()
    {
        int temp = this.values[this.values.length - 1];

        for( int i = this.values.length - 1; i > 0; i-- )
        {
            this.values[i] = this.values[i - 1];
        }

        this.values[0] = temp;
    }

    // TODO: implement additional methods

    public static void main( String[] args )
    {
        int[] testValues = new int[]{ 3, 5, 6, 1 /* add your own values */ };
        ArrayMethods tester = new ArrayMethods( testValues );
        System.out.println("Swap First and Last");
        System.out.println(tester.toString());
        tester.swapFirstAndLast();
        System.out.println(tester.toString());

        testValues = new int[]{ 1, 6, 3, 9, 5, 6 /* add your own values */ };
        tester = new ArrayMethods(testValues);
        System.out.println("Shift Right");
        System.out.println(tester.toString());
        tester.shiftRight();
        System.out.println(tester.toString());

        // test additional methods
    }
}