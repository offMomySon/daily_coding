import lombok.NonNull;

public class Input {
    private final Cmd cmd;
    private final int tagNum;

    private Input(@NonNull Cmd cmd, int tagNum) {
        this.cmd = cmd;
        this.tagNum = tagNum;
    }

    public static Input from(String input){
        String[] s = input.split(" ");

        Cmd cmd = Cmd.from(s[0]);
        int tagNum = 0;

        if(cmd.isExecute()){
            tagNum = Integer.parseInt(s[1]);
        }

        return new Input(cmd, tagNum);
    }

    public Cmd getCmd() {
        return cmd;
    }

    public int getTagNum() {
        return tagNum;
    }
}
