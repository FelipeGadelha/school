package br.com.portfolio.rasmoo.school.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.portfolio.rasmoo.school.api.dto.request.MatterRq;
import br.com.portfolio.rasmoo.school.api.dto.request.MatterUpdateRq;
import br.com.portfolio.rasmoo.school.api.dto.response.MatterRs;
import br.com.portfolio.rasmoo.school.domain.entity.Matter;
import br.com.portfolio.rasmoo.school.domain.projection.MatterProjection;
import br.com.portfolio.rasmoo.school.domain.repository.MatterRepository;

@Service
public class MatterService {

	private final MatterRepository matterRepository;

	private final ModelMapper mapper;

	@Autowired
	public MatterService(MatterRepository matterRepository, ModelMapper mapper) {
		this.matterRepository = matterRepository;
		this.mapper = mapper;
	}

	public List<MatterProjection> findAllMatter() {
		return matterRepository.findAllMatter();
	}

	public MatterProjection findByIdMatter(Long id) {
		return matterRepository.findByIdMatter(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Matter not Found"));
	}

	public MatterRs save(MatterRq matterRq) {
		Matter matter = toEntity(matterRq);
		try {
			return toDto(matterRepository.save(matter));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
		}
	}

	public MatterRs update(MatterUpdateRq matterUpdateRq) {
		if (!matterRepository.existsById(matterUpdateRq.getId()))
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Matter not Found");
		
		Matter matter = toEntityUpdate(matterUpdateRq);
		return toDto(matterRepository.save(matter));
	}
	
	public void delete(Long id) {
		try {
			matterRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "This material ID does not exist");
		}
	}
	
	

	private Matter toEntity(MatterRq matterRq) {
		return mapper.map(matterRq, Matter.class);
	}

	private Matter toEntityUpdate(MatterUpdateRq matterUpdateRq) {
		return mapper.map(matterUpdateRq, Matter.class);
	}

	private MatterRs toDto(Matter matter) {
		return mapper.map(matter, MatterRs.class);
	}

	

}
