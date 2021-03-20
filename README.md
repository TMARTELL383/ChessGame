# ChessGame

This project is a chess game made in Java using object oriented programming concepts with Java Swing as the main GUI toolkit. There are nine classes altogether: Chess,
BoardComponent, Bishop, King, Queen, Knight, Pawn, Rook, and Piece (an abstract class for all the main chess pieces to follow).

Chess:

main - main function of the java program. Here is where the initial object pieces of a game are created on the board and the JFrame is set up.



BoardComponent:

paintComponent - a necessary method for drawing the underlying board and importing the gif files for each piece to place them on the board.

mousePressed - since this boardComponent extends the JComponent class, this method along with the other four methods listed below are necessary. All the action happens in mouseReleased, but here, when the user presses their mouse down, the x and y positions are stored with the values being between 0 and 7, the values that represent the positions on the 8x8 chess board

mouseReleased - this method gets us the position of the user's mouse when released, similar to mousePressed. A variety of conditions are checked, such as:
  1) Are the mousePressed and mouseReleased (start and end) positions outside the bounds of 0 and 7 (the board)? If so, don't make the move.
  2) Is the piece the user is trying to move a white piece? They cannot move their own piece, so don't make the move.
  3) Is the user trying to move a piece that isn't there (a null place on the board)? If so, don't make the move.
  4) Call a canMove function that checks if the piece the user is trying to move can actually be moved. If it is an invalid move, don't make the move. For example,
     if the user tries to move a pawn forward 4 spaces, that is an invalid move, so this check will stop them from doing that.
  5) Is the piece the user is capturing the opponent's king (black)? If so, capture it, display a message that white has won, and exit the game.

If the user gets through all these checks, then their white piece will move, replace a captured black piece on the board if necessary, and our BoardComponent will repaint. Then, it is the computer's turn. This computer "A.I." randomly chooses starting and ending positions with numbers from 0 to 7. It goes through all the checks again and determines if it can make that move. All of this is wrapped in a while loop that will forever run until the computer eventually makes a valid move. If the computer happens to choose a move that captures a white piece, that white piece will be replaced with the incoming black piece and the while loop will break.

mouseClicked, mouseEntered, mouseExited - nothing in these functions, but necessary to have if we're having our class extend JComponent.



Piece & its subclasses:

The constructor of the Piece class initializes two important variables: isWhite and isKing. isWhite is determined from a boolean passed in when the piece is originally created (in the Chess class). isKing will be false for all pieces except for, of course, objects of the King class. It is used to check whether a piece being captured in BoardComponent is a king or not.

drawPiece is a function written only in the Piece class, but it is shared with all its subclasses. There is no need to specifically modify it for the other classes,
so it is left the same. This simply grabs the gif image for the specific piece and draws it in an x,y position on the board. The canMove method varies with each piece,
as well as the checkMate function, however, the checkMate function is not yet complete and needs some work.

Pawn canMove - This is probably the hardest function to write because pawns have so many unique situations for moving on the board. If there only purpose is to move 
forward to an empty space, they can only move straight, not diagonally. However, if there intention with a move is to capture a piece, they can only do so diagonally 
and never moving straight forward. For their very first move of the game, they can move forward one OR two spaces, so that must be accounted for as well.

FIRST MOVE / MOVING FORWARD == I made a class specific instance variable named firstTurn which was set to true initially for every piece. When the canMove method for
a pawn is called, the program will check to see if this boolean is true or false. If it is true and the pawn's end position is two y spaces away from its start position
(depending on the piece of course - if the piece is white, we're moving up in the -y direction, but if it is black, we're moving down in the +y direction), then it will
return that as a valid move. One space moving forward (if that is chosen over the two spaces) will be a valid move as well.

MOVING FOWARD W/O FIRST TURN == If the firstTurn variable happens to be false, then program will check to see if the pawn can move one space forward. It is important
to make sure that if the pawn wants to move forward one space, that space must be null and not contain either the player's own piece or the opponent's piece.

CAPTURING == If the pawn wants to move diagonally, then the program must check if there is an opponent's piece at the position they want to move to. A left-diagonal
move checker must be made and a right diagonal move checker must be made.

These methods are applied to both white AND black pieces in separate cases.



Knight canMove - The knight moves in an L-shape, so in order to move either it has to move two spaces in the x direction and one space in the y direction OR it has to
move one space in the x direction and two spaces in the y direction. A very simple canMove method - much easier than pawn's.

Rook canMove - Rooks can move in the x and y plane, but never both at the same time. It can also move any number of spaces it wants provided that there are no other
pieces in its path when moving. To create this canMove method, we need to first create four for loops to check if there are any pieces in the rook's path when it wants
to move (depending on WHERE it wants to move of course). If it turns out that there is a piece in the way, this method will return a false and the move cannot be made.
If there is no return false, it will check either two things: 1) Are we moving in the x-direction and NOT the y-direction?, or 2) Are we moving in the y-direction and
NOT the x-direction. If either of these conditions are true, then the move can be made and this method will return true.

Bishop canMove - Bishop is very similar to Rook's canMove except we are moving diagonally instead of straight. The for loops will alter slightly, but are still
necessary. To check if the bishop is attempting to make a valid move, the distance moved in the x-direction must be equal to the distance moved in the y-direction.
If one is greater than the other, we are not truly moving diagonally, so it is an invalid move.

Queen canMove - Queen's canMove is literally a copy combination of Rook's canMove and Bishop's canMove. Queens can move like rooks and bishops, so a copy paste is all
that's necessary.

King canMove - A simple method - a king can move in any direction one space. So, we just have to check whether the number of spaces moved in the x AND y direction is
less than or equal to one.


More methods might come up later when I start adding more stuff, but this is it for now.










