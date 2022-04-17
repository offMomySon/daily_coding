import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class App {
    private static final String[] INPUT1 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2"
    };

    private static final String[] INPUT2 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create"
    };

    private static final String[] INPUT3 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "execute 11",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2",
        "create",
        "execute 2",
        "execute 11",
        "execute 2",
        "execute 5",
        "execute 5",
        "execute 2",
        "execute 5",
        "execute 5"
    };

    private static int createFailCount = 0;

    private static final Task task = new Task();
    private static final ExecuteFailResult executeFailResult = new ExecuteFailResult();
    private static final ResultMessage resultMessage = new ResultMessage();

    public static void main(String[] args) {

        for (int i = 0; i < INPUT3.length; i++) {
            String s = INPUT3[i];
            String[] s1 = s.split(" ");

            if(s1[0].equals("create")){
                boolean created = task.create();

                if(created == false){
                    createFailCount+=1;
                }
            }else if(s1[0].equals("execute")){
                int tag = Integer.parseInt(s1[1]);

                boolean success = task.execute(tag);

                if(!success){
                    executeFailResult.append(tag);
                }
            }
        }

        resultMessage.printUsableTag(task.getUsableTags());
        resultMessage.printCreateFail(createFailCount);
        resultMessage.printExecuteFails(executeFailResult.getExecuteFails());
    }
}
