package com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

import com.br.model.Btcbrl;
import com.br.model.Eurbrl;
import com.br.model.Tarefa;
import com.br.model.Usdbrl;
import com.br.repository.TarefaRepository;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class TerefaService {
	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private RestTemplate restTemplate;

	@PostConstruct
	public void init() throws IOException {
		executeScheduledTasks();
	}

	public List<Tarefa> getAllTrefas() {
		return tarefaRepository.findAll();
	}

	public void saveTask(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}

	@Scheduled(fixedRate = 10000) // Executa a cada minuto
	public void executeScheduledTasks() throws IOException {
		List<Tarefa> tarefas = getAllTrefas();
		LocalDateTime now = LocalDateTime.now();

		for (Tarefa tarefa : tarefas) {
			LocalDateTime scheduledDateTime = tarefa.getDataHoraAgendada();
			if (scheduledDateTime != null && scheduledDateTime.isBefore(now)) {

				// Chama o endpoint /dolar ao real
				ResponseEntity<Usdbrl> responseDolar = restTemplate.getForEntity("http://localhost:8080/cotacoes/dolar",
						Usdbrl.class);
				if (responseDolar.getStatusCode() == HttpStatus.OK) {
					Usdbrl usdbrl = responseDolar.getBody();
					log.info("Chamando endpoint /dolar");

				}

				// Chama o endpoint /bitcoin ao real
				ResponseEntity<Btcbrl> responseReal = restTemplate.getForEntity("http://localhost:8080/cotacoes/real",
						Btcbrl.class);
				if (responseReal.getStatusCode() == HttpStatus.OK) {
					Btcbrl btcbrl = responseReal.getBody();
					log.info("Criando novo objeto venda");
				}

				// Chama o endpoint /euro ao real
				ResponseEntity<Eurbrl> responseEuro = restTemplate.getForEntity("http://localhost:8080/cotacoes/euro",
						Eurbrl.class);
				if (responseEuro.getStatusCode() == HttpStatus.OK) {
					Eurbrl eurbrl = responseEuro.getBody();
					log.info("Chamando endpoint /euro");
				}
			}
		}
	}
}
