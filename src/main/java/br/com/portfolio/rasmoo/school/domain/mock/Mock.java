package br.com.portfolio.rasmoo.school.domain.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.portfolio.rasmoo.school.domain.entity.Matter;
import br.com.portfolio.rasmoo.school.domain.repository.MatterRepository;

@Component
public class Mock  implements ApplicationRunner{

	private final MatterRepository matterRepository;
	
	@Autowired
	public Mock(MatterRepository matterRepository) {
		this.matterRepository = matterRepository;
	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		matterRepository.save(new Matter.Builder().name("ANALISE DE DADOS").hour(112).code("ADD").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("PROGRAMAÇÂO ORIENTADA A OBJETOS").hour(112).code("POO").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("TOPICOS DESIGN PATTERNS").hour(112).code("TDP").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("CONCEITOS DE SOLID").hour(112).code("CDS").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("ESTRUTURA DE DADOS").hour(112).code("EDD").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("BANCO DE DADOS").hour(112).code("BDD").frequency(1).build());
		
	}

}
