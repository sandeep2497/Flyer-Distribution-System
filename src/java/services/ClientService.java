package services;
import dao.ClientDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Client;

public class ClientService {
   
    public static int addClient(int agent,String name,String lastname,String num,String streetname,String city,String province,String postalcode, String off,String cell,String email,String company,String type,ClientDao dao){
        int res = 0;
        Client clientObj = new Client();
        if(name!=null){
            clientObj.setUserId(agent);
            int n = Integer.parseInt(num);
            clientObj.setName(name);
            clientObj.setLastname(lastname);
            clientObj.setStreetnumber(n);
            clientObj.setStreetName(streetname);
            clientObj.setCity(city);
            clientObj.setProvince(province);
            clientObj.setPostalcode(postalcode);
            clientObj.setTeloffice(off);
            clientObj.setTelcell(cell);
            clientObj.setCompany(company);
            clientObj.setCompanytype(type);
            
            res = dao.addClient(clientObj);
        }
        return res;
    }
//    public boolean deleteClient(int id, ClientDao dao) throws SQLException{
//        boolean res = dao.deleteClient(id);
//        return res;
//    }
    
    public Client showUser(int id, ClientDao dao) throws SQLException{
        Client userObj = dao.showUser(id);
        return userObj;
    }
    
    public ArrayList<Client> viewUsers(ClientDao dao){
        ArrayList<Client> userList = new ArrayList();
        userList = dao.viewUsers();
        return userList;
    }
    
    public boolean updateClient(Client userObj, ClientDao dao) throws SQLException{
        boolean res = dao.updateClient(userObj);
        return res;
    }
    
}