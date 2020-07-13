package mins.study.db.app.common.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBUtil {

    @Value("${mins-db.shard.cnt}")
    private int shardDbCnt;

    public synchronized String generateId() {
        long currentTime = System.currentTimeMillis();
        long shardNo = currentTime % shardDbCnt;
        String randomNumeric = RandomStringUtils.randomNumeric(2);

        return currentTime + randomNumeric + shardNo;
    }
}
