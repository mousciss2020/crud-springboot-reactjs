package gn.mabc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class EmployeControler {

    @Autowired
    private EmployeRepos employeRepos;

    @GetMapping("/employes")
    public List<Employe> getAllEmployes(){
       return employeRepos.findAll();
    }
    @PostMapping(value = "/employes")
    public Employe createEmployes(@RequestBody Employe employe){
        return employeRepos.save(employe);
    }
    @GetMapping("/employes/{id}")
    public ResponseEntity<Employe> getemployes(@PathVariable  Long id){
        Employe employe = employeRepos.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employe not existe with "+id));
        return ResponseEntity.ok(employe);
    }
    @DeleteMapping("/employes/{id}")
    public void deleteEmploye(@PathVariable Long id){
        Employe employe = employeRepos.getOne(id);
        employeRepos.delete(employe);
    }

}
