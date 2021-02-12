import javax.swing.*;
import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

abstract public class Piece {
    boolean isWhite;
    boolean isKing = false;
    ImageIcon image;
    public Piece(boolean color){
        if(color) {
            isWhite = color;
        }
        else {
            isWhite = false;
        }
    }

    public void drawPiece(Graphics g, int x, int y){
        g.drawImage(image.getImage(), x * Chess.SQUARE_SIZE, y * Chess.SQUARE_SIZE, null);
    }

    public abstract boolean canMove(int startx, int starty, int endx, int endy);

    public abstract boolean checkMate(int startx, int starty, int endx, int endy, boolean whiteTurn);

}
