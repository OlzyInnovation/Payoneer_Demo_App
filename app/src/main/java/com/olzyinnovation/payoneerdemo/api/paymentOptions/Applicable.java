package com.olzyinnovation.payoneerdemo.api.paymentOptions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Applicable {

    @SerializedName("applicable")
    @Expose
    private ArrayList<PaymentOptions> paymentOptions = new ArrayList<>();

    @SerializedName("logo")
    @Expose
    private Logo logo;



    public ArrayList<PaymentOptions> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(ArrayList<PaymentOptions> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }
}
