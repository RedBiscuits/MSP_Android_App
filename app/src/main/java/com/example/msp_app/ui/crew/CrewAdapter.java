package com.example.msp_app.ui.crew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.msp_app.R;
import com.example.msp_app.model.CrewModel;
import com.squareup.picasso.Picasso;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;

import okio.ByteString;

public class CrewAdapter extends RecyclerView.Adapter
        <CrewAdapter.MemberViewHolder> {
    private ArrayList<CrewModel> membersList=new ArrayList<>();
    private Context context;

    public void setMembersList(ArrayList<CrewModel> membersList) {
        this.membersList = membersList;
        notifyDataSetChanged();
    }

    public ArrayList<CrewModel> getMembersList() {
        return membersList;
    }

    public CrewAdapter( Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.crew_cardview
                ,parent,false);
        return new MemberViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        holder.onBind(getMembersList().get(position));
    }

    @Override
    public int getItemCount() {
        return getMembersList().size();
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder
    {

        private TextView txtName,txtPosition,txtCommunity;
        private Animation animation,anim;
        ImageView img_memeber;
        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txt_member_name);
            animation= AnimationUtils.loadAnimation(context,R.anim.scale);
            txtName.setAnimation(animation);
            txtPosition=itemView.findViewById(R.id.txt_position);
            txtPosition.setAnimation(animation);
            txtCommunity=itemView.findViewById(R.id.txt_community);
            txtCommunity.setAnimation(animation);
           img_memeber=itemView.findViewById(R.id.img_member);

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void onBind(CrewModel member)
        {
            txtName.setText(member.getName());
            txtPosition.setText(member.getPosition());
            txtCommunity.setText(member.getCommittee());
            Picasso.get().load(member.getImg()).error(R.drawable.admin).into(img_memeber);

        }

      /*  @RequiresApi(api = Build.VERSION_CODES.O)
        public void convertImageType(String imgUrl){
            //decode base64 string to image
            byte[] decodeString= Base64.getDecoder().decode(imgUrl);
            Bitmap decoded=BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);
            img_memeber.setImageBitmap(decoded);

        }*/
    }
}
