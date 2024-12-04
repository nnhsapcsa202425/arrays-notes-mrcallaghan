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

        // total all elements in array
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
        int[] array = createRandomArray(10, 50);
        for(int i = 0; i<array.length-1; i++){
            System.out.print(array[i] + "|");
        }
        System.out.println(array[array.length - 1]);
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
        int[] nums = createRandomArray(10, 10);
        int index = -1;
        for (int i = 0; i < nums.length;i++)
        {
            if (nums[i] == valueToFind)
            {
                index = i;
                break;
            }
        }
        printArray(nums);
        System.out.println("The index of " + valueToFind + " is: " + index);
        return index;
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
        int count = 0;

        int[] numbers = createRandomArray(5, limit * 2);

        for(int number : numbers) {
            if ( number < limit) {
                count++;
            }
        }

        printArray(numbers);
        System.out.println(count);

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
        int[] random = createRandomArray(15, 50);
        int current = random[0];
        for (int i = 1; i < random.length; i++)
        {
            if (random[i] > current)
            {
                current = random[i];
            }
        }
        printArray( random );
        System.out.println("The biggest number in the array is : " + current);
        return current;
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
        int[] x = createRandomArray(10, 10);
        int[] y = new int[x.length];
        for (int i = 0; i < x.length; i++)
        {
            y[i] = x[x.length - 1 - i];
        }
        printArray(x);
        printArray(y);

        return y;
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

        int maxVal = 3;
        int numVal = 10;
        int[] modeArray = createRandomArray(numVal,maxVal); // length,max
        int[] numOccur = new int[maxVal];
        for (int value : modeArray){
            numOccur[value]++;
        }
        int indexOfHigh = 0;
        int highCount = 0;
        //printArray(numOccur);
        for (int i = 0; i < numOccur.length; i++){
            if (numOccur[i] > highCount){
                highCount = numOccur[i];
                indexOfHigh = i;
            }
        }
        printArray(modeArray);
        printArray(numOccur);
        System.out.println(indexOfHigh);
        return indexOfHigh;
    }

}