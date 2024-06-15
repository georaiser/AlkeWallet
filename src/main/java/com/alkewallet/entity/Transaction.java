package com.alkewallet.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "LocalDateTime", nullable = false)
	private LocalDateTime date;
	@Column(name = "transaction_type", nullable = false)
	private String type;
	@Column(name = "amount", nullable = false)
	private double amount;
	@Column(name = "sourceAccount", nullable = true)
	private Long sourceAccount;
	@Column(name = "targetAccount", nullable = true)
	private Long targetAccount;
	
	public Transaction(LocalDateTime date, String type, double amount, Long sourceAccount, Long targetAccount) {
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
	}
	
	 // Method to get formatted date
    public String getFormattedDate() {
        if (this.date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return this.date.format(formatter);
        }
        return null;
    }
	
	
}
