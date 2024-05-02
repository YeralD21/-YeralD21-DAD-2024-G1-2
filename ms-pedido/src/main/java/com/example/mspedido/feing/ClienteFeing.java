package com.example.mspedido.feing;

import com.example.mspedido.dto.ClienteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-client-service", path = "/clients")
public interface ClienteFeing {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "clienteListarPorIdCB", fallbackMethod = "fallbackClientePorId ")
    ResponseEntity<ClienteDto> findById(@PathVariable(required = true) Integer id);

    default ResponseEntity<ClienteDto> fallbackClientePorId(Integer id, Exception e) {

        return ResponseEntity.ok(new ClienteDto());
    }
}


