/**
 * It is like a zombie-virus cell.
 * ZCells - this Z-cell changes alive cells around it into z-cells.
 * Even dead cells will become alive if they are near the z-cell and alive cells.
 * When the whole grid is full with Z-cells, the population will die in following 
 * generation because of the over-population and lack of alive-cells. 
 * A z-cell will be positioned at a place, not moving.
 */

/**
 *
 * @author zhtet
 */
public class ZCell extends AbstractCell
{
    public ZCell(int r, int c, ConwayWorld w)
    {
        super(r, c, w);
    }
    
    public  AbstractCell cellForNextGeneration() {
        ZCell next = new ZCell(getRow(), getColumn(), world);

        next.setZCell(willBeAliveInNextGeneration());
            
        return next;
    }

    public boolean willBeAliveInNextGeneration() {
        return true;
    }
    
    public boolean isAliveCellAround(){
        int row = getRow();
        int column = getColumn();
        int count = 0;
        boolean status = false;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (world.isAlive(row + dr, column + dc) && !(dr == 0 && dc == 0)) {
                    count ++;
                }
            }
        }

        if(count > 0){
            status = true;
        }

        return status;
    }
    
    public boolean getIsZCell(){
        return true;
    }
}
