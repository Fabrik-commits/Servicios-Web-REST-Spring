package com.spring.boot.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.dto.EmpleadoDTO;
import com.spring.boot.entity.EmpleadoEntity;

@Component("convertEntityToDtoUtil")
public class ConvertEntityToDtoUtil {

	@Autowired
	private ModelMapper modelMaper;
	
	public EmpleadoDTO convertToDTOEmpleado(EmpleadoEntity empleadoEntity) {
		EmpleadoDTO empleadoDTO = null;
		
		if (empleadoEntity != null) {
			empleadoDTO = modelMaper.map(empleadoEntity, EmpleadoDTO.class);
		}
		return empleadoDTO;
	} 
}
