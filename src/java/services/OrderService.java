
package services;

import dao.ClientDao;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Orders;

public class OrderService {
      public ArrayList<Orders> viewUsers(ClientDao dao){
        ArrayList<Orders> userList = new ArrayList();
        userList = dao.viewOrders();
        return userList;
    }
      public boolean deleteClient(int id, ClientDao dao) throws SQLException{
        boolean res = dao.deleteOrder(id);
        return res;
    }
      public Orders showUser(int id, ClientDao dao) throws SQLException{
        Orders userObj = dao.showOrder(id);
        return userObj;
    }
      public boolean updateOrder(Orders userObj, ClientDao dao)throws SQLException{
        boolean res = dao.updateOrder(userObj);
        return res;
    }
      public static int addOrder(String a,String c,String fQ,String layout,InputStream image,String pc,
              String pI,String IN,String com,ClientDao dao){
        int res = 0;
        Orders order = new Orders();
        
        if(a!=null){
            int agent = Integer.parseInt(a);
            int client = Integer.parseInt(c); 
            int quantity = Integer.parseInt(fQ); 
            int personal = Integer.parseInt(pc); 
            
            order.setAgentId(agent);
            order.setClientId(client);
            order.setFlyerQty(quantity);
            order.setFlyerLayout(layout);
            order.setFlyerImg(image);
            order.setPersonalCopy(personal);
            order.setPaymentInformation(pI);
            order.setInvoiceNumber(IN);
            order.setComments(com);
            
            
            
            res = dao.addOrder(order);
        }
        return res;
    }
}
