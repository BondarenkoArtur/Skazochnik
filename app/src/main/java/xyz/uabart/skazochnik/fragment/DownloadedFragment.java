package xyz.uabart.skazochnik.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.uabart.skazochnik.Objects.Book;
import xyz.uabart.skazochnik.R;
import xyz.uabart.skazochnik.adapter.RecyclerAdapter;

public class DownloadedFragment extends AbstractTabFragment  {

    private static final int LAYOUT = R.layout.fragment_downloaded;
    private View view;
    private List<Book> books;
    private RecyclerView recyclerView;

    public static DownloadedFragment getInstance(Context context) {
        Bundle args = new Bundle();
        DownloadedFragment fragment = new DownloadedFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_downloaded));

        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
        return view;
    }

    private void initializeAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(books);
        recyclerView.setAdapter(adapter);
    }

    private void initializeData(){
        books = new ArrayList<>();
        books.add(new Book("Спящая красавица", R.drawable.image1));
        books.add(new Book("Мишка", R.drawable.image2));
        books.add(new Book("Dlinnaya spyashyaya krasavitsa dlya testa", R.drawable.image1));
    }
}
