package com.meta.resources;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
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
import com.meta.dao.CategoryDao;
import com.meta.model.Category;
import com.meta.model.ResponseBuilder;

@Path("/categories")
public class CategoryResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategories(@HeaderParam("authorization") String authKey)
			throws ClassNotFoundException, SQLException,
			JsonGenerationException, JsonMappingException, IOException {

		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		} else {
			CategoryDao categoryDao = new CategoryDao();
			ResponseBuilder response = new ResponseBuilder();
			response.setStatus(200);
			response.setPayload(categoryDao.getCategory());
			ObjectWriter ow = new ObjectMapper().writer()
					.withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(response);
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}
	}

	@GET
	@Path("{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategory(@HeaderParam("authorization") String authKey,
			@PathParam("categoryId") Integer id) throws ClassNotFoundException,
			SQLException, JsonGenerationException, JsonMappingException,
			IOException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		if (id != null) {
			CategoryDao categoryDao = new CategoryDao();
			ResponseBuilder response = new ResponseBuilder();
			response.setStatus(200);
			response.setPayload(categoryDao.getCategory(id));
			ObjectWriter ow = new ObjectMapper().writer()
					.withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(response);
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}

	@POST
	@Path("addCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCategory(@HeaderParam("authorization") String authKey,
			Category category) throws ClassNotFoundException, SQLException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		if (category.getCategoryName() != null) {
			CategoryDao CategoryDao = new CategoryDao();
			CategoryDao.add(category);
			return Response.ok("{\"success\":\"Added Successfully\"}").build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}

	@PUT
	@Path("updateCategoryName")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setName(@HeaderParam("authorization") String authKey,
			Category category) throws ClassNotFoundException, SQLException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		if (category.getCategoryId() != null
				&& category.getCategoryName() != null) {
			CategoryDao CategoryDao = new CategoryDao();
			CategoryDao.updateName(category.getCategoryId(),
					category.getCategoryName());
			return Response.ok("{\"success\":\"Update Successfully\"}").build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}

	@GET
	@Path("{id}/advertisements")
	@Produces()
	public Response getAdvertisementsByCategoryId(
			@HeaderParam("authorization") String authKey,
			@PathParam("id") Integer id) throws ClassNotFoundException,
			SQLException, JsonGenerationException, JsonMappingException,
			IOException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED)
					.entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		if (id != null) {
			AdvertisementDao advertisementDao = new AdvertisementDao();
			ResponseBuilder response = new ResponseBuilder();
			response.setStatus(200);
			response.setPayload(advertisementDao.getAdvertisementByCategory(id));
			ObjectWriter ow = new ObjectMapper().writer();
			String json = ow.writeValueAsString(response);
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
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