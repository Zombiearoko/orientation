package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentMethod")
public class PaymentMethod {
	
	@Id
	String paymentMethodId;
<<<<<<< HEAD
	String paymentMethodName;
=======
	String paymentMetodName;
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
	
	public PaymentMethod(){}
	
	



<<<<<<< HEAD
	public PaymentMethod(String paymentMethodName) {
		super();
		this.paymentMethodName = paymentMethodName;
=======
	public PaymentMethod(String paymentMetodName) {
		super();
		this.paymentMetodName = paymentMetodName;
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
	}


	/**
<<<<<<< HEAD
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
=======
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
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
	}





    @Override
    public String toString() {
        return String.format(
<<<<<<< HEAD
                "{\"paymentMetodId\":%s, \"paymentMethodName\":'%s'}",
                paymentMethodId, paymentMethodName);
=======
                "{\"paymentMetodId\":%s, \"paymentMetodName\":'%s'}",
                paymentMethodId, paymentMetodName);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
    }

	
	
	
}
