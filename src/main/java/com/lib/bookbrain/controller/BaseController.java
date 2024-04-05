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
	Payload<E> _p = new Payload<>();
	_p.setId(id);
	return baseService.getById(_p);
}

@PostMapping
public Response create(@RequestBody E entity) {
	Payload<E> _p = Payload.gByEntity(entity);
	return baseService.create(_p);
}


@PatchMapping("/{id}")
public Response update(@RequestBody E entity, @PathVariable Integer id) {
	Payload<E> _p = Payload.gByEntity(entity);
	_p.setId(id);
	return baseService.update(_p);
}

@DeleteMapping("/{id}")
public Response delete(@PathVariable Integer id) {
	Payload<E> _p = new Payload<>();
	_p.setId(id);
	return baseService.delete(_p);
}


}
