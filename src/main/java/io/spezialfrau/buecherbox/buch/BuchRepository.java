package io.spezialfrau.buecherbox.buch;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuchRepository extends MongoRepository<Buch, String> {
}
