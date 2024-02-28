package org.example.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.example.components")
public class MyConf {

    // 커넥션 풀 생성 // 풀 -> 여러개 연결해놓고 사용하는것.
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        BasicDataSource bds = new BasicDataSource();
        bds.setInitialSize(10); // db 생성할때 몇개의 커넥션을 물고 생성한다.
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://192.168.0.38/ygy");
        bds.setUsername("root");
        bds.setPassword("1234");
        return bds;
    }
    //  sql mapper 문장을, sql 공장을 만들어나가는 것.
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:sql/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
    //sql 문장 사용하는 객체이다.
    @Bean
    public SqlSession sqlSession() throws Exception{
        return new SqlSessionTemplate(sqlSessionFactoryBean());
    }
}
