package io.rspndr.interview.rest;

import io.rspndr.interview.model.Assignment;
import io.rspndr.interview.model.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentsRestController {

    private final AssignmentService assignmentService;

    @GetMapping("{id}")
    public Assignment getAssignment(@PathVariable UUID id) {
        return assignmentService.getById(id);
    }

    @GetMapping("company/{companyCode}")
    public List<Assignment> getAssignments(@PathVariable String companyCode) {
        return assignmentService.getByCompanyCode(companyCode);
    }
}
