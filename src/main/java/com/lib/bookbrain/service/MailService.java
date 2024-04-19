package com.lib.bookbrain.service;

import com.lib.bookbrain.exception.SendEmailException;
import com.lib.bookbrain.exception.TemplateReadException;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.utils.Base64Coder;
import com.lib.bookbrain.utils.Json;
import com.lib.bookbrain.utils.LogUtils;
import com.lib.bookbrain.utils.MapFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 邮件服务
 */
@Service
public class MailService {

private final JavaMailSender sender;

private final Configuration freemarkerConfig;

/**
 * 配置文件配置发件人
 */
@Value("${spring.mail.username}")
private String from;

@Value("${spring.mail.baseHost}")
private String baseHost;

public MailService(JavaMailSender sender, Configuration freemarkerConfig) {
	this.sender = sender;
	this.freemarkerConfig = freemarkerConfig;
}

public void sendLink(User recipient, String sub) {
	send(recipient.getEmail(),
			sub,
			() -> {
				Map<String, Object> _map = MapFactory.Builder.builder()
						.fill("email", recipient.getEmail())
						.fill("link", gLink(recipient.getEmail()))
						.build().map();
				return fillTemplate(TemplateName.REGISTER, _map);
			}
	);
}

public void sendCode(User recipient, String sub) {
	send(
			recipient.getEmail(),
			sub,
			() -> {
				Map<String, Object> _map = MapFactory.Builder.builder()
						.fill("code", recipient.getAuthenticationString())
						.build().map();
				return fillTemplate(TemplateName.RESET_PASSWORD, _map);
			}
	);
}


/**
 * 给邮箱发邮件
 */
public void send(String recipientEmail, String sub, Supplier<String> sup) {
	MimeMessage message = sender.createMimeMessage();
	MimeMessageHelper helper;
	try {
		helper = new MimeMessageHelper(message, true);
		{
			helper.setFrom(from);
			helper.setTo(recipientEmail);
			helper.setSubject(sub);
			// 模板拼接
			String content = sup.get();

			Map<String, Object> _map = MapFactory.Builder.builder()
					.fill("title", sub)
					.fill("content", content)
					.build().map();

			helper.setText(fillTemplate(TemplateName.BASE, _map), true);
			sender.send(message);
		}
	} catch (Exception e) {
		LogUtils.write(e.getMessage());
		throw new SendEmailException();
	}
}

private String gLink(String email) {
	// todo 修改 link
	return "http://" + baseHost + "/verify?token=" + gRegisterToken(email);
}

private String gRegisterToken(String email) {
	TokenInfo _tokenInfo = new TokenInfo();
	{
		_tokenInfo.setNbf(System.currentTimeMillis());
		_tokenInfo.setJti(email);
	}
	return Base64Coder.encode(Json.stringify(_tokenInfo), true);
}

/**
 * 读取模板 填充后返回模板字符串
 *
 * @param tempPath 模板路径
 * @param map      数据表
 * @return 模板字符串
 */
public String fillTemplate(String tempPath, Map<String, Object> map) {
	try (StringWriter writer = new StringWriter()) {
		Template template = freemarkerConfig.getTemplate(tempPath);
		template.process(map, writer);
		return writer.toString();
	} catch (IOException | TemplateException e) {
		LogUtils.write(e.getMessage());
		throw new TemplateReadException();
	}
}


public interface TemplateName {
	String BASE_URL = "/freemarker/";
	String BASE = BASE_URL + "base.ftl";
	String REGISTER = BASE_URL + "register-confirmed.ftl";
	String RESET_PASSWORD = BASE_URL + "reset-confirmed.ftl";
	String REPAY = BASE_URL + "repay.ftl";

}
}
