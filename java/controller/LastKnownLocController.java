package controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/LastKnownLocation")
@OpenAPIDefinition(info = @Info(title = "LostPerson service"), servers = {
@Server(url = "http://localhost:8080",description = "local server.")})
@Validated
public interface LastKnownLocController<LastKnownLocation, LastKnownLocationRequest> {
	//@formatter:off
	@Operation(
			summary = "Create a LastKnownLocation",
			description = "returns the created LastKnownLocation",
			responses = {
					@ApiResponse(
							responseCode = "201", 
							description = "The created LastKnownLocation is returned", 
							content = @Content(mediaType = "application/json",
							schema =@Schema(implementation = LastKnownLocController.class))),						
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")
							),
					@ApiResponse(
							responseCode = "404", 
							description = "A LastKnownLocation component was not found with the input criteria", 
							content = @Content(mediaType = "application/json")
							),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred",
							content = @Content(mediaType = "application/json")
							)
			},
			parameters = {
					@Parameter(
							name = "LastKnownLocationRequest", 
							required = true,
							description = "The LastKnownLocation as JSON"),
			}
			)
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  LastKnownLocation createLastKnownLocation(
			  @Valid@RequestBody LastKnownLocationRequest LastKnownLocationRequest 
			  );
       //@formatter:on

}