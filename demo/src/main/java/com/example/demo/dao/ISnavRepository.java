package com.example.demo.dao;

import com.example.demo.entity.ISnav;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISnavRepository extends JpaRepository<ISnav, Integer> {
    List<ISnav> findByNev(String nev);
}