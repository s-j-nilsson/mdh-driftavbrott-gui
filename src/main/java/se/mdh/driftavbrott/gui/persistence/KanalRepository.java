package se.mdh.driftavbrott.gui.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.mdh.driftavbrott.gui.model.Kanal;

public interface KanalRepository extends MongoRepository<Kanal, String> {

}
