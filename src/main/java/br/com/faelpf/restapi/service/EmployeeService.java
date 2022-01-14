package br.com.faelpf.restapi.service;

import br.com.faelpf.restapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> all();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    Employee update(Long id, Employee employee);
    void delete(Long id);

}
