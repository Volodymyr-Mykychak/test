package mate.academy.webintro.service;

import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    List<EmployeeDto> findAll();


}
