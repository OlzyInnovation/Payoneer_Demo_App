package com.olzyinnovation.payoneerdemo.api.paymentOptions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Networks {

    @SerializedName("networks")
    @Expose
    private Applicable networkOptions;

    public Networks(Applicable networkOptions) {
        this.networkOptions = networkOptions;
    }

    public Applicable getNetworkOptions() {
        return networkOptions;
    }

    public void setNetworkOptions(Applicable networkOptions) {
        this.networkOptions = networkOptions;
    }
}
