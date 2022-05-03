package taskjob_1.v2.aggregate;


/**
 * 역할 fail 에 대한 counting 역할.
 *
 * 1. 0 부터 시작하는 것을 강제한다.
 * 2. increase 연산만 가능하다.
 */
public class CreateFailCounter {
    private int count;

    public CreateFailCounter() {
        this.count = 0;
    }

    public void increase(){
        count += 1;
    }

    public int getCount() {
        return count;
    }
}
