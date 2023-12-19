package com.lib.service.impl;

import com.lib.anno.AroundDelete;
import com.lib.anno.AroundGet;
import com.lib.anno.AroundUpdate;
import com.lib.dao.PublisherMapper;
import com.lib.model.Payload;
import com.lib.model.Filter;
import com.lib.model.Publisher;
import com.lib.model.Response;
import com.lib.service.PublisherService;
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
public Response getBy(Payload<Publisher> payload, Filter filter) {
   return baseService.getBy(payload, filter);
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
