/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.lab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author draak
 */
public class Pair {
    List<String> home = new ArrayList<String>();
    List<String> away = new ArrayList<String>();
    int round_number;
    int half_teams;
    
    Pair(List<String> teams)
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
