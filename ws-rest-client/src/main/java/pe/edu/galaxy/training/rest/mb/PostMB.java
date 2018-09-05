package pe.edu.galaxy.training.rest.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import pe.edu.galaxy.training.rest.bean.Post;
import pe.edu.galaxy.training.rest.util.UtilREST;

@ManagedBean(name = "postMB")
public class PostMB {

	String uri = "https://jsonplaceholder.typicode.com/posts";

	private Post[] posts;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public void listar() {
		try {
			Gson gson = new Gson();
			posts = gson.fromJson(UtilREST.getREST(uri), Post[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Post[] getPosts() {
		return posts;
	}

	public void setPosts(Post[] posts) {
		this.posts = posts;
	}

}
