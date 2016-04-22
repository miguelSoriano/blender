package globant.blender.controller;


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

import globant.blender.model.Locations;
import globant.blender.services.LocationsService;

@Api(name="Blender API", description = "Blender services")
@RestController
@RequestMapping("/blender")
public class BlenderController {
	
	   @Autowired
	   private LocationsService locationService;
	
		private static final Logger LOG = LoggerFactory.getLogger(BlenderController.class);

		@ApiMethod(description = "Hello endpoint", verb = ApiVerb.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = {"application/json" })
		public @ApiResponseObject ResponseEntity<String> sayHi(
				@ApiPathParam(name="name") @PathVariable String name) {

			Locations location = new Locations();
			location.setTitle("a");
			location.setDescription("b");
			
			locationService.persistLocation(location);
			
			return new ResponseEntity<String>(name, HttpStatus.OK);
		}
}	
