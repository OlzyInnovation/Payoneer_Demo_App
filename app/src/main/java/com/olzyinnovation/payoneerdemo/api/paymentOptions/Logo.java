package com.olzyinnovation.payoneerdemo.api.paymentOptions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Logo {

    @SerializedName("code")
    @Expose
    private String logo;

    public Logo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
