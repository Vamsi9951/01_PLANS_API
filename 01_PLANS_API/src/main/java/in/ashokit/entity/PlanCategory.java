package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class PlanCategory {

	@Id
	@GeneratedValue
	private Integer categoryId;
	private String categoryName;
	
	private String activeSw;
	
	private String createdBy;
	private String updatedBy;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	
	
	public PlanCategory() {
		super();
	}



	public PlanCategory(Integer categoryId, String categoryName, String activeSw, String createdBy, String updatedBy,
			LocalDate createdDate, LocalDate updatedDate) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.activeSw = activeSw;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}



	public Integer getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getActiveSw() {
		return activeSw;
	}



	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public LocalDate getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	public LocalDate getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
