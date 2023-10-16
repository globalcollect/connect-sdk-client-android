/*
 * Copyright (c) 2022 Global Collect Services B.V
 */

package com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct;

import com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct.displayhints.DisplayHintsAccountOnFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * POJO that represents an AccountOnFile object.
 */
public class AccountOnFile implements Serializable {

	private static final long serialVersionUID = 4898075257024154390L;

	private Integer id;
	private Integer paymentProductId;

	private DisplayHintsAccountOnFile displayHints;


	private List<KeyValuePair> attributes = new ArrayList<>();


	public Integer getId() {
		return id;
	}

	public String getPaymentProductId() {
		return paymentProductId.toString();
	}

	public DisplayHintsAccountOnFile getDisplayHints() {
		return displayHints;
	}

	public List<KeyValuePair> getAttributes() {
		return attributes;
	}

	/**
	 * Gets the label of this AccountOnFile based on the DisplayHints and the Attributes values
	 *
	 * @return the label which can be displayed on an AccountOnFile selection screen
	 */
	public String getLabel() {

		String label = "";
		if (getDisplayHints().getLabelTemplate().get(0) != null) {
			AccountOnFileDisplay display = getDisplayHints().getLabelTemplate().get(0);

			for (KeyValuePair pair : attributes) {
				if (display.getKey().equals(pair.getKey())) {
					label = pair.getValue();
				}
			}
		}

		return label;
	}
}
