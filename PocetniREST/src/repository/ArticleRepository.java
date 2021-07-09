package repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import helpers.LocalVariables;
import model.Article;
import model.FoodType;
import model.Quantity;

public class ArticleRepository {
	
	public static ObjectMapper objMapper = new ObjectMapper();
	public static String pathArticle = LocalVariables.ROOT_PATH + "\\PocetniREST\\WebContent\\files\\article.json";

	public static ArrayList<Article> GetAllArticle() {

		try {
			ArrayList<Article> a = new ArrayList<Article>(
					Arrays.asList(objMapper.readValue(Paths.get(pathArticle).toFile(), Article[].class)));

			return a;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Article saveArticle(Article articleDTO) throws IOException
	{		
		System.out.println("Saving the article..");
		 int id = GetAllArticle().size() + 1;
		 
		 for (Article r : GetAllArticle()) {
			 if(r.getIdArticle() == id)
			 {
				 id++;
			 }			
		}		
		ArrayList<Article> articles = GetAllArticle();		
		Article a = new Article(id,
				articleDTO.getName(),
				articleDTO.getType(),
				articleDTO.getIdRestaurant(),
				articleDTO.getQuantity(),
				articleDTO.getQunatityNum(),
				articleDTO.getPrice(),
				articleDTO.getDescription(),
				articleDTO.getPicture()				
				);
		
		articles.add(a);
		objMapper.writeValue(Paths.get(pathArticle).toFile(), articles);
		
		return a;
		
	}
	
	public static Article editArticle(HashMap<String,String> article)
	{
		ArrayList<Article> newArtList = GetAllArticle();
		Article edited = new Article();
		try
		{
			for(Article a : newArtList)
			{
				if(a.getIdArticle() == Integer.parseInt(article.get("idArticle")))
				{
					a.setName(article.get("name"));
					a.setDescription(article.get("description"));
					a.setQunatityNum(Double.parseDouble(article.get("qunatityNum")));
					a.setPrice(Double.parseDouble(article.get("price")));
					a.setPicture(article.get("picture"));
					a.setIdRestaurant(Integer.parseInt(article.get("idRestaurant")));
					
					if(article.get("type").equals("FOOD"))
						a.setType(FoodType.FOOD);
					else
						a.setType(FoodType.DRINK);
					
					if(article.get("quantity").equals("ML"))
						a.setQuantity(Quantity.ML);
					else
						a.setQuantity(Quantity.G);
					
					edited = a;
					break;
					
				}
			}
			
			objMapper.writeValue(Paths.get(pathArticle).toFile(), newArtList);
			return edited;	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean UniqueName(String name)
	{
		for(Article a : GetAllArticle())
		{
			if(a.getName().equals(name))
			{
				System.out.println("Name nije uniq.");
				return false;				
			}
		}		
		return true;
	}
	
	public static ArrayList<Article> getAllArticleByIDRestaurant(int id)
	{
		ArrayList<Article> restaurantArticle = new ArrayList<Article>();
		
		for(Article a : GetAllArticle())
		{
			if(a.getIdRestaurant() == id)
			{
				restaurantArticle.add(a);
			}
		}
		
		return restaurantArticle;
	}
	

}
