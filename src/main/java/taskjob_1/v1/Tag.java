//package taskjob_1.v1;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class Tag {
//    private static final int LIMIT = 9;
//    private static final boolean[] usingTag = new boolean[LIMIT+1];
//
//    public boolean createTagIfPossible(){
//        for (int i = 1; i <= LIMIT; i++) {
//            if(usingTag[i] == false){
//                usingTag[i] = true;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean deleteTag(int tag){
//        if(tag > LIMIT){
//            return false;
//        }
//        if(!usingTag[tag]){
//            return false;
//        }
//
//        usingTag[tag] = false;
//
//        return true;
//    }
//
//    public List<Integer> getUsableTags(){
//        List<Integer> usableList = new LinkedList<>();
//
//        for(int i =1 ; i<=LIMIT; i++){
//            if(!usingTag[i]){
//                usableList.add(i);
//            }
//        }
//
//        return usableList;
//    }
//}
