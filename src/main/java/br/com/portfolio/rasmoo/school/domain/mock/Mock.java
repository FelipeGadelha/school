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
		
		matterRepository.save(new Matter.Builder().name("ajhklhl").hour(112).code("asada").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("s").hour(112).code("gfdg").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("d").hour(112).code("bvc").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("f").hour(112).code("bjmg").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("g").hour(112).code("kjyfk").frequency(1).build());
		matterRepository.save(new Matter.Builder().name("g").hour(112).code("fgf").frequency(1).build());
		
	}

}
