package com.nikkmuc.rest.webservice.restfulwebservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/hello")
@Tag(name = "Hello")
@ApiResponse(content = @Content(mediaType = "text/plain",
        schema = @Schema(example = "Hello World")),
        responseCode = "200",
        description = "Successful Operation" )

public class HelloWorldController {

    @GetMapping
    @Operation(
            summary = "get a Hello World",
            description = "Returns a Hello World in text/plain.")
    public String helloWorld(){
        return "Hello World";
    }
}
