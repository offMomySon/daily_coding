package taskjob_1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultMessage {
    private static final String usableTagFormat = "사용가능한 taskjob_1.Tag : %s";
    private static final String createFailFormat = "TASK 생성 실패: %d";
    private static final String executeFailFormat = "TASK 수행 실패한 태그: %s";

    public void printUsableTag(List<Integer> usableList){
        System.out.println(String.format(usableTagFormat, usableList.stream().map(it-> Integer.toString(it)).collect(Collectors.joining(" "))));
    }

    public void printCreateFail(int createFailCount){
        System.out.println(String.format(createFailFormat, createFailCount));
    }

    public void printExecuteFails(Map<Integer, ExecuteFail> executeFails){
        String collect = executeFails.values().stream().sorted().map(it -> it.getNum() + "(" + it.getCount() + ")").collect(Collectors.joining(" "));
        System.out.println(String.format(executeFailFormat,collect));
    }
}
