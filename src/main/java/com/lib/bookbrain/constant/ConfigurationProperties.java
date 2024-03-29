package com.lib.bookbrain.constant;

public interface ConfigurationProperties {
String[] REQUEST_INTERCEPTOR_EXCLUDE = {
		"/login",
		"/register",
		"/verify",
		"/send/**",
		"/users/reset/**",
		"/test/**",
		"/upload/**",
		"/"
};

}
