package br.com.portfolio.rasmoo.school.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portfolio.rasmoo.school.api.dto.request.MatterRq;
import br.com.portfolio.rasmoo.school.api.dto.request.MatterUpdateRq;
import br.com.portfolio.rasmoo.school.domain.projection.MatterProjection;
import br.com.portfolio.rasmoo.school.domain.service.MatterService;

@RestController
@RequestMapping("/v1/matter")
public class MatterController {
	
	private final MatterService matterService;
	
	@Autowired
	public MatterController(MatterService matterService) {
		this.matterService = matterService;
	}

	@GetMapping
	public ResponseEntity<List<MatterProjection>> findAll() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(matterService.findAllMatter());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(matterService.findByIdMatter(id));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid MatterRq matterRq) {
		return new ResponseEntity<>(matterService.save(matterRq), HttpStatus.CREATED);

		//		Matter matter = toEntity(matterRq);
//		try {
//			MatterRs save = toDto(matterRepository.save(matter));
//			return new ResponseEntity<>(save, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody MatterUpdateRq matterUpdateRq) {
		return new ResponseEntity<>(matterService.update(matterUpdateRq), HttpStatus.OK);
		
//		Matter matter = toEntityUpdate(matterUpdateRq);
//		try {
//			MatterRs save = toDto(matterRepository.save(matter));
//			return new ResponseEntity<>(save, HttpStatus.OK);
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		matterService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
//		try {
//			matterRepository.deleteById(id);
//			return ResponseEntity.noContent().build();
//		} catch (Exception e) {
//			System.out.println(e);
//			return ResponseEntity.unprocessableEntity().body("ID not found");
//		}
		
//		if (!matterRepository.existsById(id)) {
//			return ResponseEntity.unprocessableEntity().body("ID not found");
//		}
//		matterRepository.deleteById(id);
//		return ResponseEntity.noContent().build();
	}
	
	
//	@PostMapping
//	public ResponseEntity<?> saveMatter(@RequestBody MatterRq matterRq) {
//		Matter matter = toEntity(matterRq);
//		MatterProjection integer = matterRepository.saveMatter(matter.getName(), matter.getHour(), matter.getCode(), matter.getFrequency());
//		System.out.println(integer);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//		try {
////			MatterRs save = toDto();
//			return new ResponseEntity<>(save, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//	}
	
}
