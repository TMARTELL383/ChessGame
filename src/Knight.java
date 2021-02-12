import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(boolean color){
        super(color);
        if(isWhite){
            image = new ImageIcon("wknight.gif");
        }
        else{
            image = new ImageIcon("bknight.gif");
        }
    }


    @Override
    //Can only move in L-shapes (2 squares horizonally or vertically, 1 square horizontally or vertically) and can jump over pieces
    public boolean canMove(int startx, int starty, int endx, int endy) {
        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);

        if(xdist == 2 && ydist == 1){
            return true;
        }
        if(xdist == 1 && ydist == 2){
            return true;
        }

        return false;

    }

    public boolean checkMate(int startx, int starty, int endx, int endy, boolean whiteTurn){
        int xdist = Math.abs(endx - startx);
        int ydist = Math.abs(endy - starty);

        if(whiteTurn){
            if(xdist == 2 && ydist == 1 && Chess.position[endx][endy] != null && !Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing){
                return true;
            }
            if(xdist == 1 && ydist == 2 && Chess.position[endx][endy] != null && !Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing){
                return true;
            }
        }
        else{
            if(xdist == 2 && ydist == 1 && Chess.position[endx][endy] != null && Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing){
                return true;
            }
            if(xdist == 1 && ydist == 2 && Chess.position[endx][endy] != null && Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing){
                return true;
            }
        }



        return false;
    }


}
