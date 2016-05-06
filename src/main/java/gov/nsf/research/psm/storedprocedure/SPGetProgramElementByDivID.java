package gov.nsf.research.psm.storedprocedure;

import gov.nsf.research.psm.storedprocedure.mapper.ProgramElementCodeMapper;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetProgramElementByDivID extends StoredProcedure {

	public static final String STORED_PROC_GET_PROGRAMELEMENT_LIST_BY_DIV_CODE = "flp.pr_psm_sel_pgm_ele";
	public static final String RESULT_SET = "ProgramElement";
	private static final String IN_DIV_CODE = "divCode";

	public SPGetProgramElementByDivID() {
		super();
	}

	public SPGetProgramElementByDivID(DataSource dataSource, String storedProcName) {
		super(dataSource, storedProcName);

		declareParameter(new SqlReturnResultSet(RESULT_SET,
				new ProgramElementCodeMapper()));
	
		declareParameter(new SqlParameter(SPGetProgramElementByDivID.IN_DIV_CODE,
				Types.VARCHAR));

		compile();
	}

	public SPGetProgramElementByDivID(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
	}

	public final Map<String, Object> execute(String divisionCode) {
		Map<String, Object> inParams = new HashMap<String, Object>();

		
		inParams.put(SPGetProgramElementByDivID.IN_DIV_CODE, divisionCode);

		Map<String, Object> results = super.execute(inParams);

		return results;
	}


}
