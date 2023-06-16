package com.br.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.apache.http.client.methods.HttpGet;

import com.br.model.BTCBRLS;
import com.br.model.Btcbrl;
import com.br.model.EURBRLS;
import com.br.model.Eurbrl;
import com.br.model.USDBRLS;
import com.br.model.Usdbrl;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class buscaCotacaoService {

	private final ObjectMapper objectMapper;

	public buscaCotacaoService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public Usdbrl getCotacaoUSD() throws ClientProtocolException, IOException {
		Usdbrl usdbrl = null;

		HttpGet request = new HttpGet("https://economia.awesomeapi.com.br/last/USD");

		try (CloseableHttpClient httpclient = HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse responde = httpclient.execute(request)) {

			HttpEntity entity = responde.getEntity();

			if (entity != null) {
				String result = EntityUtils.toString(entity);

				// Use o ObjectMapper para desserializar o JSON
				USDBRLS response = objectMapper.readValue(result, USDBRLS.class);

				if (response != null) {
					usdbrl = response.getUsdbrl();
				}
			}
		}

		return usdbrl;
	}
	
	public Btcbrl getCotacaoReal() throws ClientProtocolException, IOException {
		Btcbrl btcBrl = null;

		HttpGet request = new HttpGet("https://economia.awesomeapi.com.br/last/BTC-BRL");

		try (CloseableHttpClient httpclient = HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse responde = httpclient.execute(request)) {

			HttpEntity entity = responde.getEntity();

			if (entity != null) {
				String result = EntityUtils.toString(entity);

				// Use o ObjectMapper para desserializar o JSON
				BTCBRLS response = objectMapper.readValue(result, BTCBRLS.class);

				if (response != null) {
					btcBrl = response.getBtcbrl();
				}
			}
		}

		return btcBrl;
	}
	
	public Eurbrl getCotacaoEuro() throws ClientProtocolException, IOException {
		Eurbrl eurbrl = null;

		HttpGet request = new HttpGet("https://economia.awesomeapi.com.br/last/EUR-BRL");

		try (CloseableHttpClient httpclient = HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse responde = httpclient.execute(request)) {

			HttpEntity entity = responde.getEntity();

			if (entity != null) {
				String result = EntityUtils.toString(entity);

				// Use o ObjectMapper para desserializar o JSON
				EURBRLS response = objectMapper.readValue(result, EURBRLS.class);

				if (response != null) {
					eurbrl = response.getEurBrl();
				}
			}
		}

		return eurbrl;
	}
}

