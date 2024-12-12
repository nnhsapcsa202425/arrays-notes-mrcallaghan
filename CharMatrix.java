// Implements a 2-D array of characters

public class CharMatrix
{
    // Fields:
    private char[][] grid;

    // Constructor: creates a grid with dimensions rows, cols,
    // and fills it with spaces
    public CharMatrix(int rows, int cols)
    {
        // call other constructor using 'this'
        this(rows, cols, ' ');
    }

    // Constructor: creates a grid with dimensions rows , cols ,
    // and fills it with the fill  character
    public CharMatrix(int rows, int cols, char fill)
    {
        this.grid = new char[rows][cols];

        for(int row = 0; row < rows; row++)
            for(int col = 0; col < cols; col++)
                this.grid[row][col] = fill;
    }

    // Returns the number of rows in grid
    public int numRows()
    {
        return grid.length;
    }

    // Returns the number of columns in grid
    public int numCols()
    {
        return grid[0].length;
    }

    // Returns the character at row, col location
    public char charAt(int row, int col)
    {
        return grid[row][col];
    }

    // Sets the character at row, col location to ch
    public void setCharAt(int row, int col, char ch)
    {
        grid[row][col] = ch;
    }

    // Returns true if the character at row, col is a space,
    // false otherwise
    public boolean isEmpty(int row, int col)
    {
        return (grid[row][col] == ' ');
    }

    // Fills the given rectangle with fill  characters.
    // row0, col0 is the upper left corner and row1, col1 is the
    // lower right corner of the rectangle.
    public void fillRect(int row0, int col0, int row1, int col1, char fill)
    {
        for(int row = row0; row <= row1; row++)
            for(int col = col0; col <= col1; col++)
                grid[row][col] = fill;

    }

    // Fills the given rectangle with SPACE characters.
    // row0, col0 is the upper left corner and row1, col1 is the
    // lower right corner of the rectangle.
    public void clearRect(int row0, int col0, int row1, int col1)
    {
        this.fillRect(row0, col0, row1, col1, ' ');
    }

    // Returns the count of all non-space characters in row 
    public int countInRow(int row)
    {
        int count = 0;

        for(int col = 0; col < grid[row].length; col++)
            if(grid[row][col] != ' ')
                count++;

        return count;
    }

    // Returns the count of all non-space characters in col 
    public int countInCol(int col)
    {
        int count = 0;

        for(int row = 0; row < grid.length; row++)
            if(grid[row][col] != ' ')
                count++;

        return count;
    }
}
