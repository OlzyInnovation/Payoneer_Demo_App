package com.olzyinnovation.payoneerdemo.api.paymentOptions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentOptions {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("label")
    @Expose
    private String label;


    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
