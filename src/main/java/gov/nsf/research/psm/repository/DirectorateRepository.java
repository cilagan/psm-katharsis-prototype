package gov.nsf.research.psm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.google.common.collect.Iterables;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.service.ProposalManagementService;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindAllWithIds;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;

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
	
	@JsonApiFindAllWithIds
    public Iterable<Directorate> findAll(Iterable<String> directorateIds, QueryParams requestParams) {
        return REPOSITORY.entrySet()
                .stream()
                .filter(p -> Iterables.contains(directorateIds, p.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .values();
    }

}
