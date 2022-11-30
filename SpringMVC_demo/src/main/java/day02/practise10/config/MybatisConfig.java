//package day02.practise10.config;
//
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//
//import javax.sql.DataSource;
//
//public class MybatisConfig {
//
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setTypeAliasesPackage("day02.practise10.pojo");
//        factoryBean.setDataSource(dataSource);
//        return factoryBean;
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer msc = new MapperScannerConfigurer();
//        msc.setBasePackage("day02.practise10.mapper");
//        return msc;
//
//    }
//}
