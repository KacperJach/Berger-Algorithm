package pl.polsl.project.berger.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Pair class is a part of Model in MVC structure, it contains two lists of
 * teams.
 *
 * @author Kacper Jach
 */
public class Pair {

    /**
     * List of "home" teams
     */
    public List<String> home = new ArrayList<String>();
    /**
     * List of "away" teams
     */
    public List<String> away = new ArrayList<String>();
    /**
     * Number of round which will be necessary to create Berger's Table
     */
    public int roundNumber;
    /**
     * Contains half number of teams
     */
    public int halfTeams;
    public int howManyTeams;

    
    public Pair()
    {
        
    }
    /**
     * Method using Berger Algorithm
     *
     * @param teams list of teams given as arguments
     */
    public Pair(List<String> teams) {

        this.howManyTeams = teams.size();
        if (!(howManyTeams % 2 == 0)) {
            teams.add("bye");
            this.howManyTeams += 1;
        }
        this.roundNumber = howManyTeams - 1;
        this.halfTeams = howManyTeams / 2;

        for (int i = 0; i < halfTeams; i++) {
            this.home.add(teams.get(i));
            this.away.add(teams.get(howManyTeams - 1 - i));
        }
    }
}

