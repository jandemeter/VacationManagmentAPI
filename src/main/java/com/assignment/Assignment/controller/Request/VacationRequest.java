package com.assignment.Assignment.controller.Request;

import com.assignment.Assignment.entity.Dayparts;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VacationRequest {

    @NotNull
    private LocalDate fromDate;

    @NotNull
    private Dayparts fromDaypart;

    @NotNull
    private LocalDate toDate;

    @NotNull
    private Dayparts toDaypart;

    @NotNull
    private Long createdById;
}
