package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.entity.PhoneNumber;
import com.nt.repository.ICustomerRepository;
import com.nt.repository.IPhonesRepository;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerRepository  custRepo;
	@Autowired
	private  IPhonesRepository  phonesRepo;

	@Override
	public String saveDataUsingParent() {
		//create parent object
		Customer cust=new Customer("raja","hyd");
		//create Child  objs
		PhoneNumber ph1=new PhoneNumber(9999999L, "airtel", "residence");
		PhoneNumber ph2=new PhoneNumber(8888888L, "jio", "office");
		//set   parent  to childs
		ph1.setCust(cust); ph2.setCust(cust);
		//set  childs to parent
		Set<PhoneNumber>  childs=Set.of(ph1,ph2);
		cust.setPhonesInfo(childs);
		//save  parent to childs
		int idVal=custRepo.save(cust).getCno();
		
		return  "Parent to Childs objs are saved with the id Value:"+idVal;
	}
	
	@Override
	public String saveDataUsingChilds() {
		//create parent object
		Customer cust=new Customer("mahesh","delhi");
		//create Child  objs
		PhoneNumber ph1=new PhoneNumber(77777777L, "airtel", "residence");
		PhoneNumber ph2=new PhoneNumber(66666666L, "jio", "office");
		//set   parent  to childs
		ph1.setCust(cust); ph2.setCust(cust);
		//set  childs to parent
		Set<PhoneNumber>  childs=new HashSet<>();
		childs.add(ph1); childs.add(ph2);
		cust.setPhonesInfo(childs);
		//save objects using childs
		    phonesRepo.saveAll(childs);
	
		return "childs to parent   objs  are saved";
	}
	
	@Override
	public void loadDataUsingParent() {
          Iterable<Customer>  it=custRepo.findAll();
          it.forEach(cust->{
        	  System.out.println("parent ::"+cust);
        	  // Associated child objs
       /* 	  Set<PhoneNumber> childs=cust.getPhonesInfo();
        	  childs.forEach(ph->{
        		  System.out.println("Child::"+ph);
        	  });*/
          });

   }
	
	@Override
	public void loadDataUsingChilds() {
		Iterable<PhoneNumber> it=phonesRepo.findAll();
		it.forEach(ph->{
			System.out.println("Child ::"+ph);
/*			//get the Associated PArent
			Customer cust=ph.getCust();
			System.out.println("Parent:: "+cust);*/
		});
		
	}//method
	
	@Override
	public void deleteDataUsingParent() {
		// Load  parent obj
		Optional<Customer> opt=custRepo.findById(1000);
		if(opt.isPresent()) {
			//  get Customer  object
			Customer cust=opt.get();
			custRepo.delete(cust);
			System.out.println("Customer and  his PhoneNumbers are deleted");
		}
		else {
		 System.out.println("Customer is not found");
		}
	}
	
	
	@Override
	public void deleteAllChildsOfAParent() {
		// Load  parent obj
		Optional<Customer> opt=custRepo.findById(1003);
		if(opt.isPresent()) {
			//  get Customer  object
			Customer cust=opt.get();
			//get Childs of a PArent
			Set<PhoneNumber> childs=cust.getPhonesInfo();
			//nullify parent  from the childs
			childs.forEach(ph->{
				ph.setCust(null);
			});
			//delete all the childs
			phonesRepo.deleteAllInBatch(childs);
			System.out.println("All childs of a Parent are deleted");
		}
		else {
		System.out.println("parent  not found");
		}
	}
	
	@Override
	public void addNewChildToExistingChildsOfAParent() {
		// Load  parent obj
		Optional<Customer> opt=custRepo.findById(1003);
		if(opt.isPresent()) {
			//  get Customer  object
			Customer cust=opt.get();
			// get  existing childs of  a Parent
			Set<PhoneNumber> childs=cust.getPhonesInfo();
			//create new PhoneNumber
			PhoneNumber ph=new PhoneNumber(777777L, "vi", "personal");
			//set new child to parent
			ph.setCust(cust);
			//add new  child to existing childs and  update the childs
			childs.add(ph);
			custRepo.save(cust);
	       System.out.println("New Child is added to Existing Childs of a Parent");
	}
		else {
		System.out.println("Parent not found");
		}
	}//method
	
	@Override
	public void deleteDataUsingChilds() {
		// Load  parent obj
		Optional<Customer> opt=custRepo.findById(1003);
		if(opt.isPresent()) {
			//  get Customer  object
			Customer cust=opt.get();
			//get  all  childs of a parentn
			Set<PhoneNumber> childs=cust.getPhonesInfo();
	       //delete all childs
			childs.forEach(ph->{
				phonesRepo.delete(ph);
			});
			System.out.println("All childs and its  associated is deleted");
		}
		else {
			System.out.println("Parent not found");
		}
	}
	
	@Override
	public List<Object[]> showParentsToChildsDataUsingJoins() {
		//use    repo
		return custRepo.fetchParentsToChildsDataUsingJoins();
	}
	
}//class
