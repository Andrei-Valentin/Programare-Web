package ro.unibuc.assignment1main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.unibuc.assignment1main.model.Magazin;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MagazinRepositoryImpl implements MagazinRepository{

    private final JdbcTemplate jdbcTemplate;

    public MagazinRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Magazin insert(Magazin magazin) {
        magazin.setId(UUID.randomUUID().toString());

        jdbcTemplate.update("insert into magazine values (?, ?, ?)",
                magazin.getId(), magazin.getNume(), magazin.getOras());

        return magazin;
    }

    @Override
    public boolean exists(String idMagazin) {
        final var foundId = jdbcTemplate.queryForObject("select id from magazine where id = ?", String.class, idMagazin);

        return foundId != null;
    }

    @Override
    public Optional<Magazin> read(String idMagazin) {
        final var magazin = jdbcTemplate.queryForObject("select * from magazine where id = ?", (rs, rowNumber) -> {
            final var mapped = new Magazin();
            mapped.setId(rs.getString("id"));
            mapped.setNume(rs.getString("nume"));
            mapped.setOras(rs.getString("oras"));

            return mapped;
        }, idMagazin);

        return Optional.ofNullable(magazin);
    }
}
