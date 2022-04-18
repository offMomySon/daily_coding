public class Task {
    private static final Tag tag = new Tag();
    private static final int LIMIT = 9;
    private static final boolean[] usingTag = new boolean[LIMIT+1];

    public boolean create(){
        return tag.createTagIfPossible();
    }

    public boolean execute(int tagNum){
        return tag.deleteTag(tagNum);
    }

    public Tag getTag(){
        return tag;
    }
}
