package project.lab1;

/**
 * To run program with arguments you just have to write teams' names or numbers in a command prompt separated with spaces
 * @version 1.0
 * @author Kacper Jach
 */
public class Main {
    public static void main(String[] args)
    {
        Model m = new Model();
        View v = new View();
        Controller controller = new Controller(args, m, v);       
    }
}
