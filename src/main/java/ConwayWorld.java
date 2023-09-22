
public class ConwayWorld {
	
    static final int ROWS = 20;
    static final int COLS = 20;

    private AbstractCell[][] grid = new AbstractCell[ROWS][COLS]; 

    public ConwayWorld() 
    {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                 grid[r][c] = new ConwayCell(r, c, this);
            }
        }
    }

    // Display the grid
    public void display() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(" " + grid[r][c].displayCharacter());		
            }

            System.out.println();
        }
    }

    // Replace a single cell
    public void replaceCell(AbstractCell cell) {
        grid[cell.getRow()][cell.getColumn()] = cell;
    }

    // Create the next generation
    public void advanceToNextGeneration() {
        AbstractCell[][] nextGrid = new AbstractCell[ROWS][COLS]; 

        // Build the grid for the next generation
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                nextGrid[r][c] = grid[r][c].cellForNextGeneration();
            }
        }

        // Out with the old, in with the new
        grid = nextGrid;
    }

    // Returns true if (r, c) is a valid coordinate, and the cell is alive
    public boolean isAlive(int r, int c) {
        return r >= 0 && c >= 0 && r < ROWS && c < COLS && grid[r][c].getIsAlive();
    }

    // Returns true if (r, c) is a valid coordinate, and the cell is z-cell.
    public boolean isZCell(int r, int c)
    {
        return r >= 0 && c >= 0 && r < ROWS && c < COLS && grid[r][c].getIsZCell();
    }
}