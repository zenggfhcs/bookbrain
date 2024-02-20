package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.security.MyAlgorithm;
import com.lib.bookbrain.utils.MyFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * test token controller
 *
 * @author yunxia
 */

@RestController
@RequestMapping("/token")
public class TokenController {
@PostMapping
public Response token(@RequestBody(required = false) Payload<TokenBody> payload) {
   return null;
}

@PostMapping
public String rsaPublic() {
   return MyFile.read(MyAlgorithm.rsaPubKeyFileName);
}
}
