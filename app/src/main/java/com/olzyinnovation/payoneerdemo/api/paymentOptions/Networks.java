package com.olzyinnovation.payoneerdemo.api.paymentOptions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Networks {

    @SerializedName("networks")
    @Expose
    private Applicable networkOptions;

    public Applicable getNetworkOptions() {
        return networkOptions;
    }

    public void setNetworkOptions(Applicable networkOptions) {
        this.networkOptions = networkOptions;
    }
}