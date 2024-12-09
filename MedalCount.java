
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
     * You can use array literals for 2D arrays by nesting curly brackets
     */
    private int[][] counts = new int[][]
        {                       // outer array
            { 1, 0, 1},         // first inner array
            { 3, 1, 1}, 
            { 1, 0, 1},         // third inner array
            { 0, 1, 2},
            { 1, 0, 1},         // fifth inner array
            { 3, 4, 1},
            { 1, 1, 1}         // last inner array        
        };
    
    public MedalCount()
    {
        /*
         * Alternate way to intialize a 2D array.
         */
        // this.count = new int[COUNTRIES][MEDALS];
        // for ...
            // for ...
    }
    
    public void printTable()
    {
        // access each row
        for(int row = 0; row < this.counts.length; row++)
        {
            // access each col
            for(int col = 0; col < this.counts[row].length; col++)
            {
                System.out.print(this.counts[row][col] + "\t");
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
    
    public int sumMedalsForType(int medalsIndex)
    {
        int sum = 0;
        
        for(int row = 0; row < this.counts.length; row++)
        {
            sum += this.counts[row][medalsIndex];
        }
        
        return sum;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}