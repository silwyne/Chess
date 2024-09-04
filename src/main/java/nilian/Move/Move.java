package nilian.Move;

public class Move
{
    public Coordinate dstCord;
    public MoveName moveName;

    public Move(Coordinate dstCord, MoveName moveName)
    {
        this.dstCord = dstCord;
        this.moveName = moveName;
    }
}
