package org.emsi.VoitureService.Repository;

import org.emsi.VoitureService.Model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
