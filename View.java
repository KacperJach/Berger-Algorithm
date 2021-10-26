package project.lab1;

import java.util.List;
import java.util.ArrayList;
/**
 * View class prints the result from the Berger Algorithm
 * @author Kacper Jach
 */
public class View {
   /**
    * show method prints in a right order names/numbers of teams
    * @param p is a list's pair made in a Pair class that contains teams
    */
    public void show(Pair p)
    {
        for(int i=0;i<p.round_number; i++)
        {
            System.out.printf("%d Round number: ", i+1);
            if(i%2==0)
            {
                for(int j=0;j<p.half_teams; j++)
                {
                    System.out.printf("%d %s - %s \n", j+1, p.away.get(j), p.home.get(j));
                }
            }
            else
            {
                for(int j=0;j<p.half_teams; j++)
                {
                    System.out.printf("%d %s - %s \n", j+1, p.home.get(j), p.away.get(j));
                }
            }
            
            String tmp = p.home.get(0);
            
            String move = p.away.get(p.away.size()-1);
           
            p.away = shiftRight(p.away, p.home.get(1));
            
            p.home = shiftLeft(p.home, move);
            p.home.set(0 , tmp);
            
        }
    }
    /**
     * message method prints the message on the user's screen.
     * @param m is a string message transferred from the controller to this View function 
     */
    public void message(String m)
    {
        System.out.println(m);
    }
    /**
     * shiftLeft method is shifting to the left the elements of list.
     * @param data is a "home" list of teams
     * @param add is a temporary element of an "away" list, because we have to add it to a "home" list
     * @return method returns the shifted list of string.
     */
    public List<String> shiftLeft(List<String> data, String add)
    {
        /**Temporary list */
        List<String> tmp = new ArrayList<String>();
        for(int i=0; i<data.size()-1; i++)
        {
            tmp.add(i,data.get(i+1));
        }
        tmp.add(data.size()-1,add);
      return tmp;
    }
     /**
     * shiftRight method is shifting to the right the elements of list.
     * @param data is an "away" list of teams
     * @param add is a temporary element of a "home" list, because we have to add it to an "away" list
     * @return method returns the shifted list of string.
     */
    public List<String> shiftRight(List<String> data, String add)
    {
        /**Temporary list */ 
        List<String> tmp = new ArrayList<String>();
        tmp.add("0");
        for(int i=1; i<data.size(); i++)
        {
            tmp.add(i,data.get(i-1));
        }
        tmp.set(0,add);
        return tmp;
    }
}
