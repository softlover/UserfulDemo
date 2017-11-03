package com.mydo.demo.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydo.demo.R;
import com.mydo.demo.base.BaseActivity;
import com.mydo.demo.databinding.ActivityCoordinatorBinding;
import com.mydo.demo.entity.Movie;
import com.mydo.demo.movie.MovieContract;
import com.mydo.demo.movie.MoviePresenter;
import com.mydo.demo.util.ImageUtil;
import com.mydo.demo.util.LogUtil;

import java.util.List;


/**
 * 滚动收缩布局
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class CoordinatorActivity extends BaseActivity<MoviePresenter, ActivityCoordinatorBinding> implements MovieContract.MovieView {


    @Override
    public int getLayoutId() {
        return R.layout.activity_coordinator;
    }

    @Override
    public void initView() {
        mViewBinding.headLayout.topCenterTitle.setText(getTitle());
        mViewBinding.recyclerview.setLayoutManager(new LinearLayoutManager(context));
        mPresenter.listMovieData(2, 1);
    }

    @Override
    public void setMovie(Movie movie) {
        String url = movie.getSubjects().get(0).getImages().getLarge();
        ImageUtil.loadImage(context, url, mViewBinding.img, 0);
        setListData(movie.getSubjects());
    }

    private void setListData(final List<Movie.SubjectsBean > datas){
        mViewBinding.recyclerview.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(getLayoutInflater().inflate(R.layout.item_coordinator, parent, false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ViewHolder viewHolder = (ViewHolder) holder;
                viewHolder.titleTv.setText("滚动收缩" + position);

                ImageUtil.loadImage(context, datas.get(0).getCasts().get(0).getAvatars().getSmall(),  viewHolder.imgIv, 0);
            }

            @Override
            public int getItemCount() {
                return 10;
            }

            class ViewHolder extends RecyclerView.ViewHolder {

                ImageView imgIv;
                TextView titleTv;

                public ViewHolder(View itemView) {
                    super(itemView);

                    imgIv = (ImageView) itemView.findViewById(R.id.item_coordinator_img);
                    titleTv = (TextView) itemView.findViewById(R.id.item_coordinator_title);
                }

            }
        });
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }


}
