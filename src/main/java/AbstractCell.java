
public abstract class AbstractCell{
	
    private boolean isAlive;
    private boolean isZCell;
    private int row;
    private int column;

    protected ConwayWorld world;    

    public AbstractCell(int r, int c, ConwayWorld w) {
        row = r;
        column = c;
        world = w;
        isAlive = false;
        isZCell = false;
    }

    public char displayCharacter() {
        char character = ' ';
        
        if(isAlive){
            character = 'O';
        } else if(isZCell){
            character = 'Z';
        } else{
            character = '.';
        }

        return character;
    }

    public void setIsAlive(boolean value) {
        isAlive = value;
    }

    public boolean getIsAlive() {
        return isAlive;
    }
     
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    public void setZCell(boolean value){
        isZCell = value;
    }
    
    public boolean getIsZCell(){
        return isZCell;
    }


    public abstract AbstractCell cellForNextGeneration();
    public abstract boolean willBeAliveInNextGeneration();   
}