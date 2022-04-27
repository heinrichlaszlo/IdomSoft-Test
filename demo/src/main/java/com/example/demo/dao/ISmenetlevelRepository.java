package com.example.demo.dao;


import com.example.demo.entity.ISmenetlevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ISmenetlevelRepository extends JpaRepository<ISmenetlevel, Long> {

    @Query("SELECT sum(m.ar)FROM ISmenetlevel m WHERE m.aid.id= :id")
    public Integer getaAllAr(@Param("id") Long id);

    @Query("SELECT sum(m.km)FROM ISmenetlevel m WHERE m.aid.id= :id")
    public Integer getaAllKm(@Param("id") Long id);


    Optional<ISmenetlevel> findMenetlevelBySorszam(Long sorszam);


}