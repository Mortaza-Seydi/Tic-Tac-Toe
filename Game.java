/**
 *  In The Name of ALLAH
 *
 *  Written by: Mortaza Seydi - Zanjan University - Winter 2018
 *
 */

public class Game
{
    private String[][] board;
    private int numberOfEmpties;
    private int columns, lines;

    public Game(int x, int y) // Constructor
    {
        if (x == y && x >= 3 && y >= 3)
        {
            columns = x;
            lines   = y;

            board = new String[columns][lines];

            for (int i = 0; i < columns; i++)
                for (int j = 0; j < lines; j++)
                    board[i][j] = " ";

            numberOfEmpties = columns * lines;
        }

        else
        {
            System.out.println("\nThis Game Can Not Be Played :(\n");
            System.exit(0);
        }

    }

    public void turn (Player p1, Player p2) // Specify Turns
    {
        if (p1.isTurn())
        {
            System.out.printf("GO %s (%s), It's Your Turn\n", p1.getName(), p1.getSharp());
            int[] a = p1.getEntry();
            boolean status = checkTruth(p1, a[0], a[1]);
            if (status)
                p2.setTurn(true);
        }

        else
        {
            System.out.printf("GO %s (%s), It's Your Turn\n", p2.getName(), p2.getSharp());
            int[] a = p2.getEntry();
            boolean status = checkTruth(p2, a[0], a[1]);
            if (status)
                p1.setTurn(true);

        }

    }

    public void draw () // Draw Game Board
    {
        for (int i=0; i<lines; i++)
        {
            for (int j = 0; j < columns; j++)
                System.out.printf("[ %s ]  ", board[i][j]);

            System.out.println("\n");
        }
    }

    public boolean isGameDone (Player p1, Player p2) // Check The Status Of The Game
    {
        if (p1.isWon())
        {
            System.out.printf("\nWinner is %s :)\n", p1.getName());
            return true;
        }

        if (p2.isWon())
        {
            System.out.printf("\nWinner is %s :)\n", p2.getName());
            return true;
        }

        if (numberOfEmpties == 0)
        {
            System.out.println("\nThe Game Has No Winner :(\n");
            return true;
        }

        else
            return false;
    }

    public boolean checkTruth (Player player, int x, int y) // Check The Truth Of Entries
    {
        if (x > (columns-1) || y > (lines-1) || x < 0 || y < 0)
        {
            System.out.println("False Input, Try Again");
            return false;
        }

        else if (!board[x][y].equals(" "))
        {
            System.out.println("That's Not Empty, Try Again");
            return false;
        }

        else
        {
            System.out.println("OK!");
            board[x][y] = player.getSharp();
            player.setTurn(false);
            player.setToAllEntries(x, y);
            numberOfEmpties--;
            return true;
        }
    }

}