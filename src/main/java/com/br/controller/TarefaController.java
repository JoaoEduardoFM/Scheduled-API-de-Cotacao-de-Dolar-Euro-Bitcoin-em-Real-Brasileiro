package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.Btcbrl;
import com.br.model.Eurbrl;
import com.br.model.Usdbrl;
import com.br.service.buscaCotacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cotacoes")
@Api( value = "consultar Cotaçoes", tags = { "Cotacoes" })
public class TarefaController {

	@Autowired
	buscaCotacaoService service;
	
	@GetMapping("/dolar")
    @ResponseBody 
	@ApiOperation (
      value = "Cotacão Real/Dólar.",
      notes = "consultar cotação real ao Dólar.")
    @ResponseStatus(HttpStatus.OK)
    public Usdbrl CotacaoDolar() throws Exception{
		return service.getCotacaoUSD();	
    }
	
	@GetMapping("/real")
    @ResponseBody 
	@ApiOperation (
      value = "Cotacão real/Bitcoin.",
      notes = "consultar cotação real ao Bitcoin.")
    @ResponseStatus(HttpStatus.OK)
    public Btcbrl CotacaoReal() throws Exception{
		return service.getCotacaoReal();
    }
	
	@GetMapping("/euro")
    @ResponseBody 
	@ApiOperation (
      value = "Cotacão real/Euro.",
      notes = "consultar cotação do real ao Euro.")
    @ResponseStatus(HttpStatus.OK)
    public Eurbrl CotacaoEuro() throws Exception{
		return service.getCotacaoEuro();
    }
}
