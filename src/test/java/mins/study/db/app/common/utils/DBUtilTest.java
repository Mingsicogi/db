package mins.study.db.app.common.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DBUtilTest {

    @Autowired
    DBUtil dbUtil;

    @Test
    void generateId() {
        System.out.println(dbUtil.generateId());
    }
}