package egen.nivedita.rest.controllers;

import java.util.List;


import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import egen.nivedita.dao.OwnerLoginDAO;

import egen.nivedita.exception.AppException;
import egen.nivedita.model.OwnerLogin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/ownerlogin")
@Api(tags = {"ownerlogin"})


public class OwnerLoginController {

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@ApiOperation(
				value= "Owner login", 
				notes= "Displays owner reservations credentials"
				)
		@ApiResponses(
				value= {
						@ApiResponse(code = 200, message="Success"),
						@ApiResponse(code = 404, message="Not Found"),
						@ApiResponse(code = 500, message="Internal Server Error")
				}
				)
		
		public List<OwnerLogin> findAll () {
			
			List<OwnerLogin> login = null;
			
			try {
				OwnerLoginDAO dao = new OwnerLoginDAO();
				login = dao.ownerLogin();
				
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			}
			return login;
		}
	}
