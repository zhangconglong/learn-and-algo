//package 算法.哈希;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class LRUCache {
//    int capacity = 0;
//    List<Integer, Integer> map; // 创建hashMap
//
//    public LRUCache(int capacity) {
//        if(capacity>=1){
//            this.capacity = capacity;
//            //创建hashMap
//            map = new HashMap(capacity);
//        }
//    }
//
//    //存在于缓存中，则返回关键字的值，
//    //             否则返回 -1 。
//    public int get(int key) {
//        if (map.get(key)!=null){
//            return map.get(key);
//        }
//        return -1;
//    }
//
//    // 已经存在，则变更其数据值 value ；
//    // 如果不存在，则向缓存中插入该组
//    public void put(int key, int value) {
//        if (get(key)!=-1) {//修改操作
//            map.put(key, value);
//        }
//        if(map.size()==this.capacity){//新增操作，但是满了
//
//        }
//        map.put(key, value);
//    }
//}
