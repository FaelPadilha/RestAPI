package br.com.faelpf.restapi.controller;

import br.com.faelpf.restapi.model.Employee;
import br.com.faelpf.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService _employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(_employeeService.all());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(_employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(_employeeService.save(employee));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(_employeeService.update(id, employee));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        _employeeService.delete(id);
    }

}
