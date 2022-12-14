package tech.getarrays.employeemanager;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
  private final EmployeeService employeeService;

  public EmployeeResource(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    List<Employee> employees = employeeService.findAllEmployees();
    return ResponseEntity.ok(employees);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
    Employee employee = employeeService.findEmployeeById(id);
    return ResponseEntity.ok(employee);
  }

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    Employee newEmployee = employeeService.addEmployee(employee);
    return ResponseEntity.ok(newEmployee);
  }

  @PutMapping("/update")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
    Employee updateEmployee = employeeService.updateEmployee(employee);
    return ResponseEntity.ok(updateEmployee);
  }

  @Transactional
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
    employeeService.deleteEmployee(id);
    return ResponseEntity.ok().build();
  }
}
