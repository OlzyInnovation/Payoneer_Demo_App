package com.olzyinnovation.payoneerdemo.payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.olzyinnovation.payoneerdemo.R;
import com.olzyinnovation.payoneerdemo.api.paymentOptions.Applicable;

import java.util.ArrayList;

public class PaymentRecyclerViewAdapter extends RecyclerView.Adapter<PaymentRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Applicable> payments = new ArrayList<>();

    private Context context;

    public PaymentRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public PaymentRecyclerViewAdapter(ArrayList<Applicable> payments, Context context) {
        this.payments = payments;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_page_layout, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvPaymentOptionName.setText(payments.get(position).getPaymentOptions().get(position).getCode());

        Glide.with(context)
                .asBitmap()
                .load(payments.get(position).getLogo())
                .into(holder.ivPaymentOptionImage);
        holder.rlParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, payments.get(position).getPaymentOptions().get(position).getLabel() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return payments.size();
    }

    public void setPayments(ArrayList<Applicable> payments) {
        this.payments = payments;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvPaymentOptionName;
        private ImageView ivPaymentOptionImage;
        private RelativeLayout rlParent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPaymentOptionName = itemView.findViewById(R.id.tvPaymentOptionName);
            ivPaymentOptionImage = itemView.findViewById(R.id.ivPaymentOptionImage);
            rlParent = itemView.findViewById(R.id.rlParent);
        }
    }
}
