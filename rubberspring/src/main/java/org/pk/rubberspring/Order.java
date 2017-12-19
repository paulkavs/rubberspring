package org.pk.rubberspring;

import java.time.LocalDateTime;

public class Order {

	private Integer clientId;
	private Integer quantity;
	private LocalDateTime timestamp;

	public Order() {
	}

	public Order(Integer clientId, Integer quantity, LocalDateTime timestamp) {
		this.clientId = clientId;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Order [clientId=" + clientId + ", quantity=" + quantity + ", timestamp=" + timestamp + "]";
	}

}
