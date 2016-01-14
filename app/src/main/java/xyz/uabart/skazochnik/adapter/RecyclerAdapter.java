package xyz.uabart.skazochnik.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xyz.uabart.skazochnik.Objects.Book;
import xyz.uabart.skazochnik.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BookViewHolder>{

    private BookViewHolder bookViewHolder;

    List<Book> books;

    public RecyclerAdapter(List<Book> books){
        this.books = books;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        bookViewHolder = new BookViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        bookViewHolder.name.setText(books.get(position).getName());
        bookViewHolder.age.setText(books.get(position).getName());
        bookViewHolder.image.setImageResource(books.get(position).getImageSrc());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView name;
        TextView age;
        ImageView image;

        BookViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            name = (TextView)itemView.findViewById(R.id.book_name);
            age = (TextView)itemView.findViewById(R.id.book_age);
            image = (ImageView)itemView.findViewById(R.id.book_image);
        }
    }

}
