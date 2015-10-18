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
import egen.nivedita.exception.AppException;
import egen.nivedita.model.Reservation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/reservations")
@Api(tags = {"reservations"})
public class ReservationController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value= "Find all reservations", 
			notes= "Finds all reservations already made"
			)
	@ApiResponses(
			value= {
					@ApiResponse(code = 200, message="Success"),
					@ApiResponse(code = 500, message="Internal Server Error")
			}
			)
	
	public List<Reservation> findAll () {
		
		List<Reservation> reserve = null;
		
		try {
			ReservationDAO dao = new ReservationDAO();
			reserve = dao.fetchAll();
			//return dao.fetchAll();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reserve;
	}
	
	@GET
	@Path("/{confid}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value= "Find one reservations", 
			notes= "Finds one reservations with confid"
			)
	@ApiResponses(
			value= {
					@ApiResponse(code = 200, message="Success"),
					@ApiResponse(code = 500, message="Internal Server Error"),
					@ApiResponse(code = 404, message="Reservation not found")
			}
			)
	public Reservation findOne(@PathParam("confid") int confId) {
		
		Reservation res;
		
		try {
			ReservationDAO dao= new ReservationDAO();
			res= dao.fetchOne(confId);
			if(res == null ){
				throw new WebApplicationException(Status.NOT_FOUND);
			}
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value= "Creates one reservations", 
			notes= "Creates one reservations with autoincrement confid"
			)
	@ApiResponses(
			value= {
					@ApiResponse(code = 200, message="Successful in creating reservation"),
					@ApiResponse(code = 500, message="Internal Server Error")
					}
			)
	public Reservation create(Reservation res) {
	//	System.out.println("Inside createRes controller in" + res); 
	
		try {
			ReservationDAO dao= new ReservationDAO();
			 res=  dao.create(res);
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return res;
		
	}
	
	
	
	@DELETE
	@Path("/{confid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value= "Deletes one reservation", 
			notes= "Deletes one reservations with specified confid"
			)
	@ApiResponses(
			value= {
					@ApiResponse(code = 200, message="Successful in deleting reservation"),
					@ApiResponse(code = 500, message="Internal Server Error"),
					@ApiResponse(code = 404, message="Reservation not found")
					}
			)
		public Reservation delete(@PathParam("confid") int confid) {
		
		Reservation reserve;	
		try {
			ReservationDAO res = new ReservationDAO();
				reserve= res.delete(confid);
				
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			}	
		return reserve;
		}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value= "Modify a Reservation", 
			notes= "Moddifies the reservations with new information like new HostName, new Phone No., change in date/time, or number of people coming for the party"
			)
	@ApiResponses(
			value= {
					@ApiResponse(code = 200, message="Successful in updating reservation"),
					@ApiResponse(code = 500, message="Internal Server Error")
					}
			)
	public Reservation update(Reservation reservation) throws AppException {

		try{
		
			ReservationDAO dao = new ReservationDAO();
			reservation = dao.update(reservation);
		
	} catch (AppException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
	}	
		return reservation;
	}
}
