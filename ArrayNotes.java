import java.util.GregorianCalendar;

/**
 * Write a description of class Notes here.
 * 
 * @author mrcallaghan
 * @version 26nov2024
 */
public class ArrayNotes
{
    public static void createArrayOfEvens()
    {
        /*
         * An array is an ordered collection of elements of the same type. The type
         *      can be a primitive type (e.g., int) or a class (e.g., Turtle or String).
         *      
         * An array variable is like an object variable in that it must be declared and
         *      initialized.
         *      
         * The number in the square brackets (i.e., []) specifies the number of elements
         *      in the array. The number of elements in the array cannot be changed.
         *      
         * All elements in the array are initialized to their default values
         *      (e.g., 0, false, null).  In this case, all 0.
         *      
         * This code creates an array that contains 10 int elements.
         */
        int[] evens = new int[10];
        
        /*
         * Set the value of each element in the array to the first 10 positive even
         *      integers.
         *      
         *  "length" is used to query the number of elements in the array
         *  
         *   Square brackets are used to reference a specific element in the array
         *      based on its index. Indicies are zero based.
         */
        for(int i = 0; i < evens.length; i++)
        {
            evens[i] = (i + 1) * 2;
        }
        
        // print the reference to the array
        System.out.println(evens);
        
        for(int i = 0; i < evens.length; i++)
        {
            System.out.println(i + ": " + evens[i]);
        }
    }
    
    public static void createArrayOfOdds()
    {
        /*
         * An array literal (a.k.a., initializer list) is a pair of curly brackets containing
         *      comma-separated values. It can be used to initialize the array. The length
         *      of the array is inferred based on the number of elements in the literal.
         */
        int[] odds = new int[] {1,3,5,7,9,11,13,15,17,19};
        
        // for array literals, the 'new' syntax is optional
        boolean[] checks = {true, false, true, true};
        
        /*
         * ArrayIndexOutOfBoundsException
         * 
         *  Arrays have a fixed length once initialized. The index specified must refer
         *      to a valid index. Otherwise, an ArrayIndexOutOfBoundsException is
         *      generated.
         */
        for(int i = 0; i <= odds.length; i++)
        {
            //System.out.println(i + ": " + odds[i]);
        }
        
        /*
         * Array References
         * 
         * Variables of type array, contain a reference to the array stored in the
         *      computer's memory.
         *      
         * Assigning one array variable's value to another, copies the reference, not
         *      the array's elements.
         * 
         */
        int[] moreOdds = odds;
        odds[2] = 6;
        moreOdds[3] = 8;
        System.out.println("The new value in moreOdds: " + moreOdds[2]);
        System.out.println("The new value in odds: " +odds[3]);
        
        /*
         * Enhanced For Loops
         * 
         * Iterates over each element in the array.
         * Similar to the "for value in ..." structure in Python.
         * The value of the loop variable is the value of each element in the array;
         *      not the index.
         * 
         * 
         */
        for (int odd : odds )
        {
            System.out.println(odd);
        }
        
        /*
         * Limitations of Enhanced for Loops
         * 
         * The local variable (e.g., odd) contains a copy of the value of the element
         *      in the array.
         *      
         *  We cannot change the value of the elements in the array.
         *  We cannot easily determine the index of an element.
         */
        for (int odd : odds)
        {
            odd += 1;
            System.out.println(odd);
        }
        
        System.out.println("The original array has not changed: ");
        for (int odd : odds )
        {
            System.out.println(odd);
        }
    }
        
    
    
    
    
    
    
    
    
}
