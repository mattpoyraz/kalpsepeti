/*package allData;

import io.restassured.mapper.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class dataReader {

    public List<HashMap<String,String>> getJsonDataToMap() throws IOException {

        String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+
                "src//test//java//allData//PurchaseOrder.json"));

        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String,String>>data=mapper.getJsonDataToMap())
        return data;
    }
    }


 */






