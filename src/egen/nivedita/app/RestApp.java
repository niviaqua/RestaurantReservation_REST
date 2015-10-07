package egen.nivedita.app;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class RestApp extends ResourceConfig {
	
	public RestApp() {
		packages("egen.nivedita.rest");
		
		 register(io.swagger.jaxrs.listing.ApiListingResource.class);
	     register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

	        
		BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("RestaurantReservation_RESTApp/api");
        beanConfig.setResourcePackage("egen.nivedita");
        beanConfig.setScan(true);
        beanConfig.setTitle("RESTApi Documentation by Nivedita Joshi");
        beanConfig.setDescription("This is a Swagger documentation backend API representation of my Restaurant Reservation System application");
	}
}
