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

    public void swapFirstAndLast()
    {
        int lastIndex = this.values.length - 1;
        int temp = this.values[0];

        this.values[0] = this.values[lastIndex];
        this.values[lastIndex] = temp;
    }

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