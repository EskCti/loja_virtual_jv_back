package com.eskcti.loja_virtual_jv_back;

import com.eskcti.loja_virtual_jv_back.models.Acesso;
import com.eskcti.loja_virtual_jv_back.repositories.AcessoRepository;
import com.eskcti.loja_virtual_jv_back.resources.AcessoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LojaVirtualJvBackApplication.class)
class LojaVirtualJvBackApplicationTests {

	@Autowired
	private AcessoController acessoController;

	@Autowired
	private AcessoRepository acessoRepository;
	@Test
	public void testCadastraAcesso() throws ExceptionMentoriaJava {

		String descacesso = "ROLE_ADMIN" + Calendar.getInstance().getTimeInMillis();

		Acesso acesso = new Acesso();

		acesso.setDescricao(descacesso);

		assertEquals(true, acesso.getId() == null);

		/*Gravou no banco de dados*/
		acesso = acessoController.salvarAcesso(acesso).getBody();

		assertEquals(true, acesso.getId() > 0);

		/*Validar dados salvos da forma correta*/
		assertEquals(descacesso, acesso.getDescricao());

		/*Teste de carregamento*/

		Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();

		assertEquals(acesso.getId(), acesso2.getId());


		/*Teste de delete*/

		acessoRepository.deleteById(acesso2.getId());

		acessoRepository.flush(); /*Roda esse SQL de delete no banco de dados*/

		Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null);

		assertEquals(true, acesso3 == null);


		/*Teste de query*/

		acesso = new Acesso();

		acesso.setDescricao("ROLE_ALUNO");

		acesso = acessoController.salvarAcesso(acesso).getBody();

		List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());

		assertEquals(1, acessos.size());

		acessoRepository.deleteById(acesso.getId());

	}
}
