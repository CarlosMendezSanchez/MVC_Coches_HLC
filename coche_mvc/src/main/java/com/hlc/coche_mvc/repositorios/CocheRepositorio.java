package com.hlc.coche_mvc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hlc.coche_mvc.entidades.Coche;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Long>{

}
