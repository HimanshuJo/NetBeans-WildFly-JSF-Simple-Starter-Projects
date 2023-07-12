package com.essenbazar.lk1;

import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author himan
 */

@Named(value = "lk1mb")
@SessionScoped
public class LK1MB implements Serializable {

    private static final long serialVersionUID=1L;
    private String name;
    private double userCurrAmount;
    private static final Logger logger = Logger.getLogger("lk1mb logger");
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getUserCurrAmount(){
        return userCurrAmount;
    }
    
    public void setUserCurrAmount(double userCurrAmount){
        this.userCurrAmount=userCurrAmount;
    }
    
    public void calTaxes(){
        setUserCurrAmount(userCurrAmount-(userCurrAmount*0.24));
    }
    
    public String getDispNewAmount(){
        logger.log(Level.WARNING, "------- ******* checking here ******* -------{0}", userCurrAmount);
        System.out.println("here"+ (userCurrAmount));
        return String.valueOf(userCurrAmount);
    }
    
    public String getSayWelcome(){
        if("".equals(name)||name==null){
            return "";
        } else{
            return "Hello from Ajax: Welcome Mr. "+name;
        }
    }
}
