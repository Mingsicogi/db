package mins.study.db.app.common.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static mins.study.db.app.common.constant.DbConstantCommon.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DBManageController {

    private final GenericApplicationContext context;

    @Value("${mins-db.shard.cnt}")
    private int shardTotalCnt;

    @GetMapping("/get/dbInfo")
    public ResponseEntity<String> getInfo() throws Exception {
        for (int i = 0; i < shardTotalCnt; i++) {
            DataSource bean = context.getBean(commonDatasourceBeanName + i, DataSource.class);
            EntityManagerFactory entityManagerFactory = context.getBean(commonJpaEntityManagerBeanName + i, EntityManagerFactory.class);
            PlatformTransactionManager transactionManager = context.getBean(commonTransactionManagerBeanName + i, PlatformTransactionManager.class);
            log.info("### bean : {} | entityManager : {} | transactionManager : {}", bean, entityManagerFactory, transactionManager);
        }

        return ResponseEntity.ok("OK");
    }
}
