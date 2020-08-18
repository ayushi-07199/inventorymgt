package com.dxctraining.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.item.entities.Item;
import com.dxctraining.item.services.IItemService;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.services.IPhoneService;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.services.ISupplierService;

@Component
public class ItemUi {

	@Autowired
	private IItemService itemService;
	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IPhoneService phoneService;

	@PostConstruct
	void runApp() {

		Supplier supplier1 = new Supplier(1, "mohan");
		Supplier supplier2 = new Supplier(2, "sohan");

		supplierService.add(supplier1);
		supplierService.add(supplier2);

		Item item1 = new Item(1, "iphone", supplier1);
		Item item2 = new Item(2, "samsung", supplier2);

		itemService.addItem(item1);
		itemService.addItem(item2);

		System.out.println("******Sprint 3 is working");

		Phone ph1 = new Phone(11, "AAA", supplier1, 64);
		phoneService.add(ph1);
		Phone ph2 = new Phone(22, "BBB", supplier2, 128);
		phoneService.add(ph2);
		
		

		int id1 = item1.getId();
		Item itemFetched1 = itemService.findItemById(id1);
		System.out.println("id is" + itemFetched1.getId() + "name is" + itemFetched1.getName());
		
	}
}









