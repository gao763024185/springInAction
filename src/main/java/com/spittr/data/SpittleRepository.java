package com.spittr.data;

import com.spittr.Spittle;

import java.util.List;

/**
 * Created by 高保红 on 2017/8/7.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
