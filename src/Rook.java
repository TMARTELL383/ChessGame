import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(boolean color){
        super(color);
        if(isWhite){
            image = new ImageIcon("wrook.gif");
        }
        else{
            image = new ImageIcon("brook.gif");
        }
    }


    @Override
    //can only move horizontally or vertically any number of spaces, but cannot jump over pieces
    public boolean canMove(int startx, int starty, int endx, int endy) {
        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);

        if(xdist != 0 && ydist != 0){
            return false;
        }


        //horizontally right
        if(endx > startx){
            for(int i=1; i<xdist; i++){
                if(startx + i <= 7 && Chess.position[startx + i][starty] != null){
                    return false;
                }
            }
        }

        //horizontally left
        if(endx < startx){
            for(int i=1; i<xdist; i++){
                if(startx - i >= 0 && Chess.position[startx - i][starty] != null){
                    return false;
                }
            }
        }

        //vertically down
        if(endy > starty){
            for(int i=1; i<ydist; i++){
                if(starty + i <= 7 && Chess.position[startx][starty + i] != null){
                    return false;
                }
            }
        }

        //vertically up
        if(endy < starty){
            for(int i=1; i<ydist; i++){
                if(starty - i >= 0 && Chess.position[startx][starty - i] != null){
                    return false;
                }
            }
        }



        if(xdist == 0 || ydist == 0){
            return true;
        }

        return false;

    }

    public boolean checkMate(int startx, int starty, int endx, int endy, boolean whiteTurn){
        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);

        if(xdist != 0 && ydist != 0){
            return false;
        }


        //horizontally right
        if(endx > startx){
            for(int i=1; i<xdist; i++){
                if(startx + i <= 7 && Chess.position[startx + i][starty] != null){
                    return false;
                }
            }
        }

        //horizontally left
        if(endx < startx){
            for(int i=1; i<xdist; i++){
                if(startx - i >= 0 && Chess.position[startx - i][starty] != null){
                    return false;
                }
            }
        }

        //vertically down
        if(endy > starty){
            for(int i=1; i<ydist; i++){
                if(starty + i <= 7 && Chess.position[startx][starty + i] != null){
                    return false;
                }
            }
        }

        //vertically up
        if(endy < starty){
            for(int i=1; i<ydist; i++){
                if(starty - i >= 0 && Chess.position[startx][starty - i] != null){
                    return false;
                }
            }
        }



/*        if(xdist == 0 || ydist == 0){
            return true;
        }
*/
        return true;
    }

}
