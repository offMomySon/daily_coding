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

    private static final int LIMIT = 9;
    private static final boolean[] isUsing = new boolean[LIMIT+1];
    private static int createFailCount = 0;

    private static List<Integer> fails = new LinkedList<>();

    private static Map<Integer, ExecuteFail> executeFails = new HashMap<>();

    private static final String usableTagFormat = "사용가능한 Tag : %s";
    private static final String createFailFormat = "TASK 생성 실패: %d";
    private static final String executeFailFormat = "TASK 수행 실패한 태그: %s";

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < INPUT3.length; i++) {
            String s = INPUT3[i];
            String[] s1 = s.split(" ");

            if(s1[0].equals("create")){
                boolean created = false;

                for (int j = 1; j <= 9; j++) {
                    if(!isUsing[j]){
                        isUsing[j] = true;
                        created = true;
                        break;
                    }
                }

                if(created == false){
                    createFailCount+=1;
                }
            }else if(s1[0].equals("execute")){
                int target = Integer.parseInt(s1[1]);

                if(target> LIMIT || !isUsing[target]){
                    if(executeFails.containsKey(target)){
                        ExecuteFail executeFail = executeFails.get(target);
                        executeFail.increase();

                        executeFails.put(target,executeFail );
                    }else{
                        executeFails.put(target, new ExecuteFail(target));
                    }
                }else{
                    isUsing[target] = false;
                }
            }
        }

        List<Integer> usableList = new LinkedList<>();
        for(int i =1 ; i<=LIMIT; i++){
            if(isUsing[i] == false){
                usableList.add(i);
            }
        }
        System.out.println(String.format(usableTagFormat, usableList.stream().map(it-> Integer.toString(it)).collect(Collectors.joining(" "))));
        System.out.println(String.format(createFailFormat, createFailCount));

        String collect = executeFails.values().stream().sorted().map(it -> it.getNum() + "(" + it.getCount() + ")").collect(Collectors.joining(" "));
        System.out.println(String.format(executeFailFormat,collect));
    }
}
