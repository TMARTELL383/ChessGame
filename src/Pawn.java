import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pawn extends Piece {

    public boolean firstTurn = true;

    public Pawn(boolean color){
        super(color);
        if(isWhite){
            image = new ImageIcon("wpawn.gif");
        }
        else{
            image = new ImageIcon("bpawn.gif");
        }
    }





    @Override
    public boolean canMove(int startx, int starty, int endx, int endy) {
        int xdist = endx - startx;
        int ydist = endy - starty;

        if(Chess.position[startx][starty].isWhite){       //move forward - ydist should always be negative

            if(firstTurn) {
                //move two spaces up - make sure you don't jump over pieces if moving two spaces up
                if(starty - 2 >= 0 && endy == starty - 2 && xdist == 0 && Chess.position[startx][starty - 1] == null && Chess.position[startx][starty - 2] == null){
                    firstTurn = false;
                    return true;
                }
            }


            //white moving forward one space vertically
            if(ydist == -1 && xdist == 0 && Chess.position[endx][endy] == null){ //make sure it's not moving backwards
                return true;
            }
            //top-right diagonal capture
            else if(startx + 1 <= 7 && starty - 1 >= 0 && Chess.position[startx + 1][starty - 1] != null){
                return true;
            }
            //top-left diagonal capture
            else if(startx - 1 >= 0 && starty - 1 >= 0 && Chess.position[startx - 1][starty - 1] != null){
                return true;
            }
        }
        else {

            if(firstTurn) {
                //move two spaces up - make sure you don't jump over pieces if moving two spaces up
                if(starty + 2 <= 7 && endy == starty + 2 && xdist == 0 && Chess.position[startx][starty + 1] == null && Chess.position[startx][starty + 2] == null) {
                    firstTurn = false;
                    return true;
                }
            }


            if(ydist == 1 && xdist == 0 && Chess.position[endx][endy] == null){ //make sure it's not moving backwards
                return true;
            }
            //bottom-right diagonal capture
            else if(startx + 1 <= 7 && endx == startx + 1 && starty + 1 <= 7 && endy == starty + 1 && Chess.position[startx + 1][starty + 1] != null) {
                return true;
            }
            //bottom-left diagonal capture
            else if(startx - 1 >= 0 && endx == startx - 1 && starty + 1 <= 7 && endy == starty + 1 && Chess.position[startx - 1][starty + 1] != null) {
                return true;
            }
        }

        firstTurn = false;

        return false;

    }

    public boolean checkMate(int startx, int starty, int endx, int endy, boolean whiteTurn){
        return false;
    }


}

