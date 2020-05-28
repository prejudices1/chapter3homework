package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private adapter itemAdapter;
    private RecyclerView list;
    private LottieAnimationView animationView;
    private AnimatorSet set;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_place holder，添加 loading控件和列表视图控件

        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView=view.findViewById(R.id.animation_view);
        list = view.findViewById(R.id.list);
        itemAdapter=new adapter(getActivity());

        list.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        list.setItemAnimator(new DefaultItemAnimator());
        list.setAdapter(itemAdapter);
        list.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        list.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator alpha1 = ObjectAnimator.ofFloat(animationView,
                        "alpha",1f,0f);
                alpha1.setDuration(1000);

                ObjectAnimator alpha2 = ObjectAnimator.ofFloat(list,
                        "alpha",0f,1f);
                alpha2.setDuration(1000);

                list.setVisibility(View.VISIBLE);
                set = new AnimatorSet();
                set.playTogether(alpha1, alpha2);
                set.start();
            }
        }, 5000);
    }
}
