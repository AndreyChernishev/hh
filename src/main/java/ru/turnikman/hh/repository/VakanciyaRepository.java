package ru.turnikman.hh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.turnikman.hh.model.Vakanciya;

import java.util.List;

public interface VakanciyaRepository extends JpaRepository<Vakanciya, Long> {
    @Query(value =
            "select v.* from vakanciya v "+
            "inner join vakanciya_klyuchevoy_navik vkn on v.id_vakansiya = vkn.id_vakansiya "+
            "inner join klyuchevoy_navik kn on vkn.id_kluchevoy_navik = kn.id_kluchevoy_navik "+
            "where kn.nazvanie = :kn", nativeQuery = true)
    List<Vakanciya> findVakanciyaByKlyuchevoyNavik(@Param("kn") String klyuchevoyNavik);
}
