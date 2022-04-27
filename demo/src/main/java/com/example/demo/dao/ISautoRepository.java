package com.example.demo.dao;

import com.example.demo.entity.ISauto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISautoRepository extends JpaRepository<ISauto, Long> {
}