package dao;
//Daniel Rayo
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import model.Agent;
import model.Client;
import model.Location;
import model.Orders;
//******************************************
//******************************************
//******** All The Data Base ***************
//******************************************
//******************************************
public class ClientDao {
    private String url;
    private String userDB;
    private String passDB;
    
    public ClientDao(){
    }
    
    public ClientDao(String url, String userDB, String passDB){
        this.url = url;
        this.userDB = userDB;
        this.passDB = passDB;
    }
    public Connection getConnection(){
       Connection conn = null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           if(conn==null || conn.isClosed()){
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/printmarketing", userDB, passDB);
           }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       } catch(ClassNotFoundException ex){
           ex.printStackTrace();
       }
       return conn;
   }
       
    public int addClient(Client userObj){
        int res = 0;
        
        String sql = "INSERT INTO clients (agentid,firstname,lastname,streetNumber,streetName,city,province,postalCode,telOffice,telCell,email,company,companytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            Connection conn = getConnection();
            if(conn!=null){
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, userObj.getUserId());
                stmt.setString(2, userObj.getName());
                stmt.setString(3, userObj.getLastname());
                stmt.setInt(4, userObj.getStreetnumber());
                stmt.setString(5, userObj.getStreetName());
                stmt.setString(6, userObj.getCity());
                stmt.setString(7, userObj.getProvince());
                stmt.setString(8, userObj.getPostalcode());
                stmt.setString(9, userObj.getTeloffice());
                stmt.setString(10, userObj.getTelcell());
                stmt.setString(11, userObj.getEmail());
                stmt.setString(12, userObj.getCompany());
                stmt.setString(13, userObj.getCompanytype());
                
                
                
                res = stmt.executeUpdate();
                conn.close();
            }
            
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return res;
    }
     public int addAgent(Agent userObj){
        int res = 0;
        String sql = "INSERT INTO marketingagent (firstname,lastname,phoneNo,email) VALUES (?,?,?,?)";
        String sql1= "INSERT INTO users (UserName,Password,Role,agentId) VALUES(?,?,2,?)";
        try{
            Connection conn = getConnection();
            if(conn!=null){
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, userObj.getFname());
                stmt.setString(2, userObj.getLname());
                stmt.setString(3, userObj.getPhoneNo());
                stmt.setString(4, userObj.getEmail());
                //will add a username for agent using the same agentid 
                res = stmt.executeUpdate();
                 if(res>0){
                    String sql3 = "SELECT id FROM marketingagent WHERE id=(SELECT max(id) FROM marketingagent)";
                   
                     PreparedStatement stmt3 = conn.prepareStatement(sql3);
                     ResultSet rs  = stmt3.executeQuery();
                     while(rs.next()){
                        userObj.setId(rs.getInt("id"));
                     }
                 }
                    PreparedStatement stmt1 = conn.prepareStatement(sql1);
                    stmt1.setString(1, userObj.getUserName());
                    stmt1.setString(2, userObj.getPassword());
                    
                    stmt1.setInt(3, userObj.getId());
                    stmt1.executeUpdate();
                     
                conn.close();
            }
            
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return res;
    }
    public int addLocation(Location userObj){
        int res = 0;
        String sql = "INSERT INTO location (locationName,distributionCapacity) VALUES (?,?)";
        try{
            Connection conn = getConnection();
            if(conn!=null){
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, userObj.getLocationName());
                stmt.setInt(2, userObj.getDistributionCapacity());
                
                res = stmt.executeUpdate();
                conn.close();
            }
            
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return res;
    }
    public int addOrder(Orders order){
        int res = 0;
        String sql = "INSERT INTO orders (agentId,clientId,flyerQty,flyerLayout,flyerImg,personalCopy,paymentInformation, invoiceNumber, comments) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
        try{
            Connection conn = getConnection();
            if(conn!=null){
                
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, order.getAgentId());
                statement.setInt(2, order.getClientId());
                statement.setInt(3, order.getFlyerQty());
                statement.setString(4, order.getFlyerLayout());

                statement.setBlob(5, order.getFlyerImg());
                statement.setInt(6, order.getPersonalCopy());
                statement.setString(7, order.getPaymentInformation());
                statement.setString(8, order.getInvoiceNumber());   
                statement.setString(9, order.getComments());
               
                res = statement.executeUpdate();
                conn.close();
            }
            
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return res;
    }
    
    public boolean deleteClient(int id) throws SQLException {
        boolean res;
        // delete statement
        String sql = "DELETE FROM clients ";
        sql += "WHERE id = ?";
        // connect to db
        Connection con = getConnection();

        PreparedStatement statement = con.prepareStatement(sql);
        // set id to the statement
        statement.setInt(1, id);

        // will be true if rows were affected by delete statement
        res = statement.executeUpdate() > 0;
        //return boolean value
        return res;
   }
    public boolean deleteOrder(int id) throws SQLException {
        boolean res;
        // delete statement
        String sql = "DELETE FROM orders ";
        sql += "WHERE id = ?";
        // connect to db
        Connection con = getConnection();

        PreparedStatement statement = con.prepareStatement(sql);
        // set id to the statement
        statement.setInt(1, id);

        // will be true if rows were affected by delete statement
        res = statement.executeUpdate() > 0;
        //return boolean value
        return res;
   }
    public boolean deleteAgent(int id) throws SQLException {
        boolean res;
        // delete statement
        String sql = "DELETE FROM marketingagent ";
        sql += "WHERE id = ?";
        String sql1 = "DELETE FROM users WHERE agentid =?";
        // connect to db
        Connection con = getConnection();

        PreparedStatement statement = con.prepareStatement(sql1);
        // set id to the statement
        statement.setInt(1, id);

        // will be true if rows were affected by delete statement
        res = statement.executeUpdate() > 0;
        if(res){
             PreparedStatement statement1 = con.prepareStatement(sql);
             // set id to the statement
             statement1.setInt(1, id);
        }
        //return boolean value
        return res;
   }
    public boolean deleteLocation(int id) throws SQLException {
        boolean res;
        // delete statement
        String sql = "DELETE FROM location ";
        sql += "WHERE id = ?";
        // connect to db
        Connection con = getConnection();

        PreparedStatement statement = con.prepareStatement(sql);
        // set id to the statement
        statement.setInt(1, id);

        // will be true if rows were affected by delete statement
        res = statement.executeUpdate() > 0;
        //return boolean value
        return res;
   }
    
    public Client showUser(int id) throws SQLException{
       Client userObj = null;
       String sql = "SELECT * FROM clients ";
       sql += "WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, id);
       ResultSet result = statement.executeQuery();       
       while(result.next()){
           userObj = new Client();
           userObj.setUserId(result.getInt("id"));
           userObj.setName(result.getString("firstname"));
           userObj.setLastname(result.getString("lastName"));
           userObj.setStreetnumber(result.getInt("streetnumber"));
           userObj.setStreetName((result.getString("streetname")));
           userObj.setCity((result.getString("city")));
           userObj.setProvince((result.getString("province")));
           userObj.setPostalcode((result.getString("postalcode")));
           userObj.setTeloffice((result.getString("telOffice")));
           userObj.setTelcell((result.getString("telCell")));
           userObj.setEmail((result.getString("email")));
           userObj.setCompany((result.getString("company")));
           userObj.setCompanytype((result.getString("companytype")));
       }       
       return userObj;
   }
    public Orders showOrder(int id) throws SQLException{
       Orders order = null;
       String sql = "SELECT * FROM orders ";
       sql += "WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, id);
       ResultSet result = statement.executeQuery();       
       while(result.next()){
           order = new Orders();
           order.setId(result.getInt("id"));
           order.setAgentId((result.getInt("agentid")));
           order.setClientId((result.getInt("clientid")));
           order.setFlyerQty((result.getInt("flyerQty")));
           order.setFlyerLayout((result.getString("flyerLayout")));
           order.setPersonalCopy((result.getInt("personalCopy")));
           order.setPaymentInformation((result.getString("paymentInformation")));
           order.setInvoiceNumber((result.getString("invoiceNumber")));
           order.setComments((result.getString("comments")));
       }       
       return order;
   }
    public Agent showAgent(int id) throws SQLException{
       Agent userObj = null;
       String sql = "SELECT * FROM marketingagent ";
       sql += "WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, id);
       ResultSet result = statement.executeQuery();       
       while(result.next()){
           userObj = new Agent();
           userObj.setId(result.getInt("id"));
           userObj.setFname(result.getString("firstname"));
           userObj.setLname(result.getString("lastName"));
           userObj.setPhoneNo(result.getString("phoneNo"));
           userObj.setEmail((result.getString("email")));
           
       }       
       return userObj;
   }
     public Location showLocation(int id) throws SQLException{
       Location userObj = null;
       String sql = "SELECT * FROM location ";
       sql += "WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, id);
       ResultSet result = statement.executeQuery();       
       while(result.next()){
           userObj = new Location();
           userObj.setId(result.getInt("id"));
           userObj.setLocationName(result.getString("locationName"));
           userObj.setDistributionCapacity(result.getInt("distributionCapacity"));
           
       }       
       return userObj;
   }
    
    public ArrayList<Client> viewUsers(){
       ArrayList<Client> userList = new ArrayList();
//       String sql = "SELECT * FROM  clients";
       
       String sql ="SELECT c.*,m.firstname,m.lastname FROM clients c INNER JOIN marketingagent m ON c.agentid = m.id";
       
       
//       SELECT column_name(s)
//FROM table1
//INNER JOIN table2 ON table1.column_name = table2.column_name;
//       
       
       String name, agentname,agentlast,lastname,streetName,city,province,postalcode,teloffice,telcell,email,company,companytype;
       
       int id,streetnumber,agent;
       
       try{
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next()){
           id = resultSet.getInt("c.id");
           agent = resultSet.getInt("c.agentid");
           name = resultSet.getString("c.firstName");
           lastname = resultSet.getString("c.lastName");
           streetName = resultSet.getString("c.streetName");
           streetnumber = resultSet.getInt("c.streetNumber");
           city = resultSet.getString("c.city");
           province = resultSet.getString("c.province");
           postalcode =resultSet.getString("c.postalcode");
           teloffice = resultSet.getString("c.teloffice");
           telcell = resultSet.getString("c.telcell");
           email =resultSet.getString("c.email");
           company =resultSet.getString("c.company");
           companytype=resultSet.getString("c.companytype");
           agentname = resultSet.getString("m.firstname");
           agentlast = resultSet.getString("m.lastname");
           String full = agentname + " "+ agentlast;
           
            Client userObj = new Client();            
           userObj.setUserId(id);
           userObj.setName(name);
           userObj.setAgent(agent);
           userObj.setLastname(lastname);
           userObj.setStreetName(streetName);
           userObj.setCity(city);
           userObj.setProvince(province);  
           userObj.setPostalcode(postalcode);
           userObj.setTeloffice(teloffice);
           userObj.setTelcell(telcell);
           userObj.setEmail(email);
           userObj.setCompany(company);
           userObj.setCompanytype(companytype);
           userObj.setStreetnumber(streetnumber);
           userObj.setAgentname(full);
           userList.add(userObj);
        }
       resultSet.close();
       stmt.close();
        if(conn!=null && !conn.isClosed()){
         conn.close();
        }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       }
       return userList;
   }
    public ArrayList<Orders> viewOrders(){
       ArrayList<Orders> userList = new ArrayList();
       String sql = "SELECT o.*,m.firstname,m.lastname,c.firstname,c.lastname FROM  orders o INNER JOIN marketingagent m ON o.agentid = m.id INNER JOIN clients c ON o.clientid = c.id";
       //String sql = "SELECT o.id,o.agentId,o.clientId,o.flyerQty,o.flyerLayout,o.flyerImg,o.personalCopy,o.paymentInformation,o.invoiceNumber,o.comments,o.isFlyerArtApproved,o.isPaymentReceived,m.fistname,m.lastname FROM orders o INNER JOIN marketingagent m ON o.agentid = m.id";
       
       try{
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next()){
           int id = resultSet.getInt("o.id");
            int agentId = resultSet.getInt("o.agentId");
            int clientId = resultSet.getInt("o.clientId");
            int flyerQty = resultSet.getInt("o.flyerQty");
            String flyerLayout = resultSet.getString("o.flyerLayout");
            Blob image = resultSet.getBlob("o.flyerImg");
            byte[] imgData = null;
            imgData = image.getBytes(1,(int)image.length());
            String flyerImg = Base64.getEncoder().encodeToString(imgData);
            int personalCopy = resultSet.getInt("o.personalCopy");
            String paymentInformation = resultSet.getString("o.paymentInformation");
            String invoiceNumber = resultSet.getString("o.invoiceNumber");
            String comments = resultSet.getString("o.comments");
            int isFlyerArtAppr = resultSet.getInt(("o.isFlyerArtApproved"));
            int isPaymentReceived = resultSet.getInt("o.isPaymentReceived");
            //Get name from agent and make it one string
            String agentfirst = resultSet.getString("m.firstname");
            String agentlast = resultSet.getString("m.lastname");
            String fullAgent = agentfirst +" "+agentlast;
            //Get name from client and make it one string
            String clientF = resultSet.getString("c.firstname");
            String clientL = resultSet.getString("c.lastname");
            String fullClient = clientF +" "+ clientL;
            
            Orders order = new Orders(fullAgent,fullClient,id, agentId, clientId, flyerQty, flyerLayout,  flyerImg, personalCopy, paymentInformation, invoiceNumber, comments, isFlyerArtAppr, isPaymentReceived);
            userList.add(order);
        }
       resultSet.close();
       stmt.close();
        if(conn!=null && !conn.isClosed()){
         conn.close();
        }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       }
       return userList;
   }
    public ArrayList<Location> viewLocation(){
       ArrayList<Location> userList = new ArrayList();
       String sql = "SELECT * FROM  location";
       String name;
       int id,quantity;
       
       try{
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next()){
           id = resultSet.getInt("id");
           quantity = resultSet.getInt("distributionCapacity");
           name = resultSet.getString("locationName");
           
            Location userObj = new Location();            
           userObj.setId(id);
           userObj.setLocationName(name);
           userObj.setDistributionCapacity(quantity);
           userList.add(userObj);
        }
       resultSet.close();
       stmt.close();
        if(conn!=null && !conn.isClosed()){
         conn.close();
        }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       }
       return userList;
   }
    public ArrayList<Agent> viewAgents(){
       ArrayList<Agent> MAgentList = new ArrayList();
       String sql = "SELECT m.id,m.firstName,m.lastName,m.phoneNo,m.email,u.username,u.password FROM marketingagent m,users u WHERE m.id = u.agentid ORDER BY u.role ASC;";
       
       int id = 0;
       String fname,lname,phoneNo,email,userName,password;
       
       try{
        Connection conn = getConnection();
           try (Statement stmt = conn.createStatement()) {
               ResultSet resultSet = stmt.executeQuery(sql);
               
               while(resultSet.next()){
                   
                   id = resultSet.getInt("id");
                   fname=resultSet.getString("firstName");
                   lname=resultSet.getString("lastName");
                   phoneNo=resultSet.getString("phoneNo");
                   email=resultSet.getString("email");
                   userName=resultSet.getString("userName");
                   password=resultSet.getString("password");
                                      
                   Agent MAgentObj = new Agent();
                   
                    MAgentObj.setId(id);            
                    MAgentObj.setFname(fname);
                    MAgentObj.setLname(lname);
                    MAgentObj.setEmail(email);
                    MAgentObj.setPhoneNo(phoneNo);
                    MAgentObj.setUserName(userName);
                    MAgentObj.setPassword(password);
                   MAgentList.add(MAgentObj);
               }
               
               resultSet.close();
           }
        if(conn!=null && !conn.isClosed()){
         conn.close();
        }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       }
       return MAgentList;
   }
     
     
    public boolean updateClient(Client userObj) throws SQLException{
       boolean res;
       String sql = "UPDATE clients SET firstname=?,lastname=?,streetnumber=?,streetname=?,city=?,province=?,postalcode=?,teloffice=?,telcell=?,email=?,company=?,companytype=?";
       sql += "WHERE id = ?";       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       
       
       statement.setString(1, userObj.getName());  
       statement.setString(2, userObj.getLastname());  
       statement.setInt(3, userObj.getStreetnumber());  
       statement.setString(4, userObj.getStreetName());  
       statement.setString(5, userObj.getCity());  
       statement.setString(6, userObj.getProvince());
       statement.setString(7, userObj.getPostalcode());  
       statement.setString(8, userObj.getTeloffice());  
       statement.setString(9, userObj.getTelcell());  
       statement.setString(10, userObj.getEmail());  
       statement.setString(11, userObj.getCompany());  
       statement.setString(12, userObj.getCompanytype());  
       statement.setInt(13, userObj.getUserId());
       
       res = statement.executeUpdate() > 0;
       
       return res;
   }
    public boolean updateOrder(Orders order) throws SQLException{
           String sql = "UPDATE orders SET flyerQty = ?, flyerLayout = ?,personalCopy = ?, paymentInformation = ?, invoiceNumber = ?, comments = ?, isFlyerArtApproved = ?, isPaymentReceived = ?";
        sql += " WHERE id = ?";
       Connection con = getConnection();
         PreparedStatement statement = con.prepareStatement(sql);
        
       
        statement.setInt(1, order.getFlyerQty());
        statement.setString(2, order.getFlyerLayout());
       
        statement.setInt(3, order.getPersonalCopy());
        statement.setString(4, order.getPaymentInformation());
        statement.setString(5, order.getInvoiceNumber());
        statement.setString(6, order.getComments());
        statement.setInt(7, order.isIsFlyerArtApproved());
        statement.setInt(8, order.isIsPaymentRecieved());
        statement.setInt(9, order.getId());

         boolean rowUpdated = statement.executeUpdate() > 0;
       
        return rowUpdated;
   }
    public boolean updateAgent(Agent order) throws SQLException{
           String sql = "UPDATE marketingagent SET firstname =?, lastname = ?, phoneNo = ?, email = ?";
           sql += " WHERE id = ?";
       Connection con = getConnection();
         PreparedStatement statement = con.prepareStatement(sql);
        
        statement.setInt(5, order.getId());
        statement.setString(1, order.getFname());
        statement.setString(2, order.getLname());
        statement.setString(3, order.getPhoneNo());
        statement.setString(4, order.getEmail());
      
         boolean rowUpdated = statement.executeUpdate() > 0;
       
        return rowUpdated;
   }
     public boolean updateLocation(Location order) throws SQLException{
           String sql = "UPDATE location SET locationName =?, distributionCapacity = ?";
           sql += " WHERE id = ?";
       Connection con = getConnection();
         PreparedStatement statement = con.prepareStatement(sql);
        
       
        statement.setString(1, order.getLocationName());
        statement.setInt(2, order.getDistributionCapacity());
        statement.setInt(3, order.getId());
      
         boolean rowUpdated = statement.executeUpdate() > 0;
       
        return rowUpdated;
   }
   
}
