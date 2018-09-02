package com.meta.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.meta.dao.CategoryDao;
import com.meta.model.Category;

@Path("/categories")
public class CategoryResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategories() throws ClassNotFoundException, SQLException {
		CategoryDao CategoryDao = new CategoryDao();
		return CategoryDao.getAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category getCategory(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		CategoryDao CategoryDao = new CategoryDao();
		return CategoryDao.get(id);
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCategory(Category category) throws ClassNotFoundException, SQLException {
		CategoryDao CategoryDao = new CategoryDao();
		CategoryDao.add(category);
	}

	@PUT
	@Path("set")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setName(Category category) throws ClassNotFoundException, SQLException {
		CategoryDao CategoryDao = new CategoryDao();
		CategoryDao.setName(category.getCategoryId(), category.getCategoryName());
	}
}