package gov.nsf.research.psm.config;


import gov.nsf.research.psm.ProposalManagementKatharsisServiceApplication;
//import gov.nsf.research.psm.ProposalManagementServiceApplication;
import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.dao.impl.ProposalDaoImpl;
import gov.nsf.research.psm.service.ProposalManagementService;
import gov.nsf.research.psm.service.impl.ProposalManagementServiceImpl;
//import io.katharsis.spring.boot.JacksonConfiguration;
import io.katharsis.spring.boot.JsonLocatorConfiguration;
import io.katharsis.spring.boot.KatharsisConfigV2;
import io.katharsis.spring.boot.KatharsisRegistryConfiguration;
import io.katharsis.spring.boot.QueryParamsBuilderConfiguration;
import io.katharsis.spring.boot.RequestDispatcherConfiguration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
//@ImportResource("classpath:nr-business-context.xml")


public class AppConfig {


		
	@Bean
	public ProposalManagementKatharsisServiceApplication proposalManagementKatharsisServiceApplication(){
		return new ProposalManagementKatharsisServiceApplication();
	}
	
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.sybase.jdbc3.jdbc.SybDriver");
        dataSource.setUrl("jdbc:sybase:Tds:fldevel15.nsf.gov:5000/fldb");
        dataSource.setUsername("flpupd");
        dataSource.setPassword("k2,OnivH");
         
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate psmFLJdbcTemplate(){
    	return new JdbcTemplate(getDataSource());
    }
    
    @Bean
    public ProposalDao proposalDao(){
    	return new ProposalDaoImpl();
    }
	
	@Bean
	public ProposalManagementService ProposalManagementService(){
		return new ProposalManagementServiceImpl();
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	
}