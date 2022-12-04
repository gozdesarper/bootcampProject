package com.kodlamaio.bootCampProject.business.concrete;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootCampProject.business.abstracts.InstructorService;
import com.kodlamaio.bootCampProject.business.response.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootCampProject.business.constants.Messages;
import com.kodlamaio.bootCampProject.business.request.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootCampProject.business.request.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootCampProject.business.response.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootCampProject.business.response.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootCampProject.core.ultities.exception.BusinessException;
import com.kodlamaio.bootCampProject.core.ultities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.BootcampRepository;
import com.kodlamaio.bootCampProject.entities.Bootcamp;
import com.kodlamaio.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class BootcampManager implements BootcampService {
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	private InstructorService instructorService;

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest creatBootcampResquest) {
		checkIfBootcampExistInstructorId(creatBootcampResquest.getInstructorId());
		
		Bootcamp bootcamp = this.modelMapperService.forRequest().map(creatBootcampResquest, Bootcamp.class);
		bootcamp.setId(0);
		bootcampRepository.save(bootcamp);
		CreateBootcampResponse createBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				CreateBootcampResponse.class);
		return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.BootcampCreated);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
		checkIfBootcampExistId(updateBootcampRequest.getId());
		checkIfBootcampExistInstructorId(updateBootcampRequest.getInstructorId());
		Bootcamp bootcamp = this.modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
		bootcampRepository.save(bootcamp);
		UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(updateBootcampResponse, Messages.BootcamptUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfBootcampExistId(id);
		bootcampRepository.deleteById(id);
		return new SuccessResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		checkIfBootcampExistId(id);
		Bootcamp bootcamp = this.bootcampRepository.findById(id);
		GetBootcampResponse getBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(getBootcampResponse, Messages.BootcamptUpdated);
	}

	@Override
	public Bootcamp getByBootcampId(int bootcampId) { 
		return checkIfBootcampExistId(bootcampId);// returnde bu metodu dönüyoruz. aşağıda bu metotdan nul geliyorsa hata . değer geliyorsa getbybootcampId dönüyor.
	}

	@Override
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		List<Bootcamp> bootcamps = this.bootcampRepository.findAll();
		List<GetAllBootcampResponse> bootcampResponses = bootcamps.stream()
				.map(bootcamp -> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampResponse>>(bootcampResponses, Messages.BootcampListed);
	}

	private Bootcamp checkIfBootcampExistId(int id) {
		Bootcamp bootcamp = this.bootcampRepository.findById(id); //optional olduğu için olmadığı durumda hata fırlatıyor.
		if (bootcamp == null) {
			throw new BusinessException(Messages.BootcampUserNotfond);
		}
		return bootcamp;
}

	private void checkIfBootcampExistInstructorId(int instructorId) {
		Instructor instructor = this.instructorService.getByInstructorId(instructorId);
		if (instructor == null) {
			throw new BusinessException(Messages.BootcampInstructorId);
		}
	}
	@Override
	public void checkIfApplicationExistState(int bootcampId) {
		Bootcamp bootcamp = bootcampRepository.findById(bootcampId);
		if (bootcamp.getState() == 2) {
			throw new BusinessException(Messages.BootcampClosed);
		}
	}

}
