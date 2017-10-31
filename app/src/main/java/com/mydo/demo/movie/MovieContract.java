package com.mydo.demo.movie;

import com.mydo.demo.base.BaseModel;
import com.mydo.demo.base.BasePresenter;
import com.mydo.demo.base.BaseView;
import com.mydo.demo.base.ResultLisenter;
import com.mydo.demo.entity.Movie;

/**
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */
public interface MovieContract {

    interface MovieView extends BaseView {
        void setMovie(Movie movie);
    }

    interface MovieModel extends BaseModel {
        void listMovieData(int position, int type, ResultLisenter resultLisenter);
    }

    abstract class MoviePresenter extends BasePresenter</*MovieModel, */MovieView> {
        public abstract void listMovieData(int position, int type);
    }

}
