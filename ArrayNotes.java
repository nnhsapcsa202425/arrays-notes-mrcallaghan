import java.util.GregorianCalendar;

/**
 * Write a description of class Notes here.
 * 
 * @author mcallaghan
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
         *  All elements in the array are initialized to their default values
         *      (e.g., 0, false, null).
         *      
         *      This code creates an array that contains 10 int elements, all of which are 0.
         */
        int[] evens = new int[10];
        
        /*
         * Set the value of each element in the array to the first 10 positive even
         *      integers.
         *      
         *     "length" is used to query the number of elements in the array
         *     
         *     Square brackets are used to reference a specific element in the array
         *      based on its index. Indicies are zero based.
         */
        for(int i = 0; i < evens.length; i++)
        {
            evens[i] = (i + 1) * 2;
        }
        
        // print the reference to the array
        System.out.println(evens);
        
        for(int i = 0; i <evens.length; i++)
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
        int[] odds = new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        
        boolean[] checks = {true, false, true};
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
