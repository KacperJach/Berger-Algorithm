package project.lab1;

/**
 * Exception Class checking if there are teams in a list structure
 * @author Kacper Jach
 */
public class IsEmptyException extends Exception{
    public IsEmptyException()
    {        
    } 
    /**
     * Constructor with string message of exception
     * @param errM is an error message
     */
    public IsEmptyException(String errM)
    {
        super(errM);
    }
    
}
