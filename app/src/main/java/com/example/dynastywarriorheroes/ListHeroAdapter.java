package com.example.dynastywarriorheroes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ViewHolder> {
    private List <Hero> heros;
    private RecycleViewClickListener clickListener;

    public ListHeroAdapter(List <Hero> heros, RecycleViewClickListener listener){
        this.heros= heros;
        this.clickListener= listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero= heros.get(position);

        holder.iv_hero.setImageResource(hero.getPhoto());
        holder.tv_hero_name.setText(hero.getName());
        holder.tv_hero_gender.setText(hero.getGender());
        holder.tv_hero_weapon.setText(hero.getWeapon());
        holder.tv_hero_forces.setText(hero.getForces());
        holder.tv_hero_height.setText(hero.getHeight());
        holder.tv_hero_born.setText(hero.getBorn());
        holder.tv_hero_type.setText(hero.getType());

        String hero_number= (heros.size()-position)+". "+hero.getName();

        holder.tv_hero_number.setText(hero_number);
        holder.tv_hero_detail.setText(hero.getDetail());
        holder.tv_header.setText(hero.getJustForHeader());
    }

    @Override
    public int getItemCount() {
        return heros.size();
    }

    public interface RecycleViewClickListener{
        void onClick(View view, int position);
    }

    class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_hero;
        TextView tv_hero_name, tv_hero_gender, tv_hero_weapon, tv_hero_forces, tv_hero_detail, tv_hero_number, tv_hero_height, tv_hero_born, tv_hero_type, tv_header, tv_more;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_hero= itemView.findViewById(R.id.iv_hero);
            tv_hero_number= itemView.findViewById(R.id.tv_hero_number);
            tv_hero_name= itemView.findViewById(R.id.tv_hero_name);
            tv_hero_detail= itemView.findViewById(R.id.tv_hero_detail);
            tv_hero_forces= itemView.findViewById(R.id.tv_hero_forces);
            tv_hero_gender= itemView.findViewById(R.id.tv_hero_gender);
            tv_hero_weapon= itemView.findViewById(R.id.tv_hero_weapon);
            tv_hero_height= itemView.findViewById(R.id.tv_hero_height);
            tv_hero_born= itemView.findViewById(R.id.tv_hero_born);
            tv_header= itemView.findViewById(R.id.tv_header);
            tv_hero_type= itemView.findViewById(R.id.tv_hero_type);
            tv_more= itemView.findViewById(R.id.tv_more);
            tv_more.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }
}
