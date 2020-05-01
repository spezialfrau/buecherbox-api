package io.spezialfrau.buecherbox;

import io.spezialfrau.buecherbox.buch.Buch;
import io.spezialfrau.buecherbox.buch.BuchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class BuecherboxApiApplication implements CommandLineRunner {

	private final BuchRepository repository;

	public BuecherboxApiApplication(BuchRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BuecherboxApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Long anzahl = repository.count();

		if(null==anzahl || anzahl<1) {
			log.info("DB ist leer. Ich lege mal die ersten Bücher an... ");
			Buch b1 = new Buch();
			b1.setTitel("Die Barfuß-Bande und die geklaute Oma");
			b1.setAutor("Jörg Steinleitner");
			b1.setInhalt("Hier riecht’s nach Abenteuer: Sommerferien auf dem Land sind manchmal ziemlich kriminell.");
			Set<String> kategorien = new HashSet<>();
			kategorien.add("abenteuerlich");
			kategorien.add("lustig");
			b1.setKategorien(kategorien);
			repository.save(b1);
			log.info("Buch 1 hinzugefügt: " + b1.toString());

			Buch b2 = new Buch();
			b2.setTitel("Harry Potter und der Stein der Weisen (Harry Potter 1)");
			b2.setAutor("J.K. Rowling");
			b2.setInhalt("Bis zu seinem elften Geburtstag glaubt Harry, er sei ein ganz normaler Junge. Doch dann erfährt er, dass er sich an der Schule für Hexerei und Zauberei einfinden soll – denn er ist ein Zauberer!");
			Set<String> kategorien2 = new HashSet<>();
			kategorien2.add("gruselig");
			kategorien2.add("fantasie");
			b2.setKategorien(kategorien2);
			repository.save(b2);
			log.info("Buch 2 hinzugefügt: " + b2.toString());
		}
	}
}
