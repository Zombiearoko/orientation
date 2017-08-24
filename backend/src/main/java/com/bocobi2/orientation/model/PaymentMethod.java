package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentMethod")
public class PaymentMethod {
	
	@Id
	String paymentMethodId;
	String paymentMethodName;


	public PaymentMethod(){}
	
	





	public PaymentMethod(String paymentMethodName) {
		super();
		this.paymentMethodName = paymentMethodName;

	}

	/**

	 * @return the paymentMethodName
	 */
	public String getpaymentMethodName() {
		return paymentMethodName;
	}

	/**
	 * @param paymentMethodName the paymentMethodName to set
	 */
	public void setpaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;

	}





    @Override
    public String toString() {
        return String.format( 
                "{\"paymentMetodId\":%s, \"paymentMetodName\":'%s'}",
                paymentMethodId, paymentMethodName);
    }

	
	
	
}

