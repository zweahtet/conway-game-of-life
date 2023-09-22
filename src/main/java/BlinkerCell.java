
public class BlinkerCell extends AbstractCell {
	
    public BlinkerCell(int r, int c, ConwayWorld w) {
        super(r, c, w);
    }

    public  AbstractCell cellForNextGeneration() {
        BlinkerCell next = new BlinkerCell(getRow(), getColumn(), world);
        
        next.setIsAlive(willBeAliveInNextGeneration());
        
        return next;
    }

    /**
     * The blinker cell will alternate between being alive and dead with each generation.
     * @return true if the status of the cell is alive was false.
     */
    public boolean willBeAliveInNextGeneration() 
    {
        if(this.getIsAlive())
        {
            return false;
        }
        else{
            return true;
        }

    }

    public char displayCharacter() {
        return this.getIsAlive() ? 'A' : 'D';
    }
}