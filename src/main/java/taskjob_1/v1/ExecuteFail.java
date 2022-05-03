//package taskjob_1.v1;
//
//public class ExecuteFail implements Comparable<ExecuteFail>{
//    private final int num;
//    private int count = 1;
//
//
//    public ExecuteFail(int num, int count){
//        this.num = num;
//        this.count = count;
//    }
//    public ExecuteFail(int num) {
//        this.num = num;
//    }
//    public void increase(){
//        count+=1;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    @Override
//    public int compareTo(ExecuteFail o) {
//        if(this.count > o.count ){
//            return -1;
//        }
//        if(this.count < o.count){
//            return 1;
//        }
//
//        return this.num - o.num;
//    }
//
//    @Override
//    public String toString() {
//        return "taskjob_1.ExecuteFail{" +
//            "num=" + num +
//            ", count=" + count +
//            '}';
//    }
//}
