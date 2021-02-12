import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(boolean color){
        super(color);
        if(isWhite){
            image = new ImageIcon("wqueen.gif");
        }
        else{
            image = new ImageIcon("bqueen.gif");
        }
    }


    @Override
    //can move any direction for any number of spaces, but cannot jump over pieces
    public boolean canMove(int startx, int starty, int endx, int endy) {
        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);

        //horizontally right
        if(endx > startx && ydist == 0){ //need ydist == 0, because if not, then both for loops will run, causing errors
            for(int i=1; i<xdist; i++){
                if(startx + i <= 7 && Chess.position[startx + i][starty] != null){
                    return false;
                }
            }
        }

        //horizontally left
        if(endx < startx && ydist == 0){
            for(int i=1; i<xdist; i++){
                if(startx - i >= 0 && Chess.position[startx - i][starty] != null){
                    return false;
                }
            }
        }

        //vertically down
        if(endy > starty && xdist == 0){
            for(int i=1; i<ydist; i++){
                if(starty + i <= 7 && Chess.position[startx][starty + i] != null){
                    return false;
                }
            }
        }

        //vertically up
        if(endy < starty && xdist == 0){
            for(int i=1; i<ydist; i++){
                if(starty - i >= 0 && Chess.position[startx][starty - i] != null){
                    return false;
                }
            }
        }

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
        if(endx < startx && endy < starty) {
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

        //moving diagonally
        if(xdist == ydist){
            return true;
        }

        //moving horizontally or vertically
        if(xdist == 0 || ydist == 0){
            return true;
        }

        return false;
    }

    public boolean checkMate(int startx, int starty, int endx, int endy, boolean whiteTurn){
        return false;
    }


}
