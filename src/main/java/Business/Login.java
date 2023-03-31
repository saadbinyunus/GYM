/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author student
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Helper.UserInfo;
import Helper.Trainer;
import Helper.Equipment;
import Helper.HireTrainer;
import Helper.BookEquipment;
import java.util.ArrayList;
import Persistence.Client_CRUD;
import java.sql.SQLException;
import Persistence.trainer_CRUD;
/**
 *
 * @author student
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ArrayList <Trainer> trainer = new ArrayList<>();
    public void addTrainer(Trainer trainer_new){
        trainer.add(trainer_new);
    }
    public ArrayList<Trainer> getTrainer(){
        return trainer;
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=(String) request.getParameter("username");
        String password=(String) request.getParameter("password");
        
        UserInfo uinfo=getUserInfo(username, password);
        
        if (uinfo==null){
            RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else{
            request.getSession().setAttribute("uname", username);
            request.setAttribute("trainerInfo", trainer_CRUD.getTrainers());
            
            RequestDispatcher rd= request.getRequestDispatcher("userbooks.jsp");
            rd.forward(request, response);
            
        }
        
        
     
    }

   // private UserInfo getUserInfo(String uname, String password) {
        /**
         * to be completed. For now, we just return a user info object that has a default book in a default date;
         * This method must return null when user name and password is incorrect
         * otherwise it must return an object containing all books that have been borrowed by the user, in addition to user information like name, address, ...
         */
     //   UserInfo uf= new UserInfo();
   
        
       /*/try {
           uf.addTrainer(new Trainer("Michael Scott", "Male", "Cardio", true));
           uf.addTrainer(new Trainer("Pam Beesly", "Female", "Bulking", false));
           uf.addTrainer(new Trainer("Mike Ross", "Male", "Bulking", true));
           uf.addTrainer(new Trainer("Harvey Spectre", "Male", "Weights", true));
           uf.addTrainer(new Trainer("Sheikh Hasina", "Female", "Machines", true));
           uf.addTrainer(new Trainer("Justin Trudeau", "Male", "Bulking", false));
           uf.addTrainer(new Trainer("Cristiano Ronaldo", "Male", "Athletic", false));
           uf.addTrainer(new Trainer("Lionel Messi", "Male", "Legs", true));
           uf.addTrainer(new Trainer("Jebron Lames", "Female", "Crossfit", true));
           
     /*  } catch (ParseException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error");
       }*/
       // return uf;
    //}
        private UserInfo getUserInfo(String uname, String password){
        
        UserInfo uinfo;
        try{
        uinfo = Client_CRUD.read(uname, password);}
        catch (SQLException e) {
        throw new RuntimeException("Error retrieving user info from database", e);
    
                }
        
        return uinfo;}
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          doPost(request, response);

        
    }

}
