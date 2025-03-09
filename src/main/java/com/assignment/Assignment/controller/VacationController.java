package com.assignment.Assignment.controller;

import com.assignment.Assignment.controller.Request.VacationRequest;
import com.assignment.Assignment.entity.Vacation;
import com.assignment.Assignment.service.VacationService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/vacation")
public class VacationController {

    @Autowired
    VacationService vacationService;

    @GetMapping
    public List<Vacation> getVacations(){
        return this.vacationService.getAllVacations();
    }

    @GetMapping("/{id}")
    public Optional<Vacation> getVacation(@PathVariable("id") Long vacationId) throws BadRequestException {
        return this.vacationService.getVacation(vacationId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Vacation> getVacationsByEmployeeId(@PathVariable Long employeeId) throws BadRequestException {
        return this.vacationService.getVacationsByEmployeeId(employeeId);
    }

    @PostMapping
    public Vacation saveVacation(@RequestBody @Valid VacationRequest vacationRequest) throws BadRequestException {
        return this.vacationService.saveVacation(vacationRequest);
    }

    @PostMapping("/{id}")
    public String deleteVacation(@PathVariable("id") Long vacationId) throws BadRequestException {
        return this.vacationService.deleteVacation(vacationId);
    }
}
