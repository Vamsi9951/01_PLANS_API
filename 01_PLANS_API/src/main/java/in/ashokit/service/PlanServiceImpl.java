package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;
import in.ashokit.repo.PlanCategoryRepo;
import in.ashokit.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private PlanCategoryRepo categoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
		
		List<PlanCategory> plansList = categoryRepo.findAll();
		
		Map<Integer,String> categoryMap =new HashMap<>();
		
		plansList.forEach(category->{
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
					
		});
		return categoryMap;
	}

	@Override
	public boolean upsertPlan(Plan plan) {
		
		
		Plan planResponse = planRepo.save(plan);
		
		/*
		 * if(planResponse.getPlanId()!=null) return true; else return false;
		 */
		//return planResponse.getPlanId() !=null ?true:false;
		
		return planResponse.getPlanId() !=null;
	}

	@Override
	public List<Plan> getAllPlans() {
	
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent())
			return findById.get();
		return null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		
		boolean status =false;
		
		try {
		planRepo.deleteById(planId);
		status=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer id, String activeSw) {
		Optional<Plan> findById = planRepo.findById(id);
		if(findById.isPresent())
		{
			Plan plan = findById.get();
			plan.setActiveSw(activeSw);
			planRepo.save(plan);
			return true;
		}
		
		return false;
	}

}
