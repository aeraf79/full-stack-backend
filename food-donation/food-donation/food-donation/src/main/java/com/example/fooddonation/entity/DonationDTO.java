package com.example.fooddonation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "donation")
public class DonationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String donationType;
    private String foodName;
    private String mealType;
    private String category;
    private String quantity;

    private LocalDateTime donatedDate;
    private LocalDateTime expiryDateTime;

    private String city;
    private String amount;
    private String clothesType;
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "ngo_id")
    @JsonIgnoreProperties({"donations"})
    private NgoDTO ngo;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    @JsonIgnoreProperties({"donations"})
    private DonorDTO donor;


    @PrePersist
    public void setTimestamp() {
        this.donatedDate = LocalDateTime.now();
    }

    public DonationDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getDonatedDate() {
		return donatedDate;
	}

	public void setDonatedDate(LocalDateTime donatedDate) {
		this.donatedDate = donatedDate;
	}

	public LocalDateTime getExpiryDateTime() {
		return expiryDateTime;
	}

	public void setExpiryDateTime(LocalDateTime expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getClothesType() {
		return clothesType;
	}

	public void setClothesType(String clothesType) {
		this.clothesType = clothesType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public NgoDTO getNgo() {
		return ngo;
	}

	public void setNgo(NgoDTO ngo) {
		this.ngo = ngo;
	}

	public DonorDTO getDonor() {
		return donor;
	}

	public void setDonor(DonorDTO donor) {
		this.donor = donor;
	}

    // Getters & Setters
    // ... (keep same)
}
