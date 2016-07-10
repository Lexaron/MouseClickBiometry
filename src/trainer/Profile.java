/*
 *  Project name: Biometrija_Klika_DIPLOMSKI/Profile.java
 *  Author & email: Mirza Suljić <mirza.suljic.ba@gmail.com>
 *  Date & time: Mar 14, 2016, 8:45:28 PM
 */
package trainer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mirza Suljić <mirza.suljic.ba@gmail.com>
 */
public class Profile implements Serializable {

    private final String name;
    private final String path;
    private final List<Integer> events = new ArrayList();
    private final ArrayList<Long> clickDurations = new ArrayList();
    private final ArrayList<Long> eventLog = new ArrayList();

    // Construct
    public Profile(String name, String path) {
        this.name = name;  
        this.path = path;
    }
    
    // Get    
    public ArrayList<Long> getClickDurations() {
        return clickDurations;
    }   

    public List<Integer> getEvents() {
        return events;
    }

    public ArrayList<Long> getEventLog() {
        return eventLog;
    }
    
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }    

    // Override
    @Override
    public String toString() {
        return name;
    } 
    
}
