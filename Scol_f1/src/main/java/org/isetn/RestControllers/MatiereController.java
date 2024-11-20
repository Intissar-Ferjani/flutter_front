package org.isetn.RestControllers;

import java.util.List;
import java.util.Optional;

import org.isetn.entities.Departement;
import org.isetn.entities.Matiere;
import org.isetn.repository.DepartementRepository;
import org.isetn.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matiere")
public class MatiereController {

	
	@Autowired
	private MatiereRepository matRepository;

	@PostMapping("/add")
	public Matiere add(@RequestBody Matiere m ) {

		return matRepository.save(m);
	}

	@GetMapping("/all")
	public List<Matiere> getAll() {
		return matRepository.findAll();
	}
	/*
	@GetMapping("/findByClasseId/{id}")
	public List<Departement> getByDepartementId(@PathVariable Long id) {
		return depRepository.findByDepartementCodClass(id);
	}*/
	
	@GetMapping("/get/{id}")
	public Optional<Matiere> getById(@PathVariable Long id) {
		return matRepository.findById(id);
	}
	
	
	
	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id)
	{
		Matiere m =  matRepository.findById(id).get();
		matRepository.delete(m);
	}
	
	@PutMapping("/update")
	public Matiere update(@RequestBody Matiere m) {
		return matRepository.save(m);
	}
	
	
}
