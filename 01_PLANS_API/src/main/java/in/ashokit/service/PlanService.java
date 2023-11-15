package in.ashokit.service;

import java.util.List;
import java.util.Map;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;

public interface PlanService {

	
	public Map<Integer, String> getPlanCategories();

	public boolean upsertPlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(Integer planId);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer id,String activeSw);

}
