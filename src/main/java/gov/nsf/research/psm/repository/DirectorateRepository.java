package gov.nsf.research.psm.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.service.ProposalManagementService;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;
@CrossOrigin
@JsonApiResourceRepository(Directorate.class)
@Component
public class DirectorateRepository {
    private static final Map<String, Directorate> REPOSITORY = new ConcurrentHashMap<>();
    
	@Autowired
	ProposalManagementService proposalManagementService;
	
	
    @JsonApiSave
    public <S extends Directorate> S save(S entity) {
        REPOSITORY.put(entity.getId(), entity);
        return entity;
    }
	
	@JsonApiFindAll
	public Iterable<Directorate> findAll(QueryParams requestParams) {
		List<Directorate> dirList = proposalManagementService.getAllDirectorates();
		for(Directorate dir : dirList) {
			save(dir);
		}
		
		return REPOSITORY.values();
	}
	

}
