package com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.model.Btcbrl;
import com.br.model.Eurbrl;
import com.br.model.Tarefa;
import com.br.model.Usdbrl;
import com.br.repository.TarefaRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;;

	@Autowired
	private RestTemplate restTemplate;

	public List<Tarefa> getAllTarefas() {
		return tarefaRepository.findAll();
	}

	public void saveTask(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}

	@Scheduled(cron = "${spring.task.scheduling.cotacoes}")
	public void executeScheduledTasks() throws InterruptedException {

		// Chama o endpoint /dolar ao real
		Thread.sleep(5000); // Aguarda 5 segundos
		ResponseEntity<Usdbrl> responseDolar = restTemplate.getForEntity("http://localhost:8080/cotacoes/dolar",
				Usdbrl.class);
		if (responseDolar.getStatusCode() == HttpStatus.OK) {
			String usdbrl = responseDolar.getBody().getName();
			String valorusd = responseDolar.getBody().getHigh();
			log.info("Chamando endpoint /dolar | " + usdbrl + " | valor: " + valorusd);

		}

		// Chama o endpoint /bitcoin ao real
		Thread.sleep(5000); // Aguarda 5 segundos
		ResponseEntity<Btcbrl> responseReal = restTemplate.getForEntity("http://localhost:8080/cotacoes/real",
				Btcbrl.class);
		if (responseReal.getStatusCode() == HttpStatus.OK) {
			String btcbrl = responseReal.getBody().getName();
			String valoBtc = responseReal.getBody().getHigh();
			log.info("Chamando endpoint /bitcoin | " + btcbrl + " | valor: " + valoBtc);
		}

		// Chama o endpoint /euro ao real
		Thread.sleep(5000); // Aguarda 5 segundos
		ResponseEntity<Eurbrl> responseEuro = restTemplate.getForEntity("http://localhost:8080/cotacoes/euro",
				Eurbrl.class);
		if (responseEuro.getStatusCode() == HttpStatus.OK) {
			String eurbrl = responseEuro.getBody().getName();
			String valorEuro = responseEuro.getBody().getHigh();
			log.info("Chamando endpoint /euro | " + eurbrl + " | valor: " + valorEuro);
		}
	}
}