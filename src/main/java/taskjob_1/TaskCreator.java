package taskjob_1;

import java.util.Objects;

public class TaskCreator {
    private final CreateFailCounter createFailCounter;
    private final Tag tag;

    public TaskCreator(CreateFailCounter createFailCounter, Tag tag) {
        this.createFailCounter = createFailCounter;
        this.tag = validate(tag);
    }

    private Tag validate(Tag tag){
        if(Objects.isNull(tag)){
            throw new RuntimeException("tag 가 null 입니다.");
        }
        return tag;
    }

    public void create() {
        boolean created = tag.createTagIfPossible();

        if(!created){
            createFailCounter.increase();
        }
    }
}
