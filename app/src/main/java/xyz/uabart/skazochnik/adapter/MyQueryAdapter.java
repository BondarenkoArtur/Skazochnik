package xyz.uabart.skazochnik.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;

import xyz.uabart.skazochnik.R;
import xyz.uabart.skazochnik.objects.Book;

public class MyQueryAdapter extends ParseRecyclerQueryAdapter<Book, MyQueryAdapter.MyViewHolder>{


    private MyViewHolder myViewHolder;

    public MyQueryAdapter(boolean hasStableIds) {
        super(Book.class, hasStableIds);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Book model = getItem(position);
        myViewHolder.name.setText(model.getName());
        myViewHolder.age.setText(model.getName());
        ParseFile imageFile = model.getImageFile();
        if (imageFile != null){
            myViewHolder.image.setParseFile(imageFile);
            myViewHolder.image.loadInBackground();
        }

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView age;
        ParseImageView image;

        MyViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);
            name = (TextView) itemView.findViewById(R.id.book_name);
            age = (TextView)itemView.findViewById(R.id.book_age);
            image = (ParseImageView)itemView.findViewById(R.id.book_image);
        }
    }

}