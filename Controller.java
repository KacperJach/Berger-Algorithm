/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.lab1;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author draak
 */
public class Controller {
    List<String> teams = new ArrayList<String>();
    private View  view;
    private Model model;
    private Pair p;
    Controller(String[] args, Model m, View v)
    {
        this.view = v;
        this.model = m;
        for(int i=0; i<args.length; i++)
        {
            teams.add(args[i]);
        }
        Pair pair = getPair();
        view.show(pair);
    }
    public Pair getPair()
    {
        p = model.bergerAlgorithm(teams);
        return p;
    }
    
}
