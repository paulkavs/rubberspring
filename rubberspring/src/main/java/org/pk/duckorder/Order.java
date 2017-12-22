package org.pk.duckorder;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

	@XmlAttribute
	private Integer clientId;
	@XmlAttribute
	private Integer quantity;
	@XmlAttribute
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
