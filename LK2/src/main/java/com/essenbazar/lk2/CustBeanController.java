package com.essenbazar.lk2;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author himan
 */
@Named(value = "custBeanController")
@SessionScoped
public class CustBeanController implements Serializable {
    
    private int numFibonacci;
    private long result;
    private static final long serialVersionUID=1L;
    
    public CustBeanController() {
        numFibonacci=0;
        result=0;
    }
    
    public int getNumFibonacci(){
        return numFibonacci;
    }
    
    public void setNumFibonacci(int numFibonacci){
        this.numFibonacci=numFibonacci;
    }
    
    public long getResult(){
        return result;
    }
    
    public void setResult(long result){
        this.result=result;
    }
    
    public long getFibonacciNumber(int param){
        if(param==1||param==2) return 1;
        long actual=1, next=1, sum=0;
        for(int i=2; i<param; ++i){
            sum=next+actual;
            actual=next;
            next=sum;
        }
        return next;
    }
    
    public void performFibonacciOperation(){
        if(numFibonacci<=0) setResult(0L);
        else setResult(getFibonacciNumber(numFibonacci));
        FacesMessage facesMsg=new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                               "Fibonacci Calculation for: "+numFibonacci+" number is: "+result,
                                               "Fibonacci Calculation");
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    public void ajaxPerformFibonacciOperation(final AjaxBehaviorEvent event){
        if(numFibonacci<=0) setResult(0L);
        else setResult(getFibonacciNumber(numFibonacci));
        FacesMessage facesMsg=new FacesMessage(FacesMessage.SEVERITY_INFO,
                                               "Fibonacci Calculation for: "+numFibonacci+" number is: "+result,
                                               "Fibonacci Calculation");
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}
