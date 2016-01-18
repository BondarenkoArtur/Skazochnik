package xyz.uabart.skazochnik.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.uabart.skazochnik.adapter.MyQueryAdapter;
import xyz.uabart.skazochnik.adapter.ParseRecyclerQueryAdapter;
import xyz.uabart.skazochnik.objects.Book;
import xyz.uabart.skazochnik.R;

public class DownloadedFragment extends AbstractTabFragment  {

    private static final int LAYOUT = R.layout.fragment_downloaded;
    private RecyclerView recyclerView;
    private MyQueryAdapter myQueryAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

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

    @Override
    public void onResume() {
        super.onResume();
//        myQueryAdapter.loadObjects();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        myQueryAdapter = new MyQueryAdapter(true);

        recyclerView.setAdapter(myQueryAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        myQueryAdapter.addOnQueryLoadListener(new ParseRecyclerQueryAdapter.OnQueryLoadListener<Book>() {
            @Override
            public void onLoaded(List<Book> objects, Exception e) {
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onLoading() {
                if (!swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(true);
                }

            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myQueryAdapter.loadObjects();
            }
        });

        return view;
    }
}
