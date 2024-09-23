package com.example.roomdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private final onButtonClickListener buttonClickListener;
    private List<User> mList;

    public interface onButtonClickListener{
        void onClickUpdateUser(User user);

        void onClickDeleteUser(User user);
    }


    public UserAdapter (onButtonClickListener buttonClickListener){
        this.buttonClickListener = buttonClickListener;
    }

    public void setData(List<User> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mList.get(position);
        if(user == null){
            return;
        }
        holder.tv_name.setText(user.getName());
        holder.tv_phone.setText(user.getPhone());
        holder.tv_ngaysinh.setText(user.getNgaysinh());
        holder.tv_chucvu.setText(user.getChucvu());
        holder.tv_tinhnguyen.setText(user.getTinhnguyen());
        holder.btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClickListener.onClickUpdateUser(user);
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClickListener.onClickDeleteUser(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mList != null){
            return mList.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_ngaysinh;
        TextView tv_phone;
        TextView tv_chucvu;
        TextView tv_tinhnguyen;
        Button btn_update;
        Button btn_delete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phone = itemView.findViewById(R.id.tv_phone);
            tv_ngaysinh = itemView.findViewById(R.id.tv_ngaysinh);
            tv_chucvu = itemView.findViewById(R.id.tv_chucvu);
            tv_tinhnguyen = itemView.findViewById(R.id.tv_tinhnguyen);
            btn_update = itemView.findViewById(R.id.btn_update);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
