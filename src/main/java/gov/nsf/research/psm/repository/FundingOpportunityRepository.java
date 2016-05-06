package gov.nsf.research.psm.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.service.ProposalManagementService;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
@CrossOrigin
@JsonApiResourceRepository(FundingOpportunity.class)
@Component
public class FundingOpportunityRepository {

	   @Autowired
	ProposalManagementService proposalManagementService;
	
    @Autowired @Lazy
    public FundingOpportunityRepository(DirectorateRepository directorateRepository) {
    }
    
	@JsonApiFindAll
	public Iterable<FundingOpportunity> findAll(QueryParams requestParams) {
		List<FundingOpportunity> fundingOpList = proposalManagementService.getAllFundingOpportunities();
		//List<Directorate> dirList = proposalManagementService.getAllDirectorates();
		
		/*for(FundingOpportunity fundingOp : fundingOpList) {
			fundingOp.getDirectorateList().addAll(dirList);
		}*/
		
		return fundingOpList;
	}
	
}
