package com.zensar.olx.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.olx.bean.AdvertisementPost;
import com.zensar.olx.bean.AdvertisementStatus;
import com.zensar.olx.bean.Category;
import com.zensar.olx.bean.NewAdvertisementPostRequest;
import com.zensar.olx.bean.NewAdvertisementPostResponse;
import com.zensar.olx.bean.OLXUser;
import com.zensar.olx.service.AdvertisementPostService;

@RestController
public class AdvertisementPostController {

	@Autowired
	AdvertisementPostService service;

	@PostMapping("/advertise/{un}")
	public NewAdvertisementPostResponse add(@RequestBody NewAdvertisementPostRequest request,
			@PathVariable(name = "un") String userName) {

		AdvertisementPost post = new AdvertisementPost();
		post.setTitle(request.getTitle());
		post.setPrice(request.getPrice());
		post.setDescription(request.getDescription());

		int categoryId = request.getCategoryId();
		RestTemplate restTemplate = new RestTemplate();
		Category category;
		String url = "http://localhost:9052/advertise/status/" + categoryId;
		category = restTemplate.getForObject(url, Category.class);
		post.setCategory(category);

		url = "http://localhost:9051/user/find/" + userName;
		OLXUser olxUser = restTemplate.getForObject(url, OLXUser.class);
		post.setOlxUser(olxUser);

		AdvertisementStatus advertisementStatus = new AdvertisementStatus(2, "CLOSED");
		post.setAdvertisementStatus(advertisementStatus);

		AdvertisementPost advertisementPost = this.service.addAdvertisementPost(post);

		NewAdvertisementPostResponse response = new NewAdvertisementPostResponse();
		response.setId(advertisementPost.getId());
		response.setTitle(advertisementPost.getTitle());
		response.setPrice(advertisementPost.getPrice());
		response.setCategory(advertisementPost.getCategory().getName());
		response.setDescription(advertisementPost.getDescription());
		response.setUserName(advertisementPost.getOlxUser().getUserName());
		response.setCreatedDate(advertisementPost.getCreatedDate());
		response.setModifiedDate(advertisementPost.getModifiedDate());
		response.setStatus(advertisementPost.getAdvertisementStatus().getStatus());
		return response;
	}

	@PutMapping("/advertise/{id}/{userName}")
	public NewAdvertisementPostResponse update(@RequestBody NewAdvertisementPostRequest request,
			@PathVariable(name = "id") int id, @PathVariable(name = "userName") String userName) {
		AdvertisementPost post = this.service.getAdvertisementById(id);
		post.setTitle(request.getTitle());
		post.setDescription(request.getDescription());
		post.setPrice(request.getPrice());

		RestTemplate restTemplate = new RestTemplate();

		Category category;
		String url = "http://localhost:9052/advertise/status/" + request.getCategoryId();
		category = restTemplate.getForObject(url, Category.class);
		post.setCategory(category);

		url = "http://localhost:9051/user/find/" + userName;
		OLXUser olxUser = restTemplate.getForObject(url, OLXUser.class);
		post.setOlxUser(olxUser);

		url = "http://localhost:9052/advertisementStatus/getStatus/" + request.getStatusId();
		AdvertisementStatus advertisementStatus;
		advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
		post.setAdvertisementStatus(advertisementStatus);

		AdvertisementPost advertisementPost = this.service.updateAdvertisementPost(post); // update

		NewAdvertisementPostResponse response;
		response = new NewAdvertisementPostResponse();

		response.setId(advertisementPost.getId());
		response.setTitle(advertisementPost.getTitle());
		response.setDescription(advertisementPost.getDescription());
		response.setPrice(advertisementPost.getPrice());
		response.setUserName(advertisementPost.getOlxUser().getUserName());
		response.setCategory(advertisementPost.getCategory().getName());
		response.setCreatedDate(advertisementPost.getCreatedDate());
		response.setModifiedDate(advertisementPost.getModifiedDate());
		response.setStatus(advertisementPost.getAdvertisementStatus().getStatus());

		return response;
	}

	@GetMapping("/user/advertise/{userName}")
	public List<NewAdvertisementPostResponse> getAllAdvertisements(@PathVariable(name = "userName") String userName) {

		List<NewAdvertisementPostResponse> allResponses = null;

		List<AdvertisementPost> advertisementPosts = this.service.getAllAdvertisementPosts();

		String url = null;
		RestTemplate restTemplate = new RestTemplate();

		for (AdvertisementPost advertisementPost : advertisementPosts) {

			url = "http://localhost:9051/user/" + advertisementPost.getOlxUser().getId();
			OLXUser user = restTemplate.getForObject(url, OLXUser.class);

			if (user.getUserName().equals(userName)) {
				NewAdvertisementPostResponse response = new NewAdvertisementPostResponse();

				System.out.println(advertisementPost);

				response.setId(advertisementPost.getId());
				response.setTitle(advertisementPost.getTitle());
				response.setDescription(advertisementPost.getDescription());
				response.setPrice(advertisementPost.getPrice());

				url = "http://localhost:9051/user/find/" + userName;
				OLXUser olxUser = restTemplate.getForObject(url, OLXUser.class);
				advertisementPost.setOlxUser(olxUser);
				response.setUserName(advertisementPost.getOlxUser().getUserName());

				Category category;
				url = "http://localhost:9052/advertise/status/" + advertisementPost.getCategory().getId();
				category = restTemplate.getForObject(url, Category.class);
				advertisementPost.setCategory(category);
				response.setCategory(advertisementPost.getCategory().getName());

				response.setCreatedDate(advertisementPost.getCreatedDate());
				response.setModifiedDate(advertisementPost.getModifiedDate());

				url = "http://localhost:9052/advertisementStatus/getStatus/"
						+ advertisementPost.getAdvertisementStatus().getId();
				AdvertisementStatus advertisementStatus;
				advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
				advertisementPost.setAdvertisementStatus(advertisementStatus);
				response.setStatus(advertisementPost.getAdvertisementStatus().getStatus());

				allResponses.add(response);

			}

		}

		return allResponses;

	}

	@GetMapping("/user/advertise/{advertiseId}/{userName}")
	public List<NewAdvertisementPostResponse> getAllAdvertisementsById(@PathVariable(name = "advertiseId") int id,@PathVariable(name = "userName") String userName) {

		List<NewAdvertisementPostResponse> allResponses = new ArrayList<>();
		List<AdvertisementPost> allPosts = this.service.getAllAdvertisementPosts();

		RestTemplate restTemplate = new RestTemplate();
		String url = null;

		for (AdvertisementPost advertisementPost : allPosts) {

			url = "http://localhost:9051/user/find/" + userName;
			OLXUser olxUser = restTemplate.getForObject(url, OLXUser.class);

			if (olxUser.getUserName().equals(userName)) {

				if (advertisementPost.getId() == id) {

					NewAdvertisementPostResponse response = new NewAdvertisementPostResponse();

					response.setId(advertisementPost.getId());
					response.setTitle(advertisementPost.getTitle());
					response.setDescription(advertisementPost.getDescription());
					response.setPrice(advertisementPost.getPrice());

					advertisementPost.setOlxUser(olxUser);
					response.setUserName(advertisementPost.getOlxUser().getUserName());

					Category category;
					url = "http://localhost:9052/advertise/status/" + advertisementPost.getCategory().getId();
					category = restTemplate.getForObject(url, Category.class);
					advertisementPost.setCategory(category);
					response.setCategory(advertisementPost.getCategory().getName());

					response.setCreatedDate(advertisementPost.getCreatedDate());
					response.setModifiedDate(advertisementPost.getModifiedDate());

					url = "http://localhost:9052/advertisementStatus/getStatus/"
							+ advertisementPost.getAdvertisementStatus().getId();
					AdvertisementStatus advertisementStatus;
					advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
					advertisementPost.setAdvertisementStatus(advertisementStatus);
					response.setStatus(advertisementPost.getAdvertisementStatus().getStatus());
					allResponses.add(response);
				}

			}

		}

		return allResponses;

	}

	@DeleteMapping("/user/advertise/{advertiseId}/{userName}")
	public boolean delteAdvertisementById(@PathVariable(name = "advertiseId") int id,@PathVariable(name = "userName") String userName) {

		boolean res = false;

		// AdvertisementPost advertisementPost = this.service.getAdvertisementById(id);

		List<AdvertisementPost> allPosts = this.service.getAllAdvertisementPosts();

		RestTemplate restTemplate = new RestTemplate();
		String url = null;

		for (AdvertisementPost advertisementPost : allPosts) {

			url = "http://localhost:9051/user/find/" + userName;
			OLXUser olxUser = restTemplate.getForObject(url, OLXUser.class);
			if (olxUser.getUserName().equals(userName)) {

				if (advertisementPost.getId() == id) {

					res = this.service.deleteAdvertisementPost(advertisementPost);

				}
			}

		}
		return res;
	}

}
