/**
 *  In The Name of ALLAH
 *
 *  Written by: Mortaza Seydi - Zanjan University - Winter 2018
 *
 */

public class Tester
{
    public static void main (String[] args)
    {

        /*
         * Create One Game Object
         */
        Game game = new Game(3,3);

        /*
         * Create 2 Players
         */
        Player p1 = new Player("Jack", "X");
        Player p2 = new Player("Mick", "O");


        game.draw(); // Draw Game Board

        while (!game.isGameDone(p1, p2)) // Check The Status Of The Game
        {
            game.turn(p1, p2); // Specify Turns
            game.draw();       // Draw Game Board
        }

    }
}
