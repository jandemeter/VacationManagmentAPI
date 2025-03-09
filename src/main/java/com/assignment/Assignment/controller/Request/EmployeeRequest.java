package com.assignment.Assignment.controller.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String nick;

    @NotNull
    private Long teamId;
}
