package com.lib.bookbrain.constant;

public interface ConfigurationProperties {
String[] REQUEST_INTERCEPTOR_EXCLUDE = {
		"/users:login",
		"/users:register",
		"/",
		"/users/password:reset/email:sendResetLink"
};

}
