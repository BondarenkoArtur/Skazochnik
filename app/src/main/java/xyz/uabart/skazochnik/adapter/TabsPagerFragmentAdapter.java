package xyz.uabart.skazochnik.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;

import xyz.uabart.skazochnik.fragment.AbstractTabFragment;
import xyz.uabart.skazochnik.fragment.DownloadedFragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private HashMap<Integer, AbstractTabFragment> tabs;

    public TabsPagerFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, DownloadedFragment.getInstance(context));
        tabs.put(1, DownloadedFragment.getInstance(context));
        tabs.put(2, DownloadedFragment.getInstance(context));
    }
}
