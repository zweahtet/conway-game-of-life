
public class ConwayCell extends AbstractCell {

    public ConwayCell(int r, int c, ConwayWorld w) {
        super(r, c, w);
    }	

    /**
     * The Conway's Game of Life rule 
     * if the number of neighbor counts 3, return true.  
     * @return true if number of neighbor counts 3. 
     */
    public boolean willBeAliveInNextGeneration() {
        int nc = neighborCount();
        
        if (getIsAlive()) {
            return nc == 2 || nc == 3;
        } 
        else{ 
            return nc == 3;
        }
    }

    public AbstractCell cellForNextGeneration() {
        ConwayCell next = new ConwayCell(getRow(), getColumn(), world);

        if(!(isZCellAround()))
        {
            next.setIsAlive(willBeAliveInNextGeneration());
        }
        else if(isZCellAround())
        {
            next.setZCell(true);
        }
        
        return next;
    }

    public int neighborCount() {
        int count = 0;

        int row = getRow();
        int column = getColumn();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (world.isAlive(row + dr, column + dc) && !(dr == 0 && dc == 0)) {
                    count++;
                }
            }
        }

        return count;
    }
    
    public boolean isZCellAround(){
        int row = getRow();
        int column = getColumn();
        int count = 0;
        boolean status = false;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (world.isAlive(row, column) && world.isZCell(row + dr, column + dc) && !(dr == 0 && dc == 0))
                {
                    count ++;
                }
            }
        }
        
        if(count > 0){
            status = true;
        }
        
        return status;
    }
    
    /**
     * I copied Conway's neighborCount method to check the alive cells around 
     * the z-cells. When there is one or there are many alive cells, it or they will
     * transform into z-cells.
     */
    
}