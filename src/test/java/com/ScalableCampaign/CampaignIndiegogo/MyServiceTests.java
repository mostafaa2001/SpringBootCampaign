//package com.ScalableCampaign.CampaignIndiegogo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import com.ScalableCampaign.CampaignIndiegogo.service.MyService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@SpringBootTest
//public class MyServiceTests {
//
//    @Autowired
//    private MyService myService;
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Test
//    public void testCacheSetAndGet() {
//        // Given
//        String key = "testKey";
//        String value = "testValue";
//
//        myService.setValue(key, value);
//
//        // Then
//        String cachedValue = myService.getValue(key);
//        assertEquals(value, cachedValue);
//    }
//}
