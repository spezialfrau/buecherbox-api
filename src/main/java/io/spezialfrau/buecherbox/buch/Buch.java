package io.spezialfrau.buecherbox.buch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Buch {

    @Id
    private String id;

    private String titel;
    private String autor;
    private Set<String> kategorien;
    private String inhalt;
}
