//package taskjob_1.v1;
//
//import java.util.Arrays;
//import org.apache.commons.lang3.StringUtils;
//
//public enum Cmd {
//    CREATE("create"), EXECUTE("execute");
//
//    private final String value;
//
//    Cmd(String value) {
//        this.value = value;
//    }
//
//    public static Cmd from(String cmd){
//        return Arrays.stream(Cmd.values())
//            .filter(it -> StringUtils.equals(it.value, cmd))
//            .findFirst()
//            .orElseThrow(()-> new RuntimeException("일치하는 명령어가 없습니다."));
//    }
//
//    public boolean isCreate(){
//        return this == CREATE;
//    }
//
//    public boolean isExecute(){
//        return this == EXECUTE;
//    }
//}
