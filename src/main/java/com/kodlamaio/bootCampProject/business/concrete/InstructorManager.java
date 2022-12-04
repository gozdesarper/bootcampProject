package com.kodlamaio.bootCampProject.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.InstructorService;
import com.kodlamaio.bootCampProject.business.constants.Messages;
import com.kodlamaio.bootCampProject.business.request.instructor.CreateInstructorRequest;
import com.kodlamaio.bootCampProject.business.request.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootCampProject.business.response.instructor.CreatInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.GetInstructorResponse;
import com.kodlamaio.bootCampProject.business.response.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootCampProject.core.ultities.exception.BusinessException;
import com.kodlamaio.bootCampProject.core.ultities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.InstructorRepository;
import com.kodlamaio.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		chekIfInstructorId(id); 
		this.instructorRepository.deleteById(id);
		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<CreatInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
		checkIfInstructorNationalIdentity (createInstructorRequest.getNationalIdentity());
		Instructor instructor = modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
		instructorRepository.save(instructor);
		CreatInstructorResponse creatInstructorResponse = modelMapperService.forResponse().map(instructor,
				CreatInstructorResponse.class);
		return new SuccessDataResult<CreatInstructorResponse>(creatInstructorResponse, Messages.InstructorCreated);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = this.instructorRepository.findAll();
		List<GetAllInstructorResponse> response = instructors.stream()
				.map(instructor -> this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response,Messages.InstructorListed);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		chekIfInstructorId(updateInstructorRequest.getId()); 
		Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
		this.instructorRepository.save(instructor);
		UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(updateInstructorResponse, Messages.InstructorUpdated);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		chekIfInstructorId (id);
		Instructor instructor = this.instructorRepository.findById(id).get();
		GetInstructorResponse getInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				GetInstructorResponse.class);

		return new SuccessDataResult<GetInstructorResponse>(getInstructorResponse);
	}
	@Override
	public Instructor getByInstructorId(int InstructorId) {
		Instructor instructor= chekIfInstructorId(InstructorId);
		return instructor;
	}
	
	private void checkIfInstructorNationalIdentity (String nationalIdentitiy) {
		Instructor instructor = instructorRepository.findByNationalIdentity(nationalIdentitiy);
		if(instructor!=null) {
		throw new BusinessException(Messages.InstructorExist);
		}
	}
	private Instructor chekIfInstructorId (int id) {
		Instructor instructor = this.instructorRepository.findById(id).orElse(null);
		if(instructor==null) {
			throw new BusinessException(Messages.InstructortUserNotfond);
		} 
		return instructor;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public CreatInstructorResponse add(CreateInstructorRequest creatInstructorRequest) {
//		Instructor instructor = this.modelMapperService.forRequest().map(creatInstructorRequest, Instructor.class);
//		instructorRepository.save(instructor);
//		CreatInstructorResponse creatInstructorResponse = this.modelMapperService.forResponse().map(instructor, CreatInstructorResponse.class);
//		return creatInstructorResponse;
//	}
//
//	@Override
//	public List<ListInstructorResponse> getAll() {
//		List<ListInstructorResponse> listInstructorResponses = new ArrayList<ListInstructorResponse>();
//		List<Instructor> instructors = this.instructorRepository.findAll();
//		
//		for (Instructor instructor : instructors) {
//			ListInstructorResponse listInstructorResponse = this.modelMapperService.forResponse().map(instructor, ListInstructorResponse.class);
//			listInstructorResponses.add(listInstructorResponse);
//		}
//		return listInstructorResponses;
//	}
//
//	@Override
//	public UpdateInstructorResponse update(UpdateInstructorRequest updateInstructorRequest) {
//		Instructor instructor  = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
//		instructorRepository.save(instructor);
//		UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
//			return updateInstructorResponse;
//		
//	}
//
//	@Override
//	public DeleteInstructorResponse delete(DeleteInstructorRequest deleteInstructorRequest) {
//		Instructor instructor = this.instructorRepository.findById(deleteInstructorRequest.getId()).get();
//		instructorRepository.delete(instructor);
//		DeleteInstructorResponse deleteınstructorResponse = this.modelMapperService.forResponse().map(instructor,DeleteInstructorResponse.class);
//		return deleteınstructorResponse;
//		
//	}
//	

}
