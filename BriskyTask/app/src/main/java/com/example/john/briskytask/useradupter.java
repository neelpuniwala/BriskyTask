package com.example.john.briskytask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;
/**
 * Created by Neel on 12/6/2017.
 */

public class useradupter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<user> data= Collections.emptyList();

    // create constructor to innitilize context and data sent from MainActivity
    public useradupter(Context context, List<user> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.cardlayout, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        user current=data.get(position);
        myHolder.name.setText(current.name);
        myHolder.username.setText("Username: " + current.username);
        myHolder.email.setText("Email: " + current.email);
        myHolder.phone.setText("Phone no. : " + current.phone);
        myHolder.website.setText("Website : "+current.website);
      /*  myHolder.street.setText("Address : "+current.street);
        myHolder.suite.setText("                  "+current.suit);
        myHolder.city.setText("                  "+current.city);
        myHolder.zip.setText("                  "+current.zip);
        myHolder.cname.setText("Company : "+current.cname);
        myHolder.cp.setText("                    "+current.catchpharse);
        myHolder.bs.setText("                    "+current.bs);*/
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView username;
        TextView email;
        TextView phone;
        TextView website;
        TextView street;
        TextView suite;
        TextView city;
        TextView zip;
        TextView cname;
        TextView cp;
        TextView bs;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            username =(TextView) itemView.findViewById(R.id.username);
            email = (TextView) itemView.findViewById(R.id.email);
            phone = (TextView) itemView.findViewById(R.id.phone);
            website = (TextView) itemView.findViewById(R.id.website);
            street = (TextView) itemView.findViewById(R.id.street);
            suite = (TextView) itemView.findViewById(R.id.suit);
            city = (TextView) itemView.findViewById(R.id.city);
            zip = (TextView) itemView.findViewById(R.id.zip);
            cname = (TextView) itemView.findViewById(R.id.cname);
            cp = (TextView) itemView.findViewById(R.id.cp);
            bs = (TextView) itemView.findViewById(R.id.bs);
        }

    }



}
