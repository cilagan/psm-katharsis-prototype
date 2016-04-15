package gov.nsf.research.psm.storedprocedure;


import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import gov.nsf.research.psm.storedprocedure.mapper.DirectorateMapper;

public class SPGetAllDirectorates extends StoredProcedure {

	public static final String STORED_PROC_GET_ALL_DIRECTORATES = "flp.pr_psm_get_all_drct";
	public static final String RESULT_SET = "Directorate";

	public SPGetAllDirectorates() {
		super();
	}

	public SPGetAllDirectorates(DataSource dataSource,
			String storedProcName) {
		super(dataSource, storedProcName);

		declareParameter(new SqlReturnResultSet(RESULT_SET,
				new DirectorateMapper()));

		compile();
	}

	public SPGetAllDirectorates(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
	}

	public final Map<String, Object> execute() {

		Map<String, Object> results = super.execute();

		return results;
	}
}
