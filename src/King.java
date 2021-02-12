import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class King extends Piece {
    public King(boolean color){
        super(color);
        if(isWhite){
            image = new ImageIcon("wking.gif");
        }
        else{
            image = new ImageIcon("bking.gif");
        }
        isKing = true;
    }



    @Override
    //Can only move 1 space at a time in any direction
    public boolean canMove(int startx, int starty, int endx, int endy) {
        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);

        if(xdist <= 1 && ydist <= 1){
            return true;
        }

        return false;

    }

    //this doesn't make any sense because startx, starty that are passed in are from the previous move
    //TODO: need to change checkMate function - design flawed
    public boolean checkMate(int startx, int starty, int endx, int endy, boolean whiteTurn){
        //checkmate
        /*
            -a replica of the canMove function except we'll be looking for a King
            -we need to check if the piece we're going to "move on" is a king or not
            -but we don't actually make the move, we just check
            -if it is a king, then we return true and we have checkmate
            -put all the moves in an arraylist? then loop through each move and see if one of those is a checkmate?
         */

        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);
        if(whiteTurn){
            if(xdist <= 1 && ydist <= 1 && Chess.position[endx][endy] != null && !Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing){
                return true;
            }
        }
        else{
            if(xdist <= 1 && ydist <= 1 && Chess.position[endx][endy] != null && Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing){
                return true;
            }
        }

        return false;
    }






}
