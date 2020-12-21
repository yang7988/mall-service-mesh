package com.example.mall.storage;

import com.example.mall.storage.entity.Storage;
import com.example.mall.storage.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallStorageServiceApplicationTests {

    @Autowired
    private StorageService storageService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testStorage() {
        Storage storage = new Storage();
        storage.setCommodityCode("123kjhi");
        storage.setName("iphone11");
        storage.setCount(100);
        storage.setVersion(1);
        storageService.save(storage);

    }
}
