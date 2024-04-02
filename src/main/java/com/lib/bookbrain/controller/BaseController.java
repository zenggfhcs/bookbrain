package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.Entity;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.BaseService;
import org.springframework.web.bind.annotation.*;

public class BaseController<E extends Entity> {
private final BaseService<E> baseService;

public BaseController(BaseService<E> baseService) {
	this.baseService = baseService;
}

@GetMapping
public Response list() {
	return baseService.list();
}

@GetMapping("/{id}")
public Response get(@PathVariable Integer id) {
	return baseService.getById(id);
}

@PostMapping
public Response create(@RequestBody E entity) {
	return baseService.create(entity);
}


@PatchMapping("/{id}")
public Response update(@RequestBody E entity, @PathVariable Integer id) {
	Payload<E> _payload = Payload.generateByEntity(entity);
	_payload.setId(id);
	return baseService.update(_payload);
}

@DeleteMapping("/{id}")
public Response delete(@PathVariable Integer id) {
	return baseService.delete(id);
}


}
