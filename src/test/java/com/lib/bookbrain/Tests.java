package com.lib.bookbrain;

import com.lib.bookbrain.configuration.SecurityConfiguration;
import com.lib.bookbrain.controller.TokenController;
import com.lib.bookbrain.controller.UserController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

/**
 * Tests for {@link 1}
 *
 * @author Josh Cummings
 */
@WebMvcTest({UserController.class, TokenController.class})
@Import(SecurityConfiguration.class)
public class Tests {
}