package br.com.alura.forum.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.*;
import br.com.alura.forum.repository.TopicoRepository;

import java.util.List;


@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")	
	public List<TopicoDto> lista(String nomeCurso){
		
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();	
			return  TopicoDto.converter(topicos);
		}
		else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);	
			return  TopicoDto.converter(topicos);
		}
		
		
		
	}
}
