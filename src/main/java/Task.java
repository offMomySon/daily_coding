import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Task {
    private static final Tag tag = new Tag();
    private static final int LIMIT = 9;
    private static final boolean[] usingTag = new boolean[LIMIT+1];

    public boolean create(){
        return tag.setTagIfPossible();
    }

    public boolean execute(int tagNum){
        return tag.deleteTag(tagNum);
    }

    public Tag getTag(){
        return tag;
    }
}
