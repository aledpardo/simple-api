package io.swagger.api;

import io.swagger.model.Body1;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse400;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Controller
public class LoginApiController implements LoginApi {



    public ResponseEntity<List<InlineResponse200>> loginUser(@ApiParam(value = "Dados de acesso do usuário" ,required=true ) @RequestBody Body1 body) {
        // do some magic!
        return new ResponseEntity<List<InlineResponse200>>(HttpStatus.OK);
    }

}
