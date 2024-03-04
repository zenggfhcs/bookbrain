package com.lib.bookbrain.service;

import com.lib.bookbrain.constant.TemplateInfo;
import com.lib.bookbrain.model.entity.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

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

public MailService(JavaMailSender sender, Configuration freemarkerConfig) {
	this.sender = sender;
	this.freemarkerConfig = freemarkerConfig;
}

/**
 * 给用户发邮件
 *
 * @param recipient 收件用户
 * @param sub       主题
 */
public void send(User recipient, String sub) {
	send(recipient.getEmail(), sub);
}

/**
 * 给邮箱发邮件
 *
 * @param recipient 收件邮箱
 * @param sub       主题
 */
public void send(String recipient, String sub) {
	MimeMessage message = sender.createMimeMessage();
	MimeMessageHelper helper;
	try {
		helper = new MimeMessageHelper(message, true);
		{
			helper.setFrom(from);
			helper.setTo(recipient);
			helper.setSubject(sub);
			String content = gc(
					TemplateInfo.REGISTER_CONFIRMED
							.fill("email", "1635276937@qq.com")
							.fill("link", "https://www.baidu.com")
			);
			helper.setText(content, true);
		}
	} catch (MessagingException e) {
		throw new RuntimeException();
	}

	sender.send(message);
}

private String gc(TemplateInfo templateInfo) {
	return gc(templateInfo.getName(), templateInfo.getMap());
}

/**
 * 读取模板 填充后返回模板字符串
 *
 * @param tempPath 模板路径
 * @param map      数据表
 * @return 模板字符串
 */
private String gc(String tempPath, Map<String, Object> map) {
	try (StringWriter writer = new StringWriter()) {
		Template template = freemarkerConfig.getTemplate(tempPath);
		template.process(map, writer);
		return writer.toString();
	} catch (IOException | TemplateException e) {
		throw new RuntimeException(e);
	}
}

}
