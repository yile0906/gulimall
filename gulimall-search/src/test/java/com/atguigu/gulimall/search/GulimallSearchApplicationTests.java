package com.atguigu.gulimall.search;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 整合elasticsearch测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallSearchApplicationTests {

    @Autowired
    RestHighLevelClient esClient;

    @Test
    public void contextLoads() {
        System.out.println(esClient);
    }

    /**
     * 测试elasticsearch保存数据
     * @throws IOException
     */
    @Test
    public void testEsIndex() throws IOException {
        IndexRequest request = new IndexRequest("post");
        
        User user = new User();
        user.setName("法外狂徒张三");
        user.setAge(26);
        String jsonString = JSON.toJSONString(user);

        request.id("1").source(jsonString, XContentType.JSON);
        System.out.println(request.toString());

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    /**
     *查询数据
     */
    @Test
    public void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("bank");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.size(10);
        System.out.println(searchSourceBuilder.toString());
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit source:hits1){
            Account account = JSONObject.parseObject(source.getSourceAsString(),Account.class);
            System.out.println(account);
        }
    }



    @Data
    class User{
        private String name;
        private Integer age;
    }


    @ToString
    @Data
    static class Account {
        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;
    }
}
