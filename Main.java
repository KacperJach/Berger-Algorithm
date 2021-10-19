
package project.lab1;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author draak
 */
public class Main {
    public static void main(String[] args)
    {
        Model m = new Model();
        View v = new View();
        Controller controller = new Controller(args, m, v);       
    }
}
