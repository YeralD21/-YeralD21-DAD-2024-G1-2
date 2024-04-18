package com.example.mspedido.feing;

import com.example.mspedido.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-client-service", path = "/clients")
public interface ClienteFeing {

    @GetMapping("/{id}")
    ResponseEntity<ClienteDto> findById(@PathVariable(required = true) Integer id);
}
