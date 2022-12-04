package com.kodlamaio.bootCampProject.webApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootCampProject.business.concrete.GetAllBootcampResponse;
import com.kodlamaio.bootCampProject.business.request.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootCampProject.business.request.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootCampProject.business.response.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootCampProject.business.response.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootCampProject.business.response.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampController {
	private BootcampService bootcampService;

	@PostMapping()
	public DataResult<CreateBootcampResponse> add(@Valid @RequestBody CreateBootcampRequest creatBootcampResquest) {
		return this.bootcampService.add(creatBootcampResquest);
	}

	@PutMapping()
	public DataResult<UpdateBootcampResponse> update(@Valid @RequestBody UpdateBootcampRequest updateBootcampRequest) {
		return this.bootcampService.update(updateBootcampRequest);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.bootcampService.delete(id);
	}

	@GetMapping("/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id) {
		return this.bootcampService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		return this.bootcampService.getAll();
	}
}
