package com.aop;

/**
 * Created by 高保红 on 2017/8/3.
 */
public aspect CriticAspect {

    public CriticAspect() {
    }
    pointcut performance() : execution(* perform(..));

//    afterReturning():performance(){
//        System.out.println(criticismEngine.getCriticism());;
//    }
    private  CriticismEngine criticismEngine;

    public CriticismEngine getCriticismEngine() {
        return criticismEngine;
    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
