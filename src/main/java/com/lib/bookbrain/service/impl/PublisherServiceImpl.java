package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.annotation.AroundDelete;
import com.lib.bookbrain.annotation.AroundGet;
import com.lib.bookbrain.annotation.AroundUpdate;
import com.lib.bookbrain.dao.PublisherMapper;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.service.PublisherService;
import org.springframework.stereotype.Service;


@Service
public class PublisherServiceImpl implements PublisherService {
private final PublisherMapper publisherMapper;
private final BaseServiceImpl<Publisher> baseService;

public PublisherServiceImpl(PublisherMapper publisherMapper) {
   this.publisherMapper = publisherMapper;
   baseService = new BaseServiceImpl<>(publisherMapper);
}

@AroundGet
@Override
public Response getBy(Payload<Publisher> payload) {
   return baseService.getBy(payload);
}

@Override
public Response create(Payload<Publisher> payload) {
   return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<Publisher> payload) {
   return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<Publisher> payload) {
   return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<Publisher> payload) {
   return baseService.delete(payload);
}
}
