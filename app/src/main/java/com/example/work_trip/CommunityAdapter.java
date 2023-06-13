package com.example.work_trip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.work_trip.databinding.CardCommuBinding;

import java.util.ArrayList;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.MyViewHolder> {
   Context context;
   ArrayList<CommunityData> communityList = new ArrayList<>();
   CommunityAdapter(Context context){
       this.context = context;
   }

    @NonNull
    @Override
    public CommunityAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_commu, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CommunityAdapter.MyViewHolder holder, int position) {
       CommunityData communityData = communityList.get(position);

       holder.title.setText(String.valueOf(communityData.getTitle()));
       holder.date.setText(String.valueOf(communityData.getDate()));
        holder.company.setText(String.valueOf(communityData.getCompany()));
        holder.money.setText(String.valueOf(communityData.getMoney()));
        holder.duration.setText(String.valueOf(communityData.getDuration()));
        holder.people.setText(String.valueOf(communityData.getPeople()));
        holder.good.setText(String.valueOf(communityData.getGood()));
        holder.thema.setText(String.valueOf(communityData.getThema()));
        holder.content.setText(String.valueOf(communityData.getContent()));

        // byte[] img = communityData.getImg();
        //Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
        //holder.img.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return communityList.size();
    }

    public void removeItem(int position){
       communityList.remove(position);
    }

    public void addItem(CommunityData item){
       communityList.add(item);
    }

    // 아이템 연결
    class MyViewHolder extends RecyclerView.ViewHolder{
       ImageView img;
       TextView title,date, company, money, duration,thema, people, good, content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_img);
            title = itemView.findViewById(R.id.tv_commu_title);
            date = itemView.findViewById(R.id.tv_commu_date);
            company = itemView.findViewById(R.id.tv_commu_coperate_name);
            money = itemView.findViewById(R.id.tv_commu_budget);
            duration = itemView.findViewById(R.id.tv_commu_trip);
            thema = itemView.findViewById(R.id.tv_tag);
            people = itemView.findViewById(R.id.tv_commu_people_num);
            good = itemView.findViewById(R.id.tv_commu_good);
            content = itemView.findViewById(R.id.tv_commu_contnet);

        }
    }
}
