package com.nt.service;

import java.util.List;

public interface ICustomerMgmtService {
    public  String   saveDataUsingParent();
    public  String    saveDataUsingChilds();
    
    public   void    loadDataUsingParent();
    public   void   loadDataUsingChilds(); 
    
    public    void   deleteDataUsingParent();
    public    void   deleteAllChildsOfAParent();
    public   void    addNewChildToExistingChildsOfAParent();
    public    void   deleteDataUsingChilds();
    
    public   List<Object[]>   showParentsToChildsDataUsingJoins();
}
