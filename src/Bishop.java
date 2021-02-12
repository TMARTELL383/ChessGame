import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(boolean color){
        super(color);
        if(isWhite){
            image = new ImageIcon("wbishop.gif");
        }
        else{
            image = new ImageIcon("bbishop.gif");
        }
    }


    @Override
    //can only move diagonally any number of spaces, cannot jump over pieces
    public boolean canMove(int startx, int starty, int endx, int endy) {
        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);

        //xdist = ydist
        //top-right diagonal (x+ y-)
        if(endx > startx && endy < starty){
            for(int i=1; i < xdist; i++){
                if(startx + i <= 7 && starty - i >= 0 && Chess.position[startx + i][starty - i] != null){
                    return false;
                }
            }
        }

        //top-left diagonal (x- y-)
        if(endx < startx && endy < starty){
            for(int i=1; i < xdist; i++){
                if(startx - i >= 0 && starty - i >= 0 && Chess.position[startx - i][starty - i] != null){
                    return false;
                }
            }
        }

        //bottom-right diagonal (x+ y+)
        if(endx > startx && endy > starty){
            for(int i=1; i < xdist; i++){
                if(startx + i <= 7 && starty + i <= 7 && Chess.position[startx + i][starty + i] != null){
                    return false;
                }
            }
        }

        //bottom-left diagonal (x- y+)
        if(endx < startx && endy > starty){
            for(int i=1; i < xdist; i++){
                if(startx - i >= 0 && starty + i <= 7 && Chess.position[startx - i][starty + i] != null){
                    return false;
                }
            }
        }


        if(xdist == ydist){
            return true;
        }

        return false;

    }

    public boolean checkMate(int startx, int starty, int endx, int endy, boolean whiteTurn){
        return false;
    }


}
