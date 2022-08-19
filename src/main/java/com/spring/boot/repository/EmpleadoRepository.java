package com.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.entity.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

	@Query("SELECT e FROM EmpleadoEntity e WHERE codigo >:codigo")
	List<EmpleadoEntity> listarEmpleados(Integer codigo);
}
