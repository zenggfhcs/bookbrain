package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundAdd;
import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.PublisherMapper;
import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.PublisherFilter;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.service.PublisherService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class PublisherServiceImpl implements PublisherService {
private final PublisherMapper publisherMapper;
private final BaseServiceImpl<Publisher, PublisherFilter> baseService;

public PublisherServiceImpl(PublisherMapper publisherMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.publisherMapper = publisherMapper;
	baseService = new BaseServiceImpl<>(threadContext, publisherMapper);
}

@AroundGet
@Override
public Response getBy(FilterPayload<Publisher, PublisherFilter> payload) {
	return baseService.getBy(payload);
}

@AroundAdd
@Override
public Response create(Payload<Publisher> payload) {
	int _cc = publisherMapper.getCountByName(payload);
	if (_cc != 0) {
		return Response.error(ResponseInfo.PUBLISHER_NAME_REPEAT);
	}

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
	int _cc = publisherMapper.getCountByName(payload);
	if (_cc != 0) {
		return Response.error(ResponseInfo.PUBLISHER_NAME_REPEAT);
	}

	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<Publisher> payload) {
	return baseService.delete(payload);
}
}
