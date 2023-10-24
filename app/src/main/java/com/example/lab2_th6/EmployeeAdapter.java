package com.example.lab2_th6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> arr;
    private Context context;
    public class EmployeeViewHolder extends RecyclerView.ViewHolder{
        TextView EmployeeName;
        TextView EmployeePos;
        ImageView imageView;
        LinearLayout llParent;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            EmployeeName = (TextView)itemView.findViewById(R.id.item_employee_tv_fullname);
            EmployeePos = (TextView)itemView.findViewById(R.id.item_employee_tv_position);
            imageView = (ImageView) itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = (LinearLayout) itemView.findViewById(R.id.item_employee_ll_parent);
        }
    }
    public EmployeeAdapter(Context context)
    {
        this.context = context;
    }
    public void setData(ArrayList<Employee> list){
        this.arr = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder viewHolder, int position) {

        Employee employee = arr.get(position);
        if (employee.getFullName()!=null) {
            viewHolder.EmployeeName.setText(employee.getFullName());
        }
        else viewHolder.EmployeeName.setText("");
        if (employee.isManager())
        {
            viewHolder.imageView.setVisibility(View.VISIBLE);
            viewHolder.EmployeePos.setVisibility(View.GONE);
        }
        else
        {
            viewHolder.imageView.setVisibility(View.GONE);
            viewHolder.EmployeePos.setVisibility(View.VISIBLE);
            viewHolder.EmployeePos.setText(context.getString(R.string.staff));
        }
        if (position%2==0)
        {
            viewHolder.llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            viewHolder.llParent.setBackgroundResource(R.color.light_blue);
        }

    }
    @Override
    public int getItemCount() {
        if(arr != null)
        {return arr.size();}
        return 0;
    }
}
