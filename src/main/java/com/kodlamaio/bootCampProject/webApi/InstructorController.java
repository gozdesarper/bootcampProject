package com.kodlamaio.bootCampProject.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.InstructorService;
import com.kodlamaio.bootCampProject.business.request.instructor.CreateInstructorRequest;
import com.kodlamaio.bootCampProject.business.request.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootCampProject.business.response.instructor.CreatInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.GetInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {
	private InstructorService instructorService;
	
	
	@GetMapping("{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id){
		return this.instructorService.getById(id);
	}
	@DeleteMapping("{id}")
	Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}
	@PostMapping("/add")
	DataResult<CreatInstructorResponse> add(@RequestBody CreateInstructorRequest createInstructorRequest){
		return this.instructorService.add(createInstructorRequest);
	}
	@GetMapping("/getall")
	DataResult<List<GetAllInstructorResponse>> getAll(){
		return this.instructorService.getAll();
	}
	@PutMapping()
	DataResult<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest updateInstructorRequest){
		return this.instructorService.update(updateInstructorRequest);
	}
	
	

//	@PostMapping("/add")
//	CreatInstructorResponse add(CreateInstructorRequest creatInstructorRequest) {
//		return instructorService.add(creatInstructorRequest);
//	}
//
//	@GetMapping("/getall")
//	List<ListInstructorResponse> getAll() {
//		return instructorService.getAll();
//	}
//
//	@PutMapping("/update")
//	UpdateInstructorResponse update(UpdateInstructorRequest updateInstructorRequest) {
//		return instructorService.update(updateInstructorRequest);
//	}
//
//	@DeleteMapping("/delete")
//	DeleteInstructorResponse delete(DeleteInstructorRequest deleteInstructorRequest) {
//		return instructorService.delete(deleteInstructorRequest);
//	}
}
