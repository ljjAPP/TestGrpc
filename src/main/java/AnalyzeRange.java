import com.alibaba.fastjson.JSONObject;
import org.apache.log.output.net.SocketOutputTarget;

import java.util.*;

public class AnalyzeRange {
    //public static List<String> list = new ArrayList<>();
    public static Map<String,List<Integer>> map = new HashMap<>();
    public  static Map<String, List<Integer>> writeMap = new HashMap<>();
    public static void main(String[] args) {
        /*String range = "{\"Y21\":\"2\",\"Y23\":\"3\",\"D21\":\"2\",\"M300\":\"2\",\"X20\":\"2\",\"Y22\":\"6\"}";
        analyzeRange(range);
        System.out.println(map.toString());
        int offset = getOffset("Y23");
        System.out.println(offset);*/
        String type="Y";
        int begin = 21;
        int i=1;
        System.out.println(type+(begin+i));
        System.out.println(test("Y21",3));
        System.out.println(test("Y22",3));
    }
    public static void analyzeRange(String range){
        JSONObject object = JSONObject.parseObject(range);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            String type = key.substring(0,1);
            String begin = key.substring(1);
            int num = Integer.parseInt(value);
            int numBegin = Integer.parseInt(begin);
            if(map.containsKey(type)){
                for(int j=numBegin;j<numBegin+num;j++){
                    if(!map.get(type).contains(j)){
                        map.get(type).add(j);
                    }
                }
            }else{
                List<Integer> arr = new ArrayList<>();
                for(int j=numBegin;j<numBegin+num;j++){
                    arr.add(j);
                }
                map.put(type,arr);
            }
        }
        for (String key : map.keySet()) {
            //System.out.println("key= "+ key + " and value= " + map.get(key));
            Collections.sort(map.get(key));
        }
    }
    public static int getOffset(String name){
        int offset=0;
        String type = name.substring(0,1);
        String numStr = name.substring(1);
        List<Integer> list = map.get(type);
        int num = Integer.parseInt(numStr);
        int first = list.get(0);
        offset=num-first;
        if(offset>0){
            return offset;
        }else{
            return -1;
        }
    }
    private static String test(String dest, int num){
        //String dest = request.getStartDestination();
        String beginstr = dest.substring(1);
        String type = dest.substring(0,1);
        int begin = Integer.parseInt(beginstr);
        //int num = request.getDestinationNumbers();
        if(writeMap.containsKey(type)){
            for(int j=begin;j<begin+num;j++){
                if(!writeMap.get(type).contains(j)){
                    writeMap.get(type).add(j);
                }
            }
        }else{
            List<Integer> arr = new ArrayList<>();
            for(int j=begin;j<begin+num;j++){
                arr.add(j);
            }
            writeMap.put(type,arr);
        }
        for (String key : writeMap.keySet()) {
            Collections.sort(writeMap.get(key));
        }
        return writeMap.toString();
    }
}
