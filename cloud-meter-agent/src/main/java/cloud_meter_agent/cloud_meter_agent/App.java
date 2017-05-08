package cloud_meter_agent.cloud_meter_agent;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	JSONObject obj = (JSONObject)null;
        System.out.println(JSONObject.fromObject("{'message':{'param':'response'}}").get("message"));
    }
}
