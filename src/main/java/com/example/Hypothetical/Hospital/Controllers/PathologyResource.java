package com.example.Hypothetical.Hospital.Controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hypothetical.Hospital.Model.Disease;
import com.example.Hypothetical.Hospital.Model.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	List <Disease> diseases = Arrays.asList(
			new Disease("D1", "Ashma", "Water bath"),
			new Disease("D2", "Thyphoid", "Ampicilin Capsule!"));
			
	
	@RequestMapping("/diseases")
public DiseasesList getEmployee() {
		
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDiseases(diseases);
		return diseasesList;
	}
	
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id){
		Disease d = diseases.stream()
				.filter(disease -> Id.equals(disease.getId()))
				.findAny()
				.orElse(null);
		return d;
	}
	
}


