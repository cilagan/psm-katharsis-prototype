package gov.nsf.research.psm.storedprocedure;

import gov.nsf.research.psm.storedprocedure.mapper.DivisionMapper;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllDivisions extends StoredProcedure {

	public static final String STORED_PROC_GET_ALL_DIVISIONS_LIST = "flp.pr_psm_all_div";
	public static final String RESULT_SET = "Division";
	

	public SPGetAllDivisions() {
		super();
	}

	public SPGetAllDivisions(DataSource dataSource, String storedProcName) {
		super(dataSource, storedProcName);

		declareParameter(new SqlReturnResultSet(RESULT_SET,
				new DivisionMapper()));
		

		compile();
	}

	public SPGetAllDivisions(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
	}

	public final Map<String, Object> execute() {
		
		Map<String, Object> results = super.execute();

		return results;
	}

}
