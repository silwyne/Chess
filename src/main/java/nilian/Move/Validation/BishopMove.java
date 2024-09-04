package nilian.Move.Validation;

import nilian.Move.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class BishopMove
{

    /**
     * calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     *
     * @return a list of possible coordinates
     */
    public static List<Coordinate> calculateOnBoardMoves(Coordinate source) {
        List<Coordinate> result = new ArrayList<>();
        int i = source.i;
        int j = source.i;
        Coordinate destination;

        //right up moves
        for (int ei = 1; ei < 8; ei++) {
            if (i - ei >= 0 && j + ei < 8)
            {
                destination = new Coordinate(i - ei, j + ei);
                result.add(destination);
            } else {
                break;
            }
        }
        //right down moves
        for (int ei = 1; ei < 8; ei++) {
            if (i + ei < 8 && j + ei < 8)//validation
            {
                destination = new Coordinate(i + ei, j + ei);
                result.add(destination);
            } else {
                break;
            }
        }   //left up moves
        for (int ei = 1; ei < 8; ei++) {
            if (i - ei >= 0 && j - ei >= 0)//validation
            {
                destination = new Coordinate(i - ei, j - ei);
                result.add(destination);
            } else {
                break;
            }
        }   //left down moves
        for (int ei = 1; ei < 8; ei++) {
            if (i + ei < 8 && j - ei >= 0)//validation
            {
                destination = new Coordinate(i + ei, j - ei);
                result.add(destination);
            } else {
                break;
            }
        }
        return result;
    }
}
