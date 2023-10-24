package com.example.lab2_th6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView lvPerson;
    EmployeeAdapter adapter;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPerson = findViewById(R.id.recycler_view);
        adapter = new EmployeeAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        lvPerson.setLayoutManager(linearLayoutManager);
        adapter.setData(employees);
        lvPerson.setAdapter(adapter);
        Button button = findViewById(R.id.Inputbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cBox = findViewById(R.id.checkBox);
                boolean re_cBox = cBox.isChecked();
                EditText etId = findViewById(R.id.IDEdittext);
                String id = etId.getText().toString();
                EditText etName = findViewById(R.id.NameEdittext);
                String name = etName.getText().toString();
                Employee new_employee = new Employee(id, name, re_cBox);
                employees.add(new_employee);
                adapter.setData(employees);
                //adapter.notifyDataSetChanged();
            }
        });
    }
}