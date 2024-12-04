/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package XO;

public class Coordinate {
	
	//variables row and cols
	public int row;
    public int col;

    //constructor that initialize and rows and columns 
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    //toString method to provide a meaningful string representation
    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
