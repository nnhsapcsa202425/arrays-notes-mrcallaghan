public class CommonArrayAlgorithms
{
    /*
     * Create array of the specified size filled with
     *      random values based on the maximum value.
     */
    public static int[] createRandomArray( int length, int maxValue )
    {
        int[] randomArray = new int[ length ];
        for( int i = 0; i < randomArray.length; i++ )
        {
            randomArray[ i ] = (int)( Math.random() * maxValue );
        }

        return randomArray;
    }

    /*
     * Prints the specified array to System.out
     */
    public static void printArray( int[] array )
    {
        System.out.print("[");

        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            if(i < array.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    /*
     * Array Algorithm #0: Sum and Average
     *  creates an array filled with random numbers
     *  calculates the sum and average of the numbers
     *  prints the array and the sum and average
     *  @returns the average
     */
    public static double sumAndAverage()
    {
        double sum = 0;
        double average = 0;

        int[] array = createRandomArray( 10, 50 );

        for( int element : array)
        {
            sum += element;
        }

        average = sum / array.length;

        printArray( array );
        System.out.println( "sum: " + sum + " average: " + average );

        return average;
    }

    /*
     * Array Algorithm #1: Print Element Separators
     *  creates an array filled with random numbers
     *  prints each element of the array with a '|' between each element
     *      but not at the beginning or end of the array
     */
    public static void printElementSeparators()
    {
        int[] a = createRandomArray(5,10);
        System.out.print("[");

        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i]);
            if(i < a.length - 1)
            {
                System.out.print("|");
            }
        }

        System.out.println("]");
    }

    /*
     * Array Algorithm #2: Linear Search
     *  creates an array filled with random numbers
     *  find the index of the first element with the specified value
     *  prints the array and the index (or -1 if not found)
     *    @returns the index of the first element with the specified value (or -1 if not found)
     */
    public static int linearSearch( int valueToFind )
    {
        boolean foundvalue = false;
        int[] array = createRandomArray(10, 50);
        if (valueToFind < 50)
        {
            for (int i = 0; i < array.length; i++)
            {
                if (array[i] == valueToFind)
                {
                    printArray(array);
                    foundvalue = true;
                    System.out.println(i);
                    return i;
                }
            }
            if (foundvalue == false)
            {
                printArray(array);
                System.out.println("-1");
            }
        }
        return -1;
    }

    /*
     * Array Algorithm #3: Count Less Than
     *  creates an array filled with random numbers
     *  counts the number of elements that are less than the specified value
     *  prints the array and the count
     *  @return returns the number of elements that are less than the specified value
     */
    public static int countLessThan( int limit )
    {
        int[] values = createRandomArray(6, 35);
        printArray(values);
        int count = 0;
        for (int element : values)
        {
            if (element < limit)
            {
                count++;
            }
        }
        System.out.println("Number of element that are less than the specified value: " + count);

        return count;
    }

    /*
     * Array Algorithm #4: findMax
     *  creates an array filled with random numbers
     *  prints the array and the greatest number
     * @return returns the greatest number in the array
     */
    public static int findMax() 
    {
        int[] array = createRandomArray( 10, 50 );
        int gNum = 0;
    
        for(int i = 0; i < array.length; i++)
        {
          if(array[i] > gNum)
          {
              gNum = array[i];
          }
        }
        printArray( array );
        System.out.println("Greatest number in this array is: " + gNum);
        return gNum;
    }

    /*
     * Array Algorithm #5: Reverse Array
     *  creates an array filled with random numbers
     *  creates a new array of the same size
     *  copies elements from the first array into the new array in reverse order
     *  prints the original array and the new array
     *  returns the new array
     */
    public static int[] reverseArray()
    {
        int[] array = createRandomArray(10, 50);
        int[] reverse = new int[array.length];

        for (int i = 1; i <= array.length; i++)
        {
            reverse[i-1] = array[array.length - i];
        }

        System.out.println("Old Array: ");
        for (int element : array)
        {
            System.out.println(element);
        }

        System.out.println("Reverse Array: ");
        for (int element : reverse)
        {
            System.out.println(element);
        }

        return reverse;
    }

    /*
     * Array Algorithm #6: Mode
     *  creates an array filled with random numbers
     *  calculates the mode (most frequent value in the array)
     *  prints the array and the mode
     *  @returns the mode of the elements in the array
     */
    public static int mode()
    {
        /* hint: when creating the random array, specify parameters that will
         *        likely result in a value being repeated multiple times;
         *        create another array to keep track of how many times each value
         *        occurs (index is the number and the value is the number of occurrences)
         */

        return 0;
    }

}