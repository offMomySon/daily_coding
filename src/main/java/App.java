public class App {
    private static final String[] INPUT1 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2"
    };

    private static final String[] INPUT2 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create"
    };

    private static final String[] INPUT3 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "execute 11",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2",
        "create",
        "execute 2",
        "execute 11",
        "execute 2",
        "execute 5",
        "execute 5",
        "execute 2",
        "execute 5",
        "execute 5"
    };

    private static final Task task = new Task();

    private static final CreateFailCounter createFailCount = new CreateFailCounter();
    private static final ExecuteFailResult executeFailResult = new ExecuteFailResult();

    private static final ResultMessage resultMessage = new ResultMessage();

    public static void main(String[] args) {
        for (int i = 0; i < INPUT3.length; i++) {
            String s = INPUT3[i];
            String[] input = s.split(" ");

            Cmd cmd = Cmd.from(input[0]);

            if(cmd.isCreate()){
                boolean created = task.create();

                if(!created){
                    createFailCount.increase();
                }
            }else if(cmd.isExecute()){
                int tag = Integer.parseInt(input[1]);

                boolean success = task.execute(tag);

                if(!success){
                    executeFailResult.append(tag);
                }
            }
        }

        resultMessage.printUsableTag(task.getTag().getUsableTags());
        resultMessage.printCreateFail(createFailCount.getCount());
        resultMessage.printExecuteFails(executeFailResult.getExecuteFails());
    }
}
