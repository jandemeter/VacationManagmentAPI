package com.assignment.Assignment.service;

import com.assignment.Assignment.controller.Request.VacationRequest;
import com.assignment.Assignment.entity.Employee;
import com.assignment.Assignment.entity.Vacation;
import com.assignment.Assignment.repository.EmployeeRepository;
import com.assignment.Assignment.repository.VacationRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class VacationService {

    @Autowired
    VacationRepository vacationRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Vacation> getAllVacations() {
        return this.vacationRepository.findAll();
    }

    public Optional<Vacation> getVacation(Long id) throws BadRequestException {
        if(!vacationRepository.existsById(id)){
            throw new BadRequestException("Vacation with ID " + id + " not found");

        }
        return this.vacationRepository.findById(id);
    }

    public List<Vacation> getVacationsByEmployeeId(Long employeeId) throws BadRequestException {
        if(!employeeRepository.existsById(employeeId)){
            throw new BadRequestException("Employee with ID" + employeeId + "not found");
        }
        return vacationRepository.findByCreatedBy_Id(employeeId);
    }

    public Vacation saveVacation(VacationRequest request) throws BadRequestException {

        Employee createdBy = employeeRepository.findById(request.getCreatedById())
                .orElseThrow(() -> new BadRequestException("Employee with ID" + request.getCreatedById() + "not found"));

        Vacation vacation = new Vacation();
        Long dateDuration = ChronoUnit.DAYS.between(request.getFromDate(), request.getToDate());
        vacation.setDateDuration(dateDuration);
        vacation.setCreateDate(LocalDate.now());
        vacation.setApproved(false);
        vacation.setFromDate(request.getFromDate());
        vacation.setFromDaypart(request.getFromDaypart());
        vacation.setToDate(request.getToDate());
        vacation.setToDaypart(request.getToDaypart());
        vacation.setCreatedBy(createdBy);
        vacation.setApprovedBy(null);

        return vacationRepository.save(vacation);
    }

    public String deleteVacation(Long id) throws BadRequestException {
        if(!vacationRepository.existsById(id)){
            throw new BadRequestException("Vacation with ID " + id + " not found");
        }
        this.vacationRepository.deleteById(id);
        return "deleted";
    }
}
