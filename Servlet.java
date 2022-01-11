package pl.polsl.berger.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.project.berger.model.Model;
import pl.polsl.project.berger.model.Pair;

/**
 *
 * @author draak
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    private Model m = new Model();
    private Pair p = new Pair();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            String teamsList = request.getParameter("teamslist");
            List<String> teams = new ArrayList<String>();
            String[] tmpS = null;
            tmpS = teamsList.split(" ");
            teams.addAll(Arrays.asList(tmpS));

            try {
                p = m.bergerAlgorithm(teams);
                for (int i = 0; i < p.roundNumber; i++) {
                    out.printf("Round number: %d <br> ", i + 1);
                    if (i % 2 == 0) {
                        for (int j = 0; j < p.halfTeams; j++) {
                            out.printf("Match: %d %s - %s <br>", j + 1, p.away.get(j), p.home.get(j));
                        }
                    } else {
                        for (int j = 0; j < p.halfTeams; j++) {
                            out.printf("Match: %d %s - %s <br>", j + 1, p.home.get(j), p.away.get(j));
                        }
                    }

                    String tmp = p.home.get(0);

                    String move = p.away.get(p.away.size() - 1);

                    p.away = shiftRight(p.away, p.home.get(1));

                    p.home = shiftLeft(p.home, move);
                    p.home.set(0, tmp);
                }

            } catch (Exception e) {
                response.sendError(response.SC_BAD_REQUEST, "You should give some names of teams!");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }
    /**
     * shiftLeft method is shifting to the left the elements of list.
     * @param data is a "home" list of teams
     * @param add is a temporary element of an "away" list, because we have to add it to a "home" list
     * @return method returns the shifted list of string.
     */
    public List<String> shiftLeft(List<String> data, String add)
    {
        /**Temporary list */
        List<String> tmp = new ArrayList<String>();
        for(int i=0; i<data.size()-1; i++)
        {
            tmp.add(i,data.get(i+1));
        }
        tmp.add(data.size()-1,add);
      return tmp;
    }
     /**
     * shiftRight method is shifting to the right the elements of list.
     * @param data is an "away" list of teams
     * @param add is a temporary element of a "home" list, because we have to add it to an "away" list
     * @return method returns the shifted list of string.
     */
    public List<String> shiftRight(List<String> data, String add)
    {
        /**Temporary list */ 
        List<String> tmp = new ArrayList<String>();
        tmp.add("0");
        for(int i=1; i<data.size(); i++)
        {
            tmp.add(i,data.get(i-1));
        }
        tmp.set(0,add);
        return tmp;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
