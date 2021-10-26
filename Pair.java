package project.lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Pair class is a part of Model in MVC structure,
 * it contains two lists of teams.
 * @author Kacper Jach
 */
public class Pair {
    /**List of "home" teams */
    public List<String> home = new ArrayList<String>(); 
    /**List of "away" teams */
    public List<String> away = new ArrayList<String>(); 
    /**Number of round which will be necessary to create Berger's Table */
    public int round_number; 
    /**Contains half number of teams   */
    public int half_teams; 
    /**
     * Method using Berger Algorithm 
     * @param teams list of teams given as arguments
     */
    public Pair(List<String> teams)
    {
        int how_many_teams = teams.size();
        if(!(how_many_teams%2 == 0))
        {
            teams.add("bye");
            how_many_teams +=1;
        }
        this.round_number = how_many_teams - 1;
        this.half_teams = how_many_teams/2;
        
        
        
        for(int i=0; i<half_teams; i++)
        {
            this.home.add(teams.get(i));
            this.away.add(teams.get(how_many_teams -1 -i));
        }
    }
}
