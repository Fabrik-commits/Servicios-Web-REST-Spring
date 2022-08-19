package com.spring.boot.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.spring.boot.dto.EmpleadoDTO;
import com.spring.boot.entity.EmpleadoEntity;
import com.spring.boot.repository.EmpleadoRepository;
import com.spring.boot.service.IEmpleado;
import com.spring.boot.util.ConvertEntityToDtoUtil;

@Service
public class EmpleadoImpl implements IEmpleado {
	
	@Autowired
	@Qualifier("empleadoRepository")
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private ConvertEntityToDtoUtil convertEntityToDtoUtil;

	@Override
	public String holaMundo(String nombre) {
		return "Hola Mundo " + nombre;
	}

	@Override
	public String guardarEmpleado(EmpleadoDTO empleadoDto) {

		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		empleadoEntity.setCodigo(empleadoDto.getCodigo());
		empleadoEntity.setNombre(empleadoDto.getNombre());
		empleadoEntity.setSalario(empleadoDto.getSalario());
		
		empleadoRepository.save(empleadoEntity);
		return "Guardado";
	}

	@Override
	public List<EmpleadoDTO> listarEmpleados(Integer codigo) {
		List<EmpleadoDTO> list = null;
		//List<EmpleadoEntity> empleadoEntity = empleadoRepository.findAll();
		List<EmpleadoEntity> empleadoEntity = empleadoRepository.listarEmpleados(codigo);
		list = empleadoEntity.stream().map(param -> convertEntityToDtoUtil.convertToDTOEmpleado(param)).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<EmpleadoDTO> listarEmpleados() {
		// TODO Auto-generated method stub
		List<EmpleadoDTO> list = null;
		List<EmpleadoEntity> empleadoEntity = empleadoRepository.findAll();
		list = empleadoEntity.stream().map(param -> convertEntityToDtoUtil.convertToDTOEmpleado(param)).collect(Collectors.toList());
		return list;
	}
		
}
