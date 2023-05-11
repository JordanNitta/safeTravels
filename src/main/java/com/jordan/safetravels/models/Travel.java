package com.jordan.safetravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "travel")

public class Travel {
//	Will be our primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Expense name is required")
	@Size(min = 3, max = 20, message = "Expense name must be between 3 and 20 characters")
	private String expensesName;

	@NotBlank(message = "Vendor is required")
	@Size(min = 3, max = 30, message = "Vendor must be between 3 and 30 characters")
	private String vendor;

	@NotNull(message = "Amount is required")
	@Min(value = 1, message = "Amount must be at least 1")
	private Double amount;

	@NotBlank(message = "Description is required")
	@Size(min = 3, max = 300, message = "Description must be between 3 and 300 characters")
	private String description;

	@Column(updatable = false)

//	Created at and updated at
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Travel() {

	}

	public Travel(
		    @NotBlank
		    @Size(min = 3, max = 20, message = "Expense name must be between 3 and 20 characters")
		    String expensesName,
		    
		    @NotBlank
		    @Size(min = 3, max = 30, message = "Vendor name must be between 3 and 30 characters")
		    String vendor,
		    
		    @NotNull
		    @Min(value = 1, message = "Amount must be a positive number")
		    Double amount,
		    
		    @NotBlank
		    @Size(min = 3, max = 300, message = "Description must be between 3 and 300 characters")
		    String description
		) {
		    this.expensesName = expensesName;
		    this.vendor = vendor;
		    this.amount = amount;
		    this.description = description;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpensesName() {
		return expensesName;
	}

	public void setExpensesName(String expensesName) {
		this.expensesName = expensesName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// Pulls the current date
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	// Pulls the update and will save the updated at time
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
