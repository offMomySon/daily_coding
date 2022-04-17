import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExecuteFailTest {

    @Test
    void test1(){
        Set<ExecuteFail> executeFails = new HashSet<>();
        executeFails.add(new ExecuteFail(10));

        if(executeFails.contains(new ExecuteFail(10))){
            System.out.println("contain");
        }else{
            System.out.println("not contain.");
        }


    }


    @Test
    void test2(){
        Set<ExecuteFail> executeFails = new HashSet<>();
        executeFails.add(new ExecuteFail(5, 3));
        executeFails.add(new ExecuteFail(2, 2));
        executeFails.add(new ExecuteFail(11, 2));

        LinkedList<ExecuteFail> list = new LinkedList<>(executeFails);
        Collections.sort(list);

        for(ExecuteFail e : list){
            System.out.println(e);
        }
    }

}