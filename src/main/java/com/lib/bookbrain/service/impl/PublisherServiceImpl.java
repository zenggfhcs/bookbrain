package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundAdd;
import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.PublisherMapper;
import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.PublisherService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class PublisherServiceImpl implements PublisherService {
private final PublisherMapper publisherMapper;
private final BaseServiceImpl<Publisher> baseService;

public PublisherServiceImpl(PublisherMapper publisherMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.publisherMapper = publisherMapper;
	baseService = new BaseServiceImpl<>(threadContext, publisherMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@AroundAdd
@Override
public Response create(Payload<Publisher> payload) {
	Publisher _e = payload.getEntity();
	int _cc = publisherMapper.getCountByName(_e.getName());
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
	// 判断一下，更新的名称是不是重复了
	int _cc = publisherMapper.getCountByName(payload.getEntity().getName());
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
