
/**
 * Write a description of class drrays here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class drrays
{
    // instance variables - replace the example below with your own
    private int x;
    
    

    /**
     * Constructor for objects of class drrays
     */
    public drrays()
    {
        int board[][] = new int[3001][3001];
        for(int x = 0; x<3000; x++){
            for(int y = 0; y<3000; y++){
            board[x][y] = ( x+1)*( y+1);
            System.out.print(board [x] [y] + " ");
        }
        System.out.println();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
}
