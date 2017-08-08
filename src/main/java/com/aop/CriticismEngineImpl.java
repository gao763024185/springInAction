package com.aop;

/**
 * Created by 高保红 on 2017/8/3.
 */
public class CriticismEngineImpl implements CriticismEngine{
    public CriticismEngineImpl() {
    }

    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
