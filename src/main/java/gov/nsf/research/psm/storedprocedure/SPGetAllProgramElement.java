package gov.nsf.research.psm.storedprocedure;

import gov.nsf.research.psm.storedprocedure.mapper.ProgramElementMapper;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllProgramElement extends StoredProcedure {

	public static final String STORED_PROC_GET_ALL_PROGRAMELEMENT_LIST = "flp.pr_psm_all_pgm_ele";
	public static final String RESULT_SET = "ProgramElement";
	

	public SPGetAllProgramElement() {
		super();
	}

	public SPGetAllProgramElement(DataSource dataSource, String storedProcName) {
		super(dataSource, storedProcName);

		declareParameter(new SqlReturnResultSet(RESULT_SET,
				new ProgramElementMapper()));
	
	

		compile();
	}

	public SPGetAllProgramElement(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
	}

	public final Map<String, Object> execute() {
	

		Map<String, Object> results = super.execute();

		return results;
	}


}
