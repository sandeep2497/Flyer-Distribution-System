package servlet;
//*****************************************
//*****************************************
//************     Daniel Rayo ***********
//****************************************

import dao.ClientDao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Agent;
import model.Client;
import model.Location;
import model.Orders;
import services.AgentService;
import services.ClientService;
import services.LocationService;
import services.OrderService;

public class FinalServlet extends HttpServlet {
    ClientService registerService;
    OrderService registerService1;
    LocationService LocationService;
    AgentService agentService;
    ClientDao registerDao;
    String jdbcUserName;
    String jdbcPassword;
    String jdbcURL;
    
    //OverRide the init values and will take the db string from the web.xml
            //************************************
            //********* Connection to DB****************
            //************************************   
            //************************************
    @Override
    public void init() throws ServletException {
        jdbcURL = getServletContext().getInitParameter("jdbcURL");
        jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
        jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        registerDao = new ClientDao(jdbcURL, jdbcUserName, jdbcPassword);
        registerService = new ClientService(); 
        registerService1 = new OrderService();        
       
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getServletPath();
        HttpSession session = request.getSession(false);
        //All posible paths that servlet can take
        
        switch(action){
           
             //************************************
            //********* To see all the list ****************
            //************************************   
            //************************************
            case "/order":
               viewOrders(request, response);
                break; 
            case "/list":
                viewUsers(request, response);
                break;
            case "/listLoc":
                 int role = (int)session.getAttribute("role");
                if(role == 2){
                    session.setAttribute("message1", "Sorry You Have No Access To Locations");
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                    rd.include(request, response);
                    session.removeAttribute("message1");
                    break;
                }else{
                    viewLocation(request, response);
                break; 
                }
            case "/listAgents":
                int role3 = (int)session.getAttribute("role");
                if(role3 == 2){
                    session.setAttribute("message1", "Sorry You Have No Access To See All Agents");
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                    rd.include(request, response);
                    session.removeAttribute("message1");
                    break;
                }else{
                    viewAgents(request,response);
                    break;
                }
               
             //************************************
            //********* All Add ****************
            //************************************   
            //************************************
            case "/new":
                addClient(request, response);                
                break;
            case "/neworder":
                session.removeAttribute("error");
                addOrder(request, response);    
                break;
            case"/newLocation":
                addLocation(request,response);
                break;
            case"/newAgent":
                addAgent(request,response);
                break;
             //************************************
            //********* All Delete ****************
            //************************************   
            //************************************
            //Checks if its an agent or admin first
            //************************************    
            case "/delete":
                int role1 = (int)session.getAttribute("role");
                if(role1 == 2){
                    session.setAttribute("message1", "Sorry You Have No Access to Delete Clients");
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                    rd.include(request, response);
                    session.removeAttribute("message1");
                    break;
                }else{
                     deleteClient(request, response);
                     break;
                }
            case "/deleteO":
                     deleteOrder(request, response);
                     break;
            case "/deleteLoc":
                     deleteLocation(request, response);
                     break;
            //************************************
            //Will Delete the User and Password as well
            //************************************      
            case "/deleteAgent":
                     deleteAgent(request, response);
                     break;
             //************************************
            //********* All Edit ****************
            //************************************   
            //************************************
            //Checks if its an agent or admin first 
            case "/edit":
                int role2 = (int)session.getAttribute("role");
                if(role2 == 2){
                    session.setAttribute("message1", "Sorry You Have No Access to Edit Client's Information");
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                    rd.include(request, response);
                    session.removeAttribute("message1");
                    break;
                }else{
                     showEditForm(request, response);
                     break;
                }
            case "/editO":
                showEditFormOrder(request, response);
                break;
            case"/editAgent":
                showEditFormAgent(request,response);
                break;
            case"/editLocation":
                showEditFormLocation(request,response);
                break;
             //************************************
            //****** All Update Database *********
            //************************************   
            //************************************
            case "/update":
                updateClient(request, response);
                break;
            case"/updateOrder":
                updateOrder(request,response);
                break;
            case"/updateAgent":
                updateAgent(request,response);
                break;
            case"/updateLocation":
                updateLocation(request,response);
                break;
             //************************************
            //********* Default and nav  ****************
            //************************************   
            //************************************
            case "/gohome":
                response.sendRedirect("home.jsp");
                break;
            default:
               
                response.sendRedirect("login.jsp");
                break;
        }
       
    }
   
    //will call doGet
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
            //************************************
            //*********View all the list ****************
            //************************************   
            //************************************
    protected void viewUsers(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        HttpSession session = request.getSession();
        ArrayList<Client> userList = new ArrayList();
        userList = registerService.viewUsers(registerDao);
        session.setAttribute("dropdown", userList);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewClients.jsp");
        dispatcher.forward(request, response);
         session.removeAttribute("messageUser");
        
    }
    protected void viewAgents(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        ArrayList<Agent> userList = new ArrayList();
        userList = registerDao.viewAgents();
         if(userList == null){
            response.sendRedirect("home.jsp");
        }else{
             request.setAttribute("userlist", userList);
             RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAgents.jsp");
             dispatcher.forward(request, response);
         }
        
        
    }
    protected void viewLocation(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        ArrayList<Location> userList = new ArrayList();
//  
        userList = registerDao.viewLocation();
        if(userList == null){
            response.sendRedirect("home.jsp");
        }else{
            request.setAttribute("locList", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLocation.jsp");
            dispatcher.forward(request, response);
        }
        
        
    }
    protected void viewOrders(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        ArrayList<Orders> orderList = new ArrayList();
       
        orderList = registerService1.viewUsers(registerDao); 
        
       
        request.setAttribute("listOrder", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderList.jsp");
        dispatcher.forward(request, response);
        
    }
    
    
            //************************************
            //********* Add **********************
            //************************************   
            //************************************
    protected void addClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //***************************************************
        //******It will add the agent id using session********
        //***************************************************
        
        String name = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String streetnum = request.getParameter("Streetnum");
        String streetname = request.getParameter("Streetname");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String postalcode = request.getParameter("postalcode");
        String telof = request.getParameter("telO");
        String telcel = request.getParameter("telC");
        String email = request.getParameter("email");
        String company = request.getParameter("companyname");
        String type = request.getParameter("type");
         HttpSession session = request.getSession(false);
        int agent = (int)session.getAttribute("agent");
         
         
        int res = ClientService.addClient(agent,name,lastname,streetnum,streetname,city,province,postalcode,telof,telcel,email,company,type,registerDao);
       
        if(res>0){
           RequestDispatcher dispatcher = request.getRequestDispatcher("list");
           dispatcher.forward(request, response);
        } else {
           response.sendRedirect("AddClient.jsp");
        }
    }
     protected void addAgent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
         
        int res = AgentService.addAgent(name,lastname,phone,email,username,password,registerDao);
       
        if(res>0){
           RequestDispatcher dispatcher = request.getRequestDispatcher("listAgents");
           dispatcher.forward(request, response);
        } else {
           response.sendRedirect("AddAgent.jsp");
        }
    }
    protected void addLocation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");
        
        int res = LocationService.addLocation(name,quantity,registerDao);
       
        if(res>0){
           RequestDispatcher dispatcher = request.getRequestDispatcher("listLoc");
           dispatcher.forward(request, response);
        } else {
           response.sendRedirect("AddLocation.jsp");
        }
    }
    protected void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InputStream inn = null;
       
        String cId =(request.getParameter("clientId"));
        String FQuantity = (request.getParameter("flyerQty"));
        String layout = request.getParameter("flyerLayout");
            Part flyerImg = request.getPart("flyerImg");
            if(flyerImg != null){
            inn = flyerImg.getInputStream();
            }
        String personalCopy = (request.getParameter("personalCopy"));
        String paymentInformation = request.getParameter("paymentInformation");
        String invoiceNumber = request.getParameter("invoiceNumber");
        String comments = request.getParameter("comments");
        HttpSession session = request.getSession(false);
        
        String agent = session.getAttribute("agent").toString();
        
        
        
        int res = OrderService.addOrder(agent,cId,FQuantity,layout,inn,personalCopy,paymentInformation,invoiceNumber,comments,registerDao);
       
        if(res>0){
           RequestDispatcher dispatcher = request.getRequestDispatcher("order");
           
           dispatcher.forward(request, response);
        } else {
           session.setAttribute("message1", "*Image Too Big, Order was not added");
           response.sendRedirect("error.jsp");
           
           
        }
    }
    
            //************************************
            //********* All Delete ****************
            //************************************   
            //************************************
    private void deleteClient(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean b = false;
        try{
           b = registerDao.deleteClient(id);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        if(b){
            response.sendRedirect("list");
        }else{
            
            HttpSession session = request.getSession(true);
            session.setAttribute("messageUser", "*Client With Id " +id+ " Has orders Open, Can not Delete");
            response.sendRedirect("list");
           
        }
        
        
        
    }
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        try{
            registerService1.deleteClient(id,registerDao);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        
        response.sendRedirect("order");
        
    }
     private void deleteLocation(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        try{
            registerDao.deleteLocation(id);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        
        response.sendRedirect("listLoc");
        
    }
      private void deleteAgent(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        try{
            registerDao.deleteAgent(id);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        
        response.sendRedirect("listAgents");
        
    }
   
      
            //************************************
            //********* Show the edit form********
            //************************************   
            //************************************
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            Client user = registerService.showUser(id,registerDao);
            request.setAttribute("user",user);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditForm.jsp");
            dispatcher.forward(request,response);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }
    private void showEditFormLocation(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            Location loc = registerDao.showLocation(id);
            if(loc != null){
                request.setAttribute("user",loc);
                RequestDispatcher dispatcher = request.getRequestDispatcher("EditFormLocation.jsp");
                dispatcher.forward(request,response);
            }else{
                
            }
           
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }
    private void showEditFormOrder(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            Orders order = registerService1.showUser(id,registerDao);
            request.setAttribute("order",order);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditFormOrder.jsp");
            dispatcher.forward(request,response);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }
    private void showEditFormAgent(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            Agent agent = registerDao.showAgent(id);
            request.setAttribute("agent",agent);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditFormAgent.jsp");
            dispatcher.forward(request,response);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }

    
            //************************************
            //********* Update DAtabase ****************
            //************************************   
            //************************************
    private void updateClient(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        int streetnumber = Integer.parseInt(request.getParameter("streetnumber"));
        int id = Integer.parseInt(request.getParameter("id"));        
        String streetname = request.getParameter("streetname");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String postalcode = request.getParameter("postalcode");
        String telO = request.getParameter("telO");
        String telC = request.getParameter("telC");
        String email = request.getParameter("email");
        String companyname = request.getParameter("companyname");
        String type = request.getParameter("type");
        
        Client userObj = new Client(id,streetnumber,name,lastname,streetname,city,province,postalcode,telO,telC,email,companyname,type);
        try{
            registerService.updateClient(userObj,registerDao);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        response.sendRedirect("list");
    }
    private void updateOrder(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        int flyerQty = Integer.parseInt(request.getParameter("flyerQty"));
        String flyerLayout = request.getParameter("flyerLayout");
       
        int personalCopy = Integer.parseInt(request.getParameter("personalCopy"));
        String paymentInformation = request.getParameter("paymentInformation");
        String invoiceNumber = request.getParameter("invoiceNumber");
        String comments = request.getParameter("comments");
        int isFlyerArtAppr = Integer.parseInt(request.getParameter("isFlyerArtApproved"));
        int isPaymentReceived = Integer.parseInt(request.getParameter("isPaymentReceived"));
        
        Orders updateOrder = new Orders(id, flyerQty, flyerLayout, personalCopy, paymentInformation, invoiceNumber, comments, isFlyerArtAppr, isPaymentReceived);
       
        try{
            registerService1.updateOrder(updateOrder,registerDao);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        response.sendRedirect("order");
        
    }
    private void updateAgent(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");      
        int id = Integer.parseInt(request.getParameter("id"));        
       
        Agent agent = new Agent();
        agent.setId(id);
        agent.setFname(name);
        agent.setLname(lastname);
        agent.setPhoneNo(phone);
        agent.setEmail(email);
        
        try{
            registerDao.updateAgent(agent);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        response.sendRedirect("listAgents");
    }
    private void updateLocation(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        
        String name = request.getParameter("name");      
        int q = Integer.parseInt(request.getParameter("quantity"));    
        int id = Integer.parseInt(request.getParameter("id"));
       
        Location loc = new Location();
        loc.setDistributionCapacity(q);
        loc.setId(id);
        loc.setLocationName(name);
        
        
        try{
            registerDao.updateLocation(loc);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        response.sendRedirect("listLoc");
    }
}
            //************************************
            //********* Daniel Rayo****************
            //************************************   
            //************************************