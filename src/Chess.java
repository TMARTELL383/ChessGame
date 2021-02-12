import javax.swing.*;

/*
    TODO_LIST
    TODO: Implement checkmate
 */

public class Chess {
    static final int SQUARE_SIZE = 44;
    static final int WINDOW_WIDTH = SQUARE_SIZE*8 + 15;
    static final int WINDOW_HEIGHT = SQUARE_SIZE*8 + 35;
    public static Piece[][] position = new Piece[8][8];

    public static void main(String[] args){

        position[0][0] = new Rook(false);
        position[1][0] = new Knight(false);
        position[2][0] = new Bishop(false);
        position[3][0] = new Queen(false);
        position[4][0] = new King(false);
        position[5][0] = new Bishop(false);
        position[6][0] = new Knight(false);
        position[7][0] = new Rook(false);
        for(int i=0; i<8; i++){
            position[i][1] = new Pawn(false);
            position[i][6] = new Pawn(true);
        }
        position[0][7] = new Rook(true);
        position[1][7] = new Knight(true);
        position[2][7] = new Bishop(true);
        position[3][7] = new Queen(true);
        position[4][7] = new King(true);
        position[5][7] = new Bishop(true);
        position[6][7] = new Knight(true);
        position[7][7] = new Rook(true);



        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Chess");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        BoardComponent board = new BoardComponent();
        board.addMouseListener(board);
        window.add(board);
        window.setVisible(true);
    }
}
