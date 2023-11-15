package in.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Plan;
import in.ashokit.service.PlanService;

@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;
	
	@GetMapping("/getCategories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		Map<Integer, String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories,HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		
		boolean recordStatus = planService.upsertPlan(plan);
		String statusMessage;
		if(recordStatus)
			statusMessage= "Record Saved Successfully";
		else
			statusMessage= "Record not saved";
		return new ResponseEntity<String>(statusMessage,HttpStatus.CREATED);	
	}
	
	@PostMapping("/updatePlan")
	public ResponseEntity<String> UpdatePlan(@RequestBody Plan plan){
		
		boolean recordStatus = planService.upsertPlan(plan);
		String statusMessage;
		if(recordStatus)
			statusMessage= "Record Updated Successfully";
		else
			statusMessage= "Record not Updated";
		return new ResponseEntity<String>(statusMessage,HttpStatus.OK);	
	}
	
	@GetMapping("/getAllPlans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/updatePlan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(plan,HttpStatus.OK);
	}
	@DeleteMapping("/deletePlan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId)
	{
		boolean isDeleted = planService.deletePlanById(planId);
		String deleteSatusString="";
		if(isDeleted)
			deleteSatusString="Plan Got deleted";
		else
			deleteSatusString="Record not dleted";
		return new ResponseEntity<String>(deleteSatusString,HttpStatus.OK);
	}
	@PutMapping("/status-change/{id}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer id,@PathVariable String status){
		boolean planStatusChange = planService.planStatusChange(id, status);
		String msg="";
		if(planStatusChange)
			msg="status changed";
		else
			msg="status not changed";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
