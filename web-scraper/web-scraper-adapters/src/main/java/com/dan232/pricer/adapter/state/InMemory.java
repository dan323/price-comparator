package com.dan232.pricer.adapter.state;

import com.dan232.pricer.scraper.model.WebProductPrice;
import com.dan232.pricer.scraper.port.SavePort;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InMemory extends SavePort, JpaRepository<WebProductPrice, String> {

    List<WebProductPrice> findByProductName(String name);

}
