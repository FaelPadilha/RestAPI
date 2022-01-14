package br.com.faelpf.restapi.service.impl;

import br.com.faelpf.restapi.exception.EmployeeNotFoundException;
import br.com.faelpf.restapi.model.Employee;
import br.com.faelpf.restapi.repository.EmployeeRepository;
import br.com.faelpf.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository _employeeRepository;

    @Override
    public List<Employee> all() {
        return _employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {

        Optional<Employee> employee = _employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee;
        }

        throw new EmployeeNotFoundException("Employee not found with id " + id);

    }

    @Override
    public Employee save(Employee employee) {
        return _employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee newEmployee) {

        Optional<Employee> oldEmployee = _employeeRepository.findById(id);

        if (oldEmployee.isPresent()) {

            Employee employee = oldEmployee.get();
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());

            return _employeeRepository.save(employee);

        }

        throw new EmployeeNotFoundException("Employee not found with id " + id);

    }

    @Override
    public void delete(Long id) {
        _employeeRepository.deleteById(id);
    }

}
