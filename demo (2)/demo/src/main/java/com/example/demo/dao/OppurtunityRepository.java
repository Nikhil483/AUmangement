package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Oppurtunity;

@Repository
public interface OppurtunityRepository extends JpaRepository<Oppurtunity,Integer>{
	Oppurtunity findByOppId(int id);
}
