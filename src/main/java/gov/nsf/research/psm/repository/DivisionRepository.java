package gov.nsf.research.psm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.service.ProposalManagementService;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiResourceRepository;

@JsonApiResourceRepository(Division.class)
@Component
public class DivisionRepository {

	@Autowired
	ProposalManagementService proposalManagementService;
	
	
	@JsonApiFindAll
	public Iterable<Division> findAll(QueryParams requestParams) {
		return proposalManagementService.getAllDivisions();
	}
}
