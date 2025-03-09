package com.assignment.Assignment.controller;

import com.assignment.Assignment.entity.Employee;
import com.assignment.Assignment.entity.Team;
import com.assignment.Assignment.service.EmployeeService;
import com.assignment.Assignment.service.TeamService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @ResponseBody
    public List<Team> getAllTeams() {
        return this.teamService.getAllTeams();
    }

    @PostMapping
    @ResponseBody
    public Team saveTeam(@RequestBody @Valid Team team) {
        return this.teamService.saveTeam(team);
    }

    @GetMapping("/{teamId}/employees")
    @ResponseBody
    public List<Employee> getTeamEmployees(@PathVariable Long teamId) throws BadRequestException {
        return this.employeeService.getTeamEmployees(teamId);
    }
}
