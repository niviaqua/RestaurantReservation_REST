package egen.nivedita.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import egen.nivedita.dao.ReservationDAO;
import egen.nivedita.dao.RestaurantProfileDAO;
import egen.nivedita.exception.AppException;
import egen.nivedita.model.RestaurantProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Path("/restaurant")
@Api(tags = {"restaurant"})

public class RestaurantProfileController {

	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@ApiOperation(
				value=  "Restaurant Profile Details", 
				notes= "Displays all the Restaurant Profile Details"
				)
		@ApiResponses(
				value= {
						@ApiResponse(code = 200, message="Success"),
						@ApiResponse(code = 500, message="Internal Server Error")
				}
				)
		
		public List<RestaurantProfile> findAll () {
			
			List<RestaurantProfile> restaurant = null;
			
			try {
				RestaurantProfileDAO dao = new RestaurantProfileDAO();
				restaurant = dao.profileDetails();
				//return dao.fetchAll();
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			}
			return restaurant;
		}
		
		
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@ApiOperation(
				value= "Modify Restaurant Profile", 
				notes= "Moddifies the restaurant profile with new information input by owner"
				)
		@ApiResponses(
				value= {
						@ApiResponse(code = 200, message="Successful in updating details"),
						@ApiResponse(code = 500, message="Internal Server Error")
						}
				)
		public RestaurantProfile update(RestaurantProfile restaurant) throws AppException {

			try{
			
				RestaurantProfileDAO dao = new RestaurantProfileDAO();
				restaurant = dao.update(restaurant);
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}	
			return restaurant;
		}
}
