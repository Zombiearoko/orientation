package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentMethod")
public class PaymentMethod {
	
	@Id
	String paymentMethodId;
	String paymentMetodName;
	
	public PaymentMethod(){}
	
	



	public PaymentMethod(String paymentMetodName) {
		super();
		this.paymentMetodName = paymentMetodName;
	}


	/**
	 * @return the paymentMetodName
	 */
	public String getPaymentMetodName() {
		return paymentMetodName;
	}

	/**
	 * @param paymentMetodName the paymentMetodName to set
	 */
	public void setPaymentMetodName(String paymentMetodName) {
		this.paymentMetodName = paymentMetodName;
	}





    @Override
    public String toString() {
        return String.format(
                "{\"paymentMetodId\":%s, \"paymentMetodName\":'%s'}",
                paymentMethodId, paymentMetodName);
    }

	
	
	
}
