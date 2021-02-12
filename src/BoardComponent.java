import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardComponent extends JComponent implements MouseListener {

    private int startx, starty, endx, endy;

    public void paintComponent(Graphics g){
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                if(x % 2 == y % 2){
                    g.setColor(new Color(233,174,95));
                }
                else {
                    g.setColor(new Color(177,113,24));
                }
                g.fillRect(x * Chess.SQUARE_SIZE,y * Chess.SQUARE_SIZE,Chess.SQUARE_SIZE, Chess.SQUARE_SIZE);
                if(Chess.position[x][y] != null){
                    Chess.position[x][y].drawPiece(g,x,y);
                }
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
        startx = e.getX() / Chess.SQUARE_SIZE;
        starty = e.getY() / Chess.SQUARE_SIZE;


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endx = e.getX() / Chess.SQUARE_SIZE;
        endy = e.getY() / Chess.SQUARE_SIZE;

        if(startx > 7 || startx < 0 || starty > 7 || starty < 0){
            return;
        }

        if(endx > 7 || endx < 0 || endy > 7 || endy < 0){
            return;
        }
        //can't move a black piece
        if(!Chess.position[startx][starty].isWhite){
            return;
        }
        //can't move a piece that isn't there
        if(Chess.position[startx][starty] == null){
            return;
        }
        //don't move and capture your own piece
        if(Chess.position[endx][endy] != null && Chess.position[endx][endy].isWhite){
            return;
        }
        if(!Chess.position[startx][starty].canMove(startx, starty, endx, endy)){
            return;
        }
        if(Chess.position[endx][endy] != null && !Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing){
            Chess.position[endx][endy] = Chess.position[startx][starty];
            Chess.position[startx][starty] = null;
            repaint();
            JOptionPane.showMessageDialog(null, "White has captured Black. White wins!");
            System.exit(0);
        }
        Chess.position[endx][endy] = Chess.position[startx][starty];
        Chess.position[startx][starty] = null;
        repaint();

        //Checkmate
        //Use the piece that the player just moved and see if it results in a checkmate
        //If it does, display a message to the screen
        //Might have to implement something in the canMove function, or make a separate checkmate function to check

        if(Chess.position[endx][endy].checkMate(startx,starty,endx,endy,true)){
            JOptionPane.showMessageDialog(null, "White checkmates Black!");
        }


        //computer's turn
        while(true){
            startx = (int)(Math.random()*8);
            starty = (int)(Math.random()*8);
            endx = (int)(Math.random()*8);
            endy = (int)(Math.random()*8);

            if(Chess.position[startx][starty] == null){
                continue;
            }
            if(Chess.position[startx][starty].isWhite){
                continue;
            }
            if(Chess.position[endx][endy] != null && !Chess.position[endx][endy].isWhite){
                continue;
            }
            if(!Chess.position[startx][starty].canMove(startx, starty, endx, endy)){
                continue;
            }
            if(Chess.position[endx][endy] != null && Chess.position[endx][endy].isWhite && Chess.position[endx][endy].isKing) {
                Chess.position[endx][endy] = Chess.position[startx][starty];
                Chess.position[startx][starty] = null;
                repaint();
                JOptionPane.showMessageDialog(null, "Black has captured White. Black wins!");
                System.exit(0);
            }
            Chess.position[endx][endy] = Chess.position[startx][starty];
            Chess.position[startx][starty] = null;
            repaint();

            if(Chess.position[endx][endy].checkMate(startx,starty,endx,endy,false)){
                JOptionPane.showMessageDialog(null, "Black checkmates White!");
            }

            break;
        }

    }




    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}
