package taskjob_1;

import java.util.Objects;

public class TaskExecutor {
    private final ExecuteFailLogger executeFailLogger;
    private final Tag tag;

    public TaskExecutor(ExecuteFailLogger executeFailLogger, Tag tag) {
        this.executeFailLogger = executeFailLogger;
        this.tag = validate(tag);
    }

    private Tag validate(Tag tag){
        if(Objects.isNull(tag)){
            throw new RuntimeException("tag 가 null 입니다.");
        }
        return tag;
    }

    public void execute(int tagNum) {
        boolean deleted = tag.deleteTag(tagNum);
        if(!deleted){
            executeFailLogger.append(tagNum);
        }
    }
}
