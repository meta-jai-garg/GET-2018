package com.meta.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.meta.dao.AdvertisementDao;
import com.meta.model.Advertisement;

@Path("/advertisements")
public class AdvertisementResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAdvertisements() throws ClassNotFoundException, SQLException {
		AdvertisementDao AdvertisementDao = new AdvertisementDao();
		return AdvertisementDao.getAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAdvertisementsByCategoryId(@PathParam("id") int id)
			throws ClassNotFoundException, SQLException {
		AdvertisementDao AdvertisementDao = new AdvertisementDao();
		return AdvertisementDao.getAll(id);
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAdvertisement(Advertisement advertisement) throws ClassNotFoundException, SQLException {
		AdvertisementDao AdvertisementDao = new AdvertisementDao();
		AdvertisementDao.add(advertisement);
	}

	@PUT
	@Path("set")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setTitle(Advertisement advertisement) throws ClassNotFoundException, SQLException {
		AdvertisementDao AdvertisementDao = new AdvertisementDao();
		AdvertisementDao.setTitle(advertisement.getAdvId(), advertisement.getAdvTitle());
	}

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAdvertisement(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		AdvertisementDao AdvertisementDao = new AdvertisementDao();
		if (AdvertisementDao.remove(id))
			return Response.status(200).build();
		else
			return Response.status(201).build();
	}
}