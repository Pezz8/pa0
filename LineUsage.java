package pa0;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LineUsage {
    // Variables here

    private HashMap<String, Integer> userUsage = new HashMap<>();

    // Constructor
    public LineUsage(){
    }

    // add one sighting of a user on this line
    public void addObservation(String username){
        if(this.userUsage.containsKey(username)){
            Integer count = this.userUsage.get(username) + 1;
            this.userUsage.put(username,count);
        }
        else{
            this.userUsage.put(username, 1);
        }
    }

    // find the user with the most sighting on this line
    public Usage findMaxUsage(){
        Usage user = new Usage("NONE", 0);
        Integer maxCount = 0;
          for (Map.Entry mapElement : this.userUsage.entrySet()) {
                if ((int) mapElement.getValue() > maxCount) {
                    maxCount = (int) mapElement.getValue();
                    user.setUser((String) mapElement.getKey());
                    user.setCount(maxCount);
                }
            }
        return user;
    }
}
