package project.lab1;
import java.util.List;

/**
 *
 * @author draak
 */
public class Model {
    
    private Pair p;
    
    public Pair bergerAlgorithm(List<String> teams)
    {
        this.p = new Pair(teams); 
        return p;      
    }
    
}
