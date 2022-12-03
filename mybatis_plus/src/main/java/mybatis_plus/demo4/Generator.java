package mybatis_plus.demo4;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

public class Generator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();

        DataSourceConfig datasource = new DataSourceConfig();
        datasource.setDriverName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/mybatis?useSSL=false");
        datasource.setUsername("root");
        datasource.setPassword("qaz050212");
        autoGenerator.setDataSource(datasource);
        autoGenerator.execute();
    }
}
