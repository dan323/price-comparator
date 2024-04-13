package com.dan232.pricer.adapter.state;

import com.dan232.pricer.scraper.model.WebProductPrice;
import com.dan232.pricer.scraper.port.SavePort;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InMemory extends SavePort, JpaRepository<WebProductPrice, String> {

}
