package project.lab1;
import java.util.List;

/**
 * Model Class has a Berger algorithm method
 * @author Kacper Jach
 */
public class Model {
    /**Variable of Pair class */
    private Pair p;  
    /**
     * This method is responsible for calling the Berger algorithm
     * @param teams list of teams names
     * @throws IsEmptyException throws an exception when there are no teams in a list
     * @return method returns the pair of lists
     */
    public Pair bergerAlgorithm(List<String> teams) throws IsEmptyException
    {
        if(teams.size() == 0)
            throw new IsEmptyException();
        this.p = new Pair(teams); 
        return p;      
    }
    
}
