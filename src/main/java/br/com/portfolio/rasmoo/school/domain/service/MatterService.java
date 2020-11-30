package br.com.portfolio.rasmoo.school.domain.service;

import java.util.List;

import br.com.portfolio.rasmoo.school.api.dto.request.MatterRq;
import br.com.portfolio.rasmoo.school.api.dto.request.MatterUpdateRq;
import br.com.portfolio.rasmoo.school.api.dto.response.MatterRs;
import br.com.portfolio.rasmoo.school.domain.projection.MatterProjection;

public interface MatterService {
	
	List<MatterProjection> findAllMatter();
	
	MatterProjection findByIdMatter(Long id);
	
	MatterRs save(MatterRq matterRq);
	
	MatterRs update(MatterUpdateRq matterUpdateRq);
	
	void delete(Long id);

}
