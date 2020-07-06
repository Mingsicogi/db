package mins.study.db;

import lombok.RequiredArgsConstructor;
import mins.study.db.config.DBConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DBManageController {

    private final DBConfiguration dbConfiguration;

    @GetMapping("/get/dbInfo")
    public ResponseEntity<String> getInfo() throws Exception{
        dbConfiguration.dataSourceCheck();
        return ResponseEntity.ok("OK");
    }
}
