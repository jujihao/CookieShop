package entity;

public class OrderItem {
    private Integer orderItemId;

    private Integer cakeId;

    private Integer amount;

    private Integer orderId;

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getCakeId() {
		return cakeId;
	}

	public void setCakeId(Integer cakeId) {
		this.cakeId = cakeId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


}