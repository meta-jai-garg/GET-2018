package com.meta.resources;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.meta.dao.AdvertisementDao;
import com.meta.model.Advertisement;
import com.meta.model.ResponseBuilder;

@Path("/advertisements")
public class AdvertisementResource {

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAdvertisement(
			@HeaderParam("authorization") String authKey,
			Advertisement advertisement) throws ClassNotFoundException,
			SQLException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		if (advertisement.getCategoryId() != null
				&& advertisement.getAdvDesc() != null
				&& advertisement.getAdvTitle() != null) {
			AdvertisementDao advertisementDao = new AdvertisementDao();
			if (advertisementDao.addAdvertisement(advertisement)) {
				return Response.ok("{\"success\":\"Added Successfully\"}")
						.build();
			} else {
				return Response
						.ok("{\"error\":\"Please try after some time\"}")
						.build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdvertisements(
			@HeaderParam("authorization") String authKey)
			throws ClassNotFoundException, SQLException,
			JsonGenerationException, JsonMappingException, IOException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		} else {
			AdvertisementDao advertisementDao = new AdvertisementDao();
			ResponseBuilder response = new ResponseBuilder();
			response.setStatus(200);
			response.setPayload(advertisementDao.getAll());
			ObjectWriter ow = new ObjectMapper().writer()
					.withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(response);
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}
	}
	
	@PUT
	@Path("updateAdvertisemnetName")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setTitle(@HeaderParam("authorization") String authKey,
			Advertisement advertisement) throws ClassNotFoundException,
			SQLException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		if (advertisement.getAdvId() != null
				&& advertisement.getAdvTitle() != null) {
			AdvertisementDao advertisementDao = new AdvertisementDao();
			if (advertisementDao.setTitle(advertisement.getAdvId(),
					advertisement.getAdvTitle())) {
				return Response.ok("{\"success\":\"Update Successfully\"}")
						.build();
			} else {
				return Response
						.ok("{\"error\":\"Please try after some time\"}")
						.build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}

	@DELETE
	@Path("deleteAdvertisement/{advId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAdvertisement(
			@HeaderParam("authorization") String authKey,
			@PathParam("advId") Integer advId) throws ClassNotFoundException,
			SQLException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		if (advId != null) {
			AdvertisementDao AdvertisementDao = new AdvertisementDao();
			if (AdvertisementDao.remove(advId)) {
				return Response.ok("{\"success\":\"Deleted Successfully\"}")
						.build();
			} else {
				return Response.ok("{\"error\":\"Please try after some time\"}").build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}

	/**
	 * helper method to authenticate client
	 * 
	 * @param authKey
	 *            is authorization key
	 * @return true if authorized
	 */
	private boolean isAuthentic(String authKey) {
		return "get-2018".equals(authKey);
	}
}