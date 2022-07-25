package com.learnSpringMVC.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = ("com.learnSpringMVC/repository"))// sử dụng được JpaRepository thì cần khai báo cái này
@EnableTransactionManagement //bật được tính năng tự động quản lý(đóng mở đối tượng) Transaction cho JPA
public class JPAConfig {

    // dùng để cài đặt cho EntityManagerFactory(EntityManagerFactory giống như nhà máy sản xuất ra EntityManager) và khi tạo entityManager
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());// dataSource là nơi cung cấp thông tin của db như driverName,url,user,password
        em.setPersistenceUnitName("persistence-data");//file persistence-data ở đây giúp cho việc kết nối và mapping các entity class với các bảng trong db(file này nằm trong /resources/META-INF)
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties()); // bật tính năng tự động tạo các bảng trong db từ java entity class
        return em;
    }

    //dùng để khởi tạo(tự động bật tính năng)  EntityTransaction cho nhiệm vụ commit(),rollback();
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    //dùng để getConnection và openConnection giống nhưu trong JDBC
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/website_bao_chi");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        return dataSource;
    }

    //bật tính năng tự động tạo các bảng trong db từ java entity class
    Properties additionalProperties() {
        Properties properties = new Properties();
        //tự động tạo các bảng trong db thông qua entityclass
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");// tạo db từ những class entity khi chưa có gì trong db,khi có db rồi thì cần đóng ở đây lại
        //properties.setProperty("hibernate.hbm2ddl.auto", "create");// tạo db từ những class entity khi chưa có gì trong db,khi có db rồi thì cần đóng ở đây lại
        //properties.setProperty("hibernate.hbm2ddl.auto", "none"); //khi có data rồi thì không được sử dụng lệnh trên, vì sẽ drop hết db
        return properties;
    }

}

