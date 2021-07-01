package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Article;
import model.User;
import repository.ArticleRepository;

@Path("/article")
public class ArticleService {

	User loggedUser;
	
	

	@GET
	@Path("/getAllArticle")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllArticle() {
		ArrayList<Article> articles = ArticleRepository.GetAllArticle();
		return Response.status(200).entity(articles).build();
	}
	
	@POST
	@Path("/saveArticle")
	public Response saveArticle(Article article) throws IOException {	
		System.out.println("Service za snimanje articla..");
			
		if(ArticleRepository.UniqueName(article.getName()))
		{		Article a = ArticleRepository.saveArticle(article);
				return Response.status(200).entity(a).build();
		}		
		return Response.status(400).entity("Name alerady exista! Please insert another one!.").build();
			
	}
	
	@POST
	@Path("/editArticle")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Edit(HashMap<String, String> data)
	{
		System.out.println("Edit controller article!");
		System.out.println("podatci" + data);
		/*if (GetLoggedUser() == null) {
			return Response.status(403).entity(HelpersMethods.GetJsonValue("Unauthorized")).build();
		}
		else
		{*/
			Article ar = ArticleRepository.editArticle(data);			
			return Response.status(200).entity(ar).build();
		//}
			
	}
	

	@POST
	@Path("/getArticleByIDRest")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticleByIDRest(HashMap<String, String> id) {
		ArrayList<Article> articles = ArticleRepository.getAllArticleByIDRestaurant(Integer.parseInt(id.get("idRestaurant")));
		return Response.status(200).entity(articles).build();
	}
	
	
	
}
