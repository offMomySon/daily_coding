package taskjob_2;

import java.util.List;

public class App {
    private static final String[] testCmdSheet1= {
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2"
    };

    public static void main(String[] args) {
        TreeTaskPool usablePool = TreeTaskPool.of(Task.defaultSystemTasks());
        HashTaskPool executePool = new HashTaskPool();

        for(String sCmd : testCmdSheet1){
            String[] splitCmd = sCmd.split(" ");

            Cmd cmd = Cmd.find(splitCmd[0]).orElseThrow(() -> new RuntimeException("일치하는 cmd 가 없습니다."));

            if(cmd == Cmd.CREATE){
                Task task = usablePool.pull();
                executePool.add(task);
                break;
            }

            if( cmd == Cmd.EXECUTE){
                Task task = Task.of(splitCmd[1]);
                executePool.remove(task);
                usablePool.add(task);
                break;
            }

        }

    }
}
