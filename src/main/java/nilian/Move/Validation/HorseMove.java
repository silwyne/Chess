package nilian.Move.Validation;

import nilian.Move.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class HorseMove
{

    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static List<Coordinate> calculateOnBoardMoves(Coordinate source)
    {
        List<Coordinate> result = new ArrayList<>();
        int i = source.i;
        int j = source.j;
        Coordinate destination ;
        //FIRST : up moves
        //right up : 2 up 1 right
        if( i - 2 >= 0 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i - 2, j + 1);
            result.add(destination);
        }
        //left up : 2 up 1 left
        if( i - 2 >= 0 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i - 2, j - 1);
            result.add(destination);
        }
        //right down : 2 down 1 right
        if( i + 2 < 8 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i + 2, j + 1);
            result.add(destination);
        }
        //left down : 2 down 1 left
        if( i + 2 < 8 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i + 2, j - 1);
            result.add(destination);
        }
        //right UPPER : 1 up 2 right
        if( i - 1 >= 0 && j + 2 < 8)//move is in board
        {
            destination = new Coordinate(i - 1, j + 2);
            result.add(destination);
        }
        //right DOWNER : 1 down 2 right
        if( i + 1 < 8 && j + 2 < 8)//move is in board
        {
            destination = new Coordinate(i + 1, j + 2);
            result.add(destination);

        }
        //left UPPER : 1 up 2 left
        if( i - 1 >= 0 && j - 2 >= 0)//move is in board
        {
            destination = new Coordinate(i - 1, j - 2);
            result.add(destination);
        }
        //left DOWNER : 1 down 2 left
        if( i + 1 < 8 && j - 2 >= 0)//move is in board
        {
            destination = new Coordinate(i + 1, j - 2);
            result.add(destination);
        }
        return result;
    }
}
