package br.com.portfolio.rasmoo.school.api.dto.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class MattersRs extends RepresentationModel<MattersRs> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<MatterRs> matters;
	
	public MattersRs() {
	}

	public MattersRs(List<MatterRs> matters) {
		this.matters = matters;
	}
	
	public List<MatterRs> getMatters() {
		return matters;
	}

}
