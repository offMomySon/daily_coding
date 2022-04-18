import java.util.Objects;

public class TaskCreator implements Tasker{
    private final Tag tag;

    public TaskCreator(Tag tag) {
        this.tag = validate(tag);
    }

    private Tag validate(Tag tag){
        if(Objects.isNull(tag)){
            throw new RuntimeException("tag 가 null 입니다.");
        }
        return tag;
    }

    @Override
    public boolean doAction(Input input) {
        return tag.createTagIfPossible();
    }
}
