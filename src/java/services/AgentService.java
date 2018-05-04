package services;

import dao.ClientDao;
import java.sql.SQLException;
import model.Agent;

public class AgentService {
    public static int addAgent(String name,String lastname,String phone,String email,String username,String password,ClientDao dao){
        int res = 0;
        Agent agentObj = new Agent();
        if(name!=null){
            
            agentObj.setFname(name);
            agentObj.setLname(lastname);
            agentObj.setPhoneNo(phone);
            agentObj.setEmail(email);
            agentObj.setUserName(username);
            agentObj.setPassword(password);
            
            res = dao.addAgent(agentObj);
        }
        return res;
    }
    
   
}

       