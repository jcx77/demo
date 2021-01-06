package com.file.fileupload.vo;



//@Configuration
//@MapperScan(basePackages = "com.file.fileupload.**.mapper")
public class DataSourceConfig {
//	@Value("${spring.datasource.url}")
//	private String url;
//	@Value("${spring.datasource.username}")
//	private String username;
//	@Value("${spring.datasource.password}")
//	private String password;
//
//	@Bean
//	public DataSource dataSource() {
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName("jdbc:mysql:");
//		dataSource.setJdbcUrl(url);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		dataSource.setMinimumIdle(5);
//		dataSource.setMaximumPoolSize(20);
//		dataSource.setAutoCommit(false);
//		dataSource.setIdleTimeout(5 * 60 * 1000);
//		dataSource.setMaxLifetime(20 * 60 * 1000);
//		dataSource.setConnectionTimeout(20 * 1000);
//		return dataSource;
//	}
//
//	@Bean
//	public ResourcePatternResolver resourcePatternResolver() {
//		return new PathMatchingResourcePatternResolver();
//	}
//
//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, ResourcePatternResolver resourcePatternResolver) throws IOException {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		sqlSessionFactoryBean.setConfigLocation(resourcePatternResolver.getResource("classpath:mybatis-config.xml"));
//		sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:com/file/fileupload/**/mapper/**/mysql/*.xml"));
//		//sqlSessionFactoryBean.setPlugins(new Interceptor[] { new AuditPlugin() });
//		return sqlSessionFactoryBean;
//	}
}