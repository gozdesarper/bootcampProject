package com.kodlamaio.bootCampProject.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.BlackListService;
import com.kodlamaio.bootCampProject.business.request.blackList.CreatBlackListRequest;
import com.kodlamaio.bootCampProject.business.request.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootCampProject.business.response.blackList.CreateBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.GetAllBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.GetBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/blacklist")
@AllArgsConstructor
public class BlackListController {
	private BlackListService blackListService;
	
	@PostMapping("")
	public DataResult<CreateBlackListResponse> add(@RequestBody CreatBlackListRequest creatBlackListRequest) {
		return this.blackListService.add(creatBlackListRequest);
	}
	@PutMapping("") 
	public DataResult<UpdateBlackListResponse> update(@RequestBody UpdateBlackListRequest updateBlackListRequest) {
		return this.blackListService.update(updateBlackListRequest);
	}
	@GetMapping("/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id) {
		return this.blackListService.getById(id);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.delete(id);
	}
	@GetMapping()
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		return this.blackListService.getAll();
	}
	
}
