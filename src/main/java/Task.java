import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Task {
    private static final int LIMIT = 9;
    private static final boolean[] usingTag = new boolean[LIMIT+1];

    public boolean create(){
        boolean isCreated = false;

        for (int i = 1; i <= LIMIT; i++) {
            if(usingTag[i] == false){
                usingTag[i] = true;
                isCreated = true;
                break;
            }
        }

        return isCreated;
    }

    public boolean execute(int tag){
        if(tag > LIMIT){
            return false;
        }
        if(!usingTag[tag]){
            return false;
        }

        usingTag[tag] = false;

        return true;
    }

    public List<Integer> getUsableTags(){
        List<Integer> usableList = new LinkedList<>();
        
        for(int i =1 ; i<=LIMIT; i++){
            if(!usingTag[i]){
                usableList.add(i);
            }
        }

        return usableList;
    }
}
