package se.mdh.driftavbrott.gui.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.mdh.driftavbrott.gui.model.Anledning;

public interface AnledningRepository extends MongoRepository<Anledning, String> {

}
