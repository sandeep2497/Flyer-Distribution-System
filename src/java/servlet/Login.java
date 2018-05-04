package servlet;
//*****************************************
//*****************************************
//************     Daniel Rayo ***********
//****************************************
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
//*********************************************************************************************
//*********************************************************************************************
//****************************Servlet That just Handles the login************************************************
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
            Connection conn = null;
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            String sql ="select * from users where username=? and password=?";
           String dbname = null;
           String dbpassword = null;
           int agent = 0;
           int role = 0;
            Class.forName("com.mysql.jdbc.Driver");
           if(conn==null || conn.isClosed()){
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/printmarketing", "root", "");
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    dbname = rs.getString(2);
                    dbpassword = rs.getString(3);
                    role = rs.getInt("Role");
                    agent = rs.getInt("agentid");
                }
                //Using session to see who login
                //1 for admin
                //2 for agent
               HttpSession session = request.getSession(true);
                if(name.equals(dbname)&& password.equals(dbpassword)){
                    
                    session.setAttribute("role", role);
                    session.setAttribute("name",dbname);
                    session.setAttribute("agent",agent);
                    response.sendRedirect("home.jsp");
                }else{
                    session.setAttribute("message", "UserName or Password Incorrect");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.include(request, response);
                    session.removeAttribute("message");
                }
           }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       } catch(ClassNotFoundException ex){
           ex.printStackTrace();
       }
       
    }

}
