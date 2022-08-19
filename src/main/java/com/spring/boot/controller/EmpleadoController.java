package com.spring.boot.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dto.EmpleadoDTO;
import com.spring.boot.service.IEmpleado;


@Produces({"application/json"})
@RestController
@RequestMapping("/proyecto")
public class EmpleadoController {
	
	@Autowired
	private IEmpleado empleado;
	
	
	@GetMapping(path = "/saludar/{nombre}")
	public String holaMundo(@PathVariable("nombre") String nombre) {
		String respuesta = null;
		try {
			respuesta = empleado.holaMundo(nombre);
		} catch (Exception e) {
			System.out.println("Error es : " + e);
		}
		
		return respuesta;
	}
	
	@GetMapping("")
	public String inicio() {
		return "Hola Mundo";
	}
	
	@PostMapping(path = "/guardar/empleado", consumes = MediaType.APPLICATION_JSON)
	public String guardarProducto(@RequestBody EmpleadoDTO empleadoDto) {
		String respuesta = null;
		try {
			respuesta = empleado.guardarEmpleado(empleadoDto);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		respuesta = null;
		return respuesta;
	}
	
	@GetMapping(path = "/listar")
	public List<EmpleadoDTO> ListarEmpleados() {
		List<EmpleadoDTO> respuesta = null;
		try {
			respuesta = empleado.listarEmpleados();
		} catch (Exception e) {
			System.out.println("Error es : " + e);
		}
		
		return respuesta;
	}
	
	@GetMapping(path = "/listar/{codigo}")
	public List<EmpleadoDTO> listarEmpleados(@PathVariable("codigo") Integer codigo) {
		List<EmpleadoDTO> respuesta = null;
		try {
			respuesta = empleado.listarEmpleados(codigo);
		} catch (Exception e) {
			System.out.println("Error es : " + e);
		}
		
		return respuesta;
	}

}
