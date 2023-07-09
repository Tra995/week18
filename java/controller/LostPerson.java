package controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import lostapplication.Person;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;


@RequestMapping("/person")
@OpenAPIDefinition(info = @Info(title = "Person information"), servers = {
@Server(url = "http://localhost:8080",description = "local server.")})
public interface LostPerson {
	//@formatter:off
		@Operation(
				summary = "Returns a list of person information",
				description = "returns a list of person information given personId and homeProvinceId and gender",
				responses = {
						@ApiResponse(
								responseCode = "200", 
								description = "A list of person information is returned", 
								content = @Content(mediaType = "application/json",
								schema =@Schema(implementation = LostPerson.class))),						
						@ApiResponse(
								responseCode = "400", 
								description = "The request parameters are invalid", 
								content = @Content(mediaType = "application/json")
								),
						@ApiResponse(
								responseCode = "404", 
								description = "No Person was found with the input", 
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
								name = "personId", 
								allowEmptyValue = false, 
								required = false,
								description = "The personId is (i.e,,'Lenny')"),
						@Parameter(
								name = "homeProvinceId", 
								allowEmptyValue = false,
								description = "The StateId is (i.e,,'Minnesota')"),
						@Parameter(
								name = "gender", 
								allowEmptyValue = false,
								description = "The gender is (i.e,,'male')")
				}
				)
		  @GetMapping
		  @ResponseStatus(code = HttpStatus.OK)
		  List<LostPerson> fetchLostPerson(
				  @RequestParam String personId, 
		          @RequestParam String homeStateId,
		          @RequestParam String gender
		          );
	       //@formatter:on

		static Object getLostpersonPK() {
			// TODO Auto-generated method stub
			return null;
		}
}