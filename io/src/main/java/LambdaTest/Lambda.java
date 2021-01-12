package LambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lambda {


    public List<Map<String, Object>> addData(){
        List<Map<String, Object>> oldlist = new ArrayList<Map<String,Object>>();
        Map<String, Object> map =new HashMap<String, Object>();
        map.put("id",1);
        map.put("qid","a");
        oldlist.add(map);

        return oldlist;
    }
    @Test
    public void save() {
        List<Map<String, Object>> oldlist = addData();
        Map<String, Object> allmap = new HashMap<String, Object>();

        // 获取旧值
        if (oldlist.size() > 0) {
            for (Map<String, Object> map : oldlist) {
                if (map != null) {
                    allmap.put((String) map.get("id"), map.get("qid"));
                }
            }
        }

        Map<String, Object> newmap = new HashMap<String, Object>();
        newmap.put("1","");
        newmap.put("2","");
        newmap.put("3","");
        // 交集数组
        List<String> intersectionList = new ArrayList<String>();
        for (String key : newmap.keySet()) {
            if (allmap.containsKey(key)) {
                intersectionList.add(key);
            }
        }


//        // 查找新增值
//        for (String s : newmap.keySet()) {
//            if (!intersectionList.contains(s)) {
//                dao.intsertQsqk(UUIDHelper.get32UUID(), id, s);
//            }
//        }
//        // 查找删除增值
//        for (String key : allmap.keySet()) {
//            if (!intersectionList.contains(key)) {
//                dao.updateQsqk((String) allmap.get(key));
//            }
//        }

    }
}
