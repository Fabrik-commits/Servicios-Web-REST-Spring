package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dto.EmpleadoDTO;

public interface IEmpleado {

	String holaMundo(String nombre);
	
	String guardarEmpleado(EmpleadoDTO empleadoDto);
	
	List<EmpleadoDTO> listarEmpleados();
	
	List<EmpleadoDTO> listarEmpleados(Integer codigo);
	
}
