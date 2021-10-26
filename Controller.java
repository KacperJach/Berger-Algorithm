package project.lab1;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Controller class is reponsible for the communication between model and view
 * @author Kacper Jach 
 */
public class Controller {
    /**List of teams given by project arguments */
    List<String> teams = new ArrayList<String>(); 
    /**Variable of View class */
    private View  view; 
    /**Variable of Model class */
    private Model model; 
    /**Variable of Pair class */
    private Pair p; 
    /**
     * Constructor of the Controller class is responsible for making list of string from the given arguments, and starts the berger algorithm,
     * then view method is called and prints output in the user's console.
     * @param args arguments given in command prompt
     * @param m Model object created in main method
     * @param v View object created in main method
     */
    public Controller(String[] args, Model m, View v)
    {
        this.view = v;
        this.model = m;
        if(args.length==0)
        {
            this.view.message("Enter number of teams"); 
            Scanner scanner = new Scanner(System.in);
            String[] input = null;
            if(scanner.hasNextLine())
            {
                input = scanner.nextLine().split(" ");
            }
            for(int i=0; i<input.length; i++)
            {
                teams.add(input[i]);
            }
            
        }
        else
        {
            for(int i=0; i<args.length; i++)
            {
                teams.add(args[i]);
            }
        }
        Pair pair = getPair();
        view.show(pair);
    }
    /**
     * Method generates the pair of lists and run the Berger Algorithm
     * @return method returns the lists' pair of given teams
     */
    public Pair getPair()
    {
        try{
            
        
        p = model.bergerAlgorithm(teams);
        return p;
        } catch(IsEmptyException e){
            this.view.message("There is no teams to make an Berger's Table.");
            return p;
        }
    }
    
}
