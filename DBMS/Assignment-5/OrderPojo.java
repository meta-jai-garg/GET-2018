import java.sql.Date;

/**
 * POJO to store order details such as orderId, orderDate, amount.
 */
public class OrderPojo {
	private int orderId;
	private Date orderDate;
	private double amount;

	public int getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderPojo [orderId=" + orderId + ", orderDate=" + orderDate
				+ ", amount=" + amount + "]";
	}
}
