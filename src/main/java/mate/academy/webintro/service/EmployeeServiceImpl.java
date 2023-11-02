package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.mapper.EmployeeMapper;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto save(CreateEmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toModel(requestDto);
        employee.setSocialSecurityNumber("abc " + new Random().nextInt(1000));
        Employee saveEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(saveEmployee);
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map((Employee employeeDto) -> employeeMapper.toDto(employeeDto))
                .toList();
    }
}
