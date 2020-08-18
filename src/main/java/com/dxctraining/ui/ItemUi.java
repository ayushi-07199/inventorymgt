package com.dxctraining.ui;

import javax.annotation.PostConstruct; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.services.IComputerService;
import com.dxctraining.item.entities.Item;
import com.dxctraining.item.services.IItemService;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.phone.services.*;
import com.dxctraining.supplier.services.ISupplierService;
@Component
public class ItemUi {
	
	@Autowired
	private IItemService itemService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IPhoneService phoneService;
	@Autowired
	private IComputerService computerService;
	@PostConstruct
	void runApp() {
		
		
		Supplier supplier1 = new Supplier(4, "Ayushi");
		Supplier supplier2 = new Supplier(7, "Muskan");
		Supplier supplier3 = new Supplier(10, "Anuj");

		supplierService.add(supplier1);
		supplierService.add(supplier2);
		supplierService.add(supplier3);

		Item item1 = new Item(1, "laptop", supplier1);
		Item item2 = new Item(2, "book", supplier2);
		Item item3 = new Item(3, "pen", supplier3);

		itemService.addItem(item1);
		itemService.addItem(item2);
		itemService.addItem(item3);

		Phone ph1 = new Phone(245, "lenovo", supplier1, 1222);
		phoneService.add(ph1);
		Phone ph2 = new Phone(22, "classMate", supplier2, 1283434);
		phoneService.add(ph2);

		Computer computer1 = new Computer(1011, "hp", supplier3, 456789);
		computerService.addComputer(computer1);
		
		

		int id1 = item3.getId();
		Item itemFetched1 = itemService.findItemById(id1);
		System.out.println("id is" + itemFetched1.getId() + "name is" + itemFetched1.getName());
	}
}