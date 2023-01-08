//package springboot_dev.day06;
//
//
//import com.alibaba.fastjson.JSON;
//import org.apache.http.HttpHost;
//import org.elasticsearch.action.bulk.BulkRequest;
//import org.elasticsearch.action.get.GetRequest;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.indices.CreateIndexRequest;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import springboot_dev.day06.mapper.BookMapper;
//import springboot_dev.day06.pojo.Book;
//
//import java.io.IOException;
//import java.util.List;
//
//
//@SpringBootTest
//public class ES {
//
//    @Autowired
//    private BookMapper bookMapper;
//
////    低级别
////    @Autowired
////     private ElasticsearchRestTemplate template;
//
//    private RestHighLevelClient client;
//
//
//    @BeforeEach
//    void setUp() {
//        HttpHost host = HttpHost.create("http://localhost:9200");
//        RestClientBuilder builder = RestClient.builder(host);
//        client = new RestHighLevelClient(builder);
//    }
//
//    @AfterEach
//    void tearDown() throws IOException {
//
//        client.close();
//    }
//
//    @Test
//    void testCreateIndex() throws IOException {
//        CreateIndexRequest request = new CreateIndexRequest("books");
//        client.indices().create(request, RequestOptions.DEFAULT);
//
//    }
//
//    @Test
//    void testCreateIndexByIk() throws IOException {
//        CreateIndexRequest request = new CreateIndexRequest("books");
//
////        设置请求参数
//        String json = "{\n" +
//                "     \"mappings\":{\n" +
//                "        \"properties\":{\n" +
//                "            \"id\":{\n" +
//                "                \"type\":\"keyword\"\n" +
//                "            },\n" +
//                "            \"name\":{\n" +
//                "                \"type\":\"text\",\n" +
//                "                \"analyzer\":\"ik_max_word\",\n" +
//                "                \"copy_to\":\"all\"\n" +
//                "            },\n" +
//                "             \"type\":{\n" +
//                "                \"type\":\"keyword\"\n" +
//                "            },\n" +
//                "             \"description\":{\n" +
//                "                \"type\":\"text\",\n" +
//                "                \"analyzer\":\"ik_max_word\",\n" +
//                "                \"copy_to\":\"all\"\n" +
//                "            },\n" +
//                "              \"all\":{\n" +
//                "                \"type\":\"text\",\n" +
//                "                \"analyzer\":\"ik_max_word\"\n" +
//                "            }\n" +
//                "        }\n" +
//                "     }\n" +
//                "}";
//
//        request.source(json, XContentType.JSON);
//        client.indices().create(request, RequestOptions.DEFAULT);
//    }
//
//    //    添加文档
//    @Test
//    void testCreateDoc() throws IOException {
//
//        Book book = bookMapper.selectById(1);
//        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
//        String json = JSON.toJSONString(book);
//
//        request.source(json, XContentType.JSON);
//        client.index(request, RequestOptions.DEFAULT);
//    }
//
//    //    添加全部文档
//    @Test
//    void testCreateDocAll() throws IOException {
//
//        List<Book> books = bookMapper.selectList(null);
//
//
////        client.index(request,RequestOptions.DEFAULT);
//        BulkRequest bulk = new BulkRequest();
//        for (Book book :books){
//            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
//            String json = JSON.toJSONString(book);
//            request.source(json, XContentType.JSON);
//            bulk.add(request);
//        }
//        client.bulk(bulk, RequestOptions.DEFAULT);
//    }
//
//    @Test
////    按id查询
//    void testGet() throws IOException {
//        GetRequest request = new GetRequest("books","1");
//        GetResponse response = client.get(request, RequestOptions.DEFAULT);
//        String json = response.getSourceAsString();
//        System.out.println(json);
//    }
//
//    @Test
////    按条件查询
//    void testSearch() throws IOException {
//
//        SearchRequest request = new SearchRequest("books");
//
//        SearchSourceBuilder builder  = new SearchSourceBuilder();
//        builder.query(QueryBuilders.termQuery("name","java"));
//        request.source(builder);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        for (SearchHit hit :hits){
//            String source = hit.getSourceAsString();
//            Book book = JSON.parseObject(source, Book.class);
//            System.out.println(book);
//        }
//    }
//}
