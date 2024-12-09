
/**
 * Write a description of class MedalCount here.
 *
 * @author mrcallaghan
 * @version 09dec2024
 */
public class MedalCount
{
    private final int COUNTRIES = 7;
    private final int MEDALS = 3;
    
    /*
     * Can use array literal to create a 2D array by nesting curly brackets.
     */
    private int[][] counts = new int[][]
    {                   // outer array
        { 1, 0, 1},     // 7 inner arrays inside the outer array
        { 1, 1, 0},
        { 0, 1, 0},
        { 0, 1, 1},
        { 1, 1, 0},
        { 0, 1, 0},
        { 0, 1, 1}        
        
    };
    
    public MedalCount()
    {
        /*
         * Alternate way to create a 2D array. The initialization would be followed
         *      by nested loops to initialize each element.
         */
        //this.counts = new int[COUNTRIES][MEDALS];
        //for ...
            //for ...
    }
    
    public void printTable()
    {
        // access each row
        for(int row = 0; row < this.counts.length; row++)
        {
            // access each col
            for (int col = 0; col < this.counts[row].length; col++)
            {
                // 2 square brackets to index into the 2D array
                System.out.print(this.counts[row][col] + "\t");
            }
            System.out.println();
        }
    }
    
    // enhanced for loops still work!!
    public void printTable2()
    {
        // access each row
        for(int[] country : this.counts)
        {
            // access each col
            for (int medal : country)
            {
                System.out.print(medal + "\t");
            }
            System.out.println();
        }
    }
    
    public int sumMedalsForCountry(int countryIndex)
    {
        int sum = 0;
        
        for(int col = 0; col < this.counts[countryIndex].length; col++)
        {
            sum += this.counts[countryIndex][col];
        }
        
        return sum;
    } 
    
    public int sumMedalsForType(int medalIndex)
    {
        int sum = 0;
        
        for(int row = 0; row < this.counts.length; row++)
        {
            sum += this.counts[row][medalIndex];
        }
        
        return sum;
    }
    
    
    
    
    
    
    
    
    
    
}
