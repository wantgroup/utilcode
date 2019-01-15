package code;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;


public class GetCode {
	  //设置APPID/AK/SK
    public static final String APP_ID = "14809450";
    public static final String API_KEY = "Qk3iML26p5l6e2amVGt5MUp8";
    public static final String SECRET_KEY = "eRnidVH4PQCys0WgP3hM9pdtDZ2lghz1";
    
    static String getCode(String fileName) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        // 调用接口
        String path = fileName;
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        JSONArray array=res.getJSONArray("words_result");
        
        JSONObject jsonwords = array.getJSONObject(0);
        
        String words = jsonwords.getString("words");
        return words;       
    }

}
