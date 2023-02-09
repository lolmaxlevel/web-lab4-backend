package com.lolmaxlevel.weblab4server.repository;

import com.lolmaxlevel.weblab4server.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempt, Integer> {
    /**
     * Makes a search in the database by the given parameters with the given offset and size
     * Can accept nulls as size, offset, id, x, y, r, result, time, username parameters
     *
     * @param offset the offset of the search, must not be null, must be >= 0
     * @param size   the size of the search, must not be null, must be >= 0
     */
    @Query(value = """
            select * from attempts order by id limit :size_n offset :offset_n""", nativeQuery = true)
    // The if a value is null it is an empty string
    List<Attempt> getPartAttempts(@Param("offset_n") Integer offset, @Param("size_n") Integer size);
    @Query(value = """
            select count(*) from attempts""", nativeQuery = true)
    int getAttemptsCount();
}
