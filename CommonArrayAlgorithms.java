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
        int[] array = createRandomArray(10, 101);
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(" | " + array[i]);
            }
        }
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
        int[] array = createRandomArray(100, 100);
        int returnvalue = -1;
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(valueToFind == array[i]){
                index = i;
                returnvalue = i;
            }
            System.out.println(array[i]);
        }
        System.out.println("index: " + index);
        return returnvalue;
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
        int maxValue = 10;

        int[] array = createRandomArray(10, maxValue);

        for (int num : array)
        {
            if (num < limit)
            {
                count ++;
            }
        }

        System.out.println("Limit: " + limit);
        printArray(array);
        System.out.println("Count: " + count);

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
        int [] x = createRandomArray(10, 50);
        int maxNum  = Integer.MIN_VALUE;

        for (int i = 0; i < x.length; i++)
        {
            if (x[i] > maxNum)
            {
                maxNum = x[i];
            }
        }
        printArray(x);
        System.out.println(maxNum);
        return maxNum; 
    }

    /*
     * Array Algorithm #4.5: findMin
     *  creates an array filled with random numbers
     *  prints the array and the least number
     * @return returns the least number in the array
     */
    public static int findMin() 
    {
        int[] values = createRandomArray(10, 100);

        printArray(values);

        int leastNumber = Integer.MAX_VALUE;

        for (int number : values)
        {
            if (number < leastNumber)
            {
                leastNumber = number;
            }
        }

        System.out.println(leastNumber);

        return leastNumber;
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
        int[] array = createRandomArray (10, 50);
        int [] array2 = new int [array.length];
        for (int i=0; i < array.length ;i++)
        {
            array2[i] = array[array.length-i-1];
        }

        printArray(array);
        printArray(array2);
        return array2;
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

        int[] x = createRandomArray(10,10);
        int[] countArr = new int[10];

        int maxAmt = 0;
        int mode = 0;
        for(int val: x) {

            countArr[val]+=1;
            if(countArr[val] > maxAmt) {

                maxAmt = countArr[val];
                mode = val;
            }
        }


        System.out.println("-");
        printArray(x);
        printArray(countArr);
        System.out.println("Mode:" + mode);
        System.out.println(maxAmt);

        return mode;
    }

}