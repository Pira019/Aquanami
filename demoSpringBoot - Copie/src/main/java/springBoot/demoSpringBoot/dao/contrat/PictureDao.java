package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Picture;

public interface PictureDao extends JpaRepository<Picture, Long> {

}
