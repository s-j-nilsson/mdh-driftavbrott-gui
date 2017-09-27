package se.mdh.driftavbrott.gui.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.mdh.driftavbrott.gui.model.Driftavbrott;

public interface DriftavbrottRepository extends MongoRepository<Driftavbrott, String> {

}
