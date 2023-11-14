package com.eskcti.loja_virtual_jv_back.services;

import com.eskcti.loja_virtual_jv_back.models.Acesso;
import com.eskcti.loja_virtual_jv_back.repositories.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	
	public Acesso save(Acesso acesso) {
		
		/*Qualquer tipo de validação*/
		
		return acessoRepository.save(acesso);
	}

}
