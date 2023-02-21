package wiki.cloudnative.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import wiki.cloudnative.data.Salesperson;
import wiki.cloudnative.data.SalespersonRepository;

@Controller
public class SalespersonController {

    private final SalespersonRepository salespersonRepository;

    public SalespersonController(SalespersonRepository salespersonRepository) {
        this.salespersonRepository = salespersonRepository;
    }

    @QueryMapping
    public Iterable<Salesperson> salespeople(){
        return this.salespersonRepository.findAll();
    }

    @QueryMapping
    public Salesperson salespersonById(@Argument Long id){
        return this.salespersonRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Salesperson salespersonByEmail(@Argument String email){
        return this.salespersonRepository.findSalespersonByEmail(email);
    }
}
