package util;

import com.alibaba.fastjson.JSONObject;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {
    @Override
    public String render(Object o) throws Exception {
        return JSONObject.toJSONString(o);
    }
}
