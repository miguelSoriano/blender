package globant.blender.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import globant.blender.dto.SocialEventsDTO;
import globant.blender.model.SocialEvent;
import globant.blender.services.LocationsService;
import globant.blender.services.SocialEventsService;
import globant.blender.services.UsersService;

@Api(name="Blender API", description = "Blender services")
@RestController
@RequestMapping("/blender")
public class BlenderController {
	
	   @Autowired
	   private LocationsService locationService;
	   
	   @Autowired
	   private SocialEventsService socialEventsService;
	   
	   @Autowired
	   private UsersService usersService;
	
	   private static final Logger LOG = LoggerFactory.getLogger(BlenderController.class);

		@ApiMethod(description = "Hello endpoint", verb = ApiVerb.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = {"application/json" })
		public @ApiResponseObject ResponseEntity<String> sayHi(
				@ApiPathParam(name="name") @PathVariable String name) {
			
			return new ResponseEntity<String>(name, HttpStatus.OK);
		}
		
		@ApiMethod(description = "Get Social Events", verb = ApiVerb.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@RequestMapping(value = "/socialEvents/", method = RequestMethod.GET, produces = {"application/json" })
		public @ApiResponseObject ResponseEntity<List<SocialEventsDTO>> getSocialEvents(){
							
			Stream<SocialEvent> userEntityStream = StreamSupport
					.stream(socialEventsService.getSocialEvents().spliterator(), false);

			List<SocialEventsDTO> lisSocialEventsDto = userEntityStream
					.map(SocialEventsDTO::new)
					.collect(Collectors.toList());

			return new ResponseEntity<List<SocialEventsDTO>>(lisSocialEventsDto, HttpStatus.OK);
		}
}	
