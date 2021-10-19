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
public class View {
    public void show(Pair p)
    {
        for(int i=0;i<p.round_number; i++)
        {
            System.out.printf("%d Round number: ", i+1);
            if(i%2==0)
            {
                for(int j=0;j<p.half_teams; j++)
                {
                    System.out.printf("%d %s - %s \n", j+1, p.away.get(j), p.home.get(j));
                }
            }
            else
            {
                for(int j=0;j<p.half_teams; j++)
                {
                    System.out.printf("%d %s - %s \n", j+1, p.home.get(j), p.away.get(j));
                }
            }
            //Zapamietanie  pierwszego elementu
            String tmp = p.home.get(0);
            
            String move = p.away.get(p.away.size()-1);
            System.out.println(p.away.size());
            p.away = shiftRight(p.away, p.home.get(1));
            
            p.home = shiftLeft(p.home, move);
            p.home.set(0 , tmp);
            
        }
    }
    public List<String> shiftLeft(List<String> data, String add)
    {
        List<String> tmp = new ArrayList<String>();
        for(int i=0; i<data.size()-1; i++)
        {
            tmp.add(i,data.get(i+1));
        }
        tmp.add(data.size()-1,add);
        return tmp;
    }
    public List<String> shiftRight(List<String> data, String add)
    {
        List<String> tmp = new ArrayList<String>();
        tmp.add("0");
        for(int i=1; i<data.size(); i++)
        {
            tmp.add(i,data.get(i-1));
        }
        tmp.set(0,add);
        return tmp;
    }
}
