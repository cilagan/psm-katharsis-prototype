package gov.nsf.research.psm.storedprocedure;

import gov.nsf.research.psm.storedprocedure.mapper.FundingOpportunityMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import java.util.Map;

import javax.sql.DataSource;

public class SPGetAllFundingOpportunities extends StoredProcedure {

	public static final String STORED_PROC_GET_FUND_OPPORTUNITY = "flp.pr_psm_sel_fund_oppr";
	//public static final String STORED_PROC_GET_FUND_OPPORTUNITY = "flp.pr_psm_sel_fund_oppr_new";
	public static final String RESULT_SET = "FundingOpportunity";

	public SPGetAllFundingOpportunities() {
		super();
	}

	public SPGetAllFundingOpportunities(DataSource dataSource,
			String storedProcName) {
		super(dataSource, storedProcName);

		declareParameter(new SqlReturnResultSet(RESULT_SET,
				new FundingOpportunityMapper()));

		compile();
	}

	public SPGetAllFundingOpportunities(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
	}

	public final Map<String, Object> execute() {

		Map<String, Object> results = super.execute();

		return results;
	}

}
