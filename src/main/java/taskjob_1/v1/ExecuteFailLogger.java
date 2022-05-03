//package taskjob_1.v1;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ExecuteFailLogger {
//    private static Map<Integer, ExecuteFail> executeFails = new HashMap<>();
//
//    public void append(int tag){
//        if(executeFails.containsKey(tag)){
//            ExecuteFail executeFail = executeFails.get(tag);
//            executeFail.increase();
//
//            executeFails.put(tag,executeFail);
//        }else{
//            executeFails.put(tag, new ExecuteFail(tag));
//        }
//    }
//
//    public Map<Integer, ExecuteFail> getExecuteFails(){
//        return Collections.unmodifiableMap(executeFails);
//    }
//}
