
package services;

import dao.ClientDao;
import java.util.ArrayList;
import model.Location;

public class LocationService {
     public static int addLocation(String name,String quantity,ClientDao dao){
        int res = 0;
        Location clientObj = new Location();
        if(name!=null){
            int q = Integer.parseInt(quantity);
            clientObj.setLocationName(name);
            clientObj.setDistributionCapacity(q);
            res = dao.addLocation(clientObj);
        }
        return res;
    }
}
