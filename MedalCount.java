
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
     * Can use array literals (initializer list) to create 2D arrays by nesting
     *      curly brackets.
     */
    
    private int[][] counts = new int[][]
    {               
        {1, 0, 1},          // inner array (each element represents a row)
        {1, 1, 0},
        {0, 1, 0},
        {1, 1, 0},
        {0, 1, 1},
        {0, 0, 0},
        {1, 1, 1}
    };              // outer array (list of rows)
    
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
        // loop through all rows
        for(int row = 0; row < this.counts.length; row++)
        {
            // loop through each column for each row
            for(int col = 0; col < this.counts[row].length; col++)
            {
                System.out.print(this.counts[row][col] + "\t");
            }
            System.out.println();
        }
    }
    
    /** 
     * Sum the medals for the specified country index (i.e., the specified row).
     * 
     * @param countryIndex the index of the country in the table whose medals to sum
     * @return the sum of medals for the specified country index 
     */
    public int sumMedalsForCountry(int countryIndex)
    {
        int sum = 0;
        
        for(int col = 0; col < this.counts[countryIndex].length; col++)
        {
            sum += this.counts[countryIndex][col];
        }
        
        return sum;
    }
    
     /**
     * Sum the medals for the specified medal index (i.e., the specified column) for all
     *      countries.
     *      
     *  @param medalIndex the index of the medal type in the table to sum for all countries
     *  @return the sum of medals for the specified medal index for all countries
     */
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
