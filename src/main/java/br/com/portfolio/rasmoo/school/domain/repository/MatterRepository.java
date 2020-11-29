package br.com.portfolio.rasmoo.school.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.portfolio.rasmoo.school.domain.entity.Matter;
import br.com.portfolio.rasmoo.school.domain.projection.MatterProjection;

@Repository
public interface MatterRepository extends JpaRepository<Matter, Long>{
	
	@Query("SELECT m FROM Matter m")
	List<MatterProjection> findAllMatter();
	
	@Query("SELECT m FROM Matter m WHERE m.id = :id")
	Optional<MatterProjection> findByIdMatter(Long id);
	
//	@Transactional
//	@Modifying(clearAutomatically = true, flushAutomatically = true)
//	@Query("INSERT INTO matter (name, hour, code, frequency) select :name,:hour,:code,:frequency FROM Matter m")
//	MatterProjection saveMatter(@Param("name") String name, @Param("hour") int hour, @Param("code") String code, @Param("frequency") int frequency);

//	<T> T saveMatter(Matter matter, Class<T> type);
}







//	@Modifying
//	@Query("update User u set u.active = false where u.lastLoginDate < :date")
//	void deactivateUsersNotLoggedInSince(@Param("date") LocalDate date);
//@Modifying
//@Query("INSERT INTO matter (name, hour, code, frequency) select :name,:hour,:code,:frequency FROM br.com.portfolio.rasmoo.school.domain.entity.Matter m")
//Matter saveMatter(@Param("name") String name, @Param("hour") int hour, @Param("code") String code, @Param("frequency") int frequency);



//@Query("select t from Logger t where t.user.id=?#{principal.id}")
//List<Logger> findAll();
//
//@Modifying
//@Query(value = "insert into Logger (redirect,user_id) VALUES (:insertLink,:id)", nativeQuery = true)
//@Transactional
//void logURI(@Param("insertLink") String insertLink, @Param("id") Long id);