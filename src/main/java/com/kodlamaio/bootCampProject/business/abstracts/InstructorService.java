package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.request.instructor.CreateInstructorRequest;
import com.kodlamaio.bootCampProject.business.request.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootCampProject.business.response.instructor.CreatInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.GetInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.entities.users.Instructor;

public interface InstructorService {

//	CreatInstructorResponse add(CreateInstructorRequest creatInstructorRequest );
//	List<ListInstructorResponse> getAll();
//	UpdateInstructorResponse update(UpdateInstructorRequest updateInstructorRequest);
//	DeleteInstructorResponse delete(DeleteInstructorRequest deleteInstructorRequest);
//	

	Result delete(int id);

	DataResult<CreatInstructorResponse> add(CreateInstructorRequest createInstructorRequest);

	DataResult<List<GetAllInstructorResponse>> getAll();

	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);

	DataResult<GetInstructorResponse> getById(int id);

	Instructor getByInstructorId(int InstructorId);
}
