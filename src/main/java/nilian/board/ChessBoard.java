package nilian.board;

import nilian.Move.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard
{
    /*
    Holds all the squares of the board.
     */
    private final List<List<ChessSquare>> allPieces = new ArrayList<>();

    /*
    Who is turn is it now ? white or black?
    Initial value is WHITE at the beginning of the game.
     */
    private Color turnColor = Color.WHITE;
    /**
     * Adds a new square to the board. used when making the board
     * @param square the square you want add
     */
    public void addSquare(ChessSquare square)
    {
        if(allPieces.size() <= square.getJ())
        {
            List<ChessSquare> temp = new ArrayList<>();
            allPieces.add(temp);
        }
        allPieces.get(square.getI()).add(square.getJ(), square);
    }

    /**
     * returns any square at the specified coordinates
     * @param cord coordination of the square you seek
     * @return square
     */
    public ChessSquare getSquare(Coordinate cord)
    {
        System.out.println("get square: "+cord.toString());
        return allPieces.get(cord.i).get(cord.j);
    }

    /**
     * replaces the new square with the old one on the coordinate
     * @param cord coordinate of the old square
     * @param square the new square
     */
    public void setSquare(Coordinate cord, ChessSquare square)
    {
        //making it empty first
        allPieces.get(cord.i).set(cord.j, null);
        //putting new value
        allPieces.get(cord.i).set(cord.j, square);
    }

    /**
     * returns white or black.
     * @return white if it is white turn to move. and black if it's black turn to move
     */
    public Color whoTurnIsIt()
    {
        return turnColor;
    }

    /*
    Updates the turn after one did his move.
     */
    public void nextTurn()
    {
        if(turnColor == Color.BLACK)
        {
            turnColor = Color.WHITE;
        } else {
            turnColor = Color.BLACK;
        }
    }
}
