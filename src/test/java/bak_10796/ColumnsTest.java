package bak_10796;

import org.junit.jupiter.api.Test;

class ColumnsTest {

        @Test
        void test1(){
            Row row = Row.of("test");
            Columns columns = new Columns();

            columns.add(row);

            System.out.println(columns);
        }

}