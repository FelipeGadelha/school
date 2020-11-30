package br.com.portfolio.rasmoo.school.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.portfolio.rasmoo.school.api.dto.request.MatterRq;
import br.com.portfolio.rasmoo.school.api.dto.request.MatterUpdateRq;
import br.com.portfolio.rasmoo.school.api.dto.response.MatterRs;
import br.com.portfolio.rasmoo.school.api.exception.BadRequestException;
import br.com.portfolio.rasmoo.school.api.exception.NotFoundException;
import br.com.portfolio.rasmoo.school.domain.entity.Matter;
import br.com.portfolio.rasmoo.school.domain.projection.MatterProjection;
import br.com.portfolio.rasmoo.school.domain.repository.MatterRepository;

@CacheConfig(cacheNames = "matter")
@Service
public class MatterServiceImpl implements MatterService{

	private final MatterRepository matterRepository;

	private final ModelMapper mapper;

	@Autowired
	public MatterServiceImpl(MatterRepository matterRepository, ModelMapper mapper) {
		this.matterRepository = matterRepository;
		this.mapper = mapper;
	}

	@CachePut(unless = "#result.size()<3")
	@Override
	public List<MatterProjection> findAllMatter() {
		return matterRepository.findAllMatter();
	}
	
	@Cacheable(key = "#id")
	@Override
	public MatterProjection findByIdMatter(Long id) {
		return matterRepository.findByIdMatter(id)
				.orElseThrow(() -> new NotFoundException("Matter not Found"));
	}

	@CacheEvict(value = "findAllMatter", allEntries = true)
	@Override
	public MatterRs save(MatterRq matterRq) {
		Matter matter = toEntity(matterRq);
		try {
			return toDto(matterRepository.save(matter));
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Matter not Found");
		}
	}
	
	@Override
	public MatterRs update(MatterUpdateRq matterUpdateRq) {
		if (!matterRepository.existsById(matterUpdateRq.getId()))
			throw new BadRequestException("Matter not Exists");
		
		Matter matter = toEntityUpdate(matterUpdateRq);
		return toDto(matterRepository.save(matter));
	}
	
//	@CacheEvict(key = "#id")
	@Override
	public void delete(Long id) {
		try {
			matterRepository.deleteById(id);
		} catch (Exception e) {
			throw new BadRequestException("This matter ID does not exist");
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
