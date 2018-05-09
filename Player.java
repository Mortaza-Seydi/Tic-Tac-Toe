/**
 *  In The Name of ALLAH
 *
 *  Written by: Mortaza Seydi - Zanjan University - Winter 2018
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private String sharp;

    private boolean turn = true;

    private ArrayList<int []> allEntries = new ArrayList<>();

    public Player (String name, String sharp)
    {
        this.name = name;
        this.sharp = sharp;
    }

    public String getName ()
    {
        return name;
    }

    public String getSharp ()
    {
        return sharp;
    }

    public boolean isTurn ()
    {
        return turn;
    }

    public void setTurn (boolean turn)
    {
        this.turn = turn;
    }

    public boolean isWon ()
    {
        int n = allEntries.size();

        int x1  = 0;
        int x2  = 0;
        int x3  = 0;

        int y1  = 0;
        int y2  = 0;
        int y3  = 0;

        int m1 = 0;
        int m2 = 0;

        if (n >= 3)
        {
            for (int i=0; i<n; i++)
            {
                if (allEntries.get(i)[0] == 0 && allEntries.get(i)[1] == 0)
                {
                    m1++;
                    x1++;
                    y1++;
                }

                else if (allEntries.get(i)[0] == 0 && allEntries.get(i)[1] == 1)
                {
                    x1++;
                    y2++;
                }

                else if (allEntries.get(i)[0] == 0 && allEntries.get(i)[1] == 2)
                {
                    x1++;
                    y3++;
                    m2++;
                }

                else if (allEntries.get(i)[0] == 1 && allEntries.get(i)[1] == 0)
                {
                    x2++;
                    y1++;
                }

                else if (allEntries.get(i)[0] == 1 && allEntries.get(i)[1] == 1)
                {
                    x2++;
                    y2++;
                    m1++;
                    m2++;
                }

                else if (allEntries.get(i)[0] == 1 && allEntries.get(i)[1] == 2)
                {
                    x2++;
                    y3++;
                }

                else if (allEntries.get(i)[0] == 2 && allEntries.get(i)[1] == 0)
                {
                    m2++;
                    x3++;
                    y1++;
                }

                else if (allEntries.get(i)[0] == 2 && allEntries.get(i)[1] == 1)
                {
                    x3++;
                    y2++;
                }

                else if (allEntries.get(i)[0] == 2 && allEntries.get(i)[1] == 2)
                {
                    x3++;
                    y3++;
                    m1++;
                }
            }

            if (x1 == 3 || x2 == 3 || x3 == 3 || y1 == 3 || y2 == 3 || y3== 3 || m1 == 3 || m2 == 3)
                return true;

            else
                return false;
        }

        else
            return false;
    }

    public void setToAllEntries (int x, int y)
    {
        int[] entry = new int[2];
        entry[0] = x;
        entry[1] = y;
        allEntries.add(entry);
    }

    public int[] getEntry () // Get Entries Form User
    {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();

        String[] b = a.split(",");

        int[] entry = new int[2];
        entry[0] = Integer.parseInt(b[0]) - 1;
        entry[1] = Integer.parseInt(b[1]) - 1;

        return entry;
    }

}
