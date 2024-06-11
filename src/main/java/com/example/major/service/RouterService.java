package com.example.major.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.major.dto.RouterLogin;
import com.example.major.entity.Address;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Plans;
import com.example.major.entity.Routers;
import com.example.major.repository.AdressRepository;
import com.example.major.repository.DeviceRepository;
import com.example.major.repository.PlanRepository;
import com.example.major.repository.RouterRepository;

import jakarta.transaction.Transactional;

@Service
public class RouterService {
	
	@Autowired
	private RouterRepository routerRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	
	@Autowired
	private AdressRepository addressRepository;
	
	@Autowired 
	private PlanRepository planRepository;
	
//	@Autowired
//	public RouterService(RouterRepository routerRepository) {
//		super();
//		this.routerRepository = routerRepository;
//		this.deviceRepository = null;
//	}
	
	


//	public RouterService(DeviceRepository deviceRepository) {
//		super();
//		this.routerRepository = null;
//		this.deviceRepository = deviceRepository;
//	}


	public List<Routers> getall() {
		// TODO Auto-generated method stub
		return routerRepository.findAll();
	}

	
//	public Routers placedevice(@RequestBody RouterRequest request) {
//		return routerRepository.save(request.getRouter());
//	}
	
	
	public List<Routers> getdevice() {
		return routerRepository.findAll();
	}


	public List<Devices> getrouterdevices(int accountNumber) {
		Optional <Routers> getdevice = routerRepository.findbyaccount(accountNumber);
		if(getdevice.isPresent()) {
			Routers exists = getdevice.get();
			System.out.println(exists.getPlans().getSpeed());
			System.out.println(exists.getPlans().getCustomer().getName());
			return exists.getDevices(); 
		}
		
		
		return null;
	}


	public ResponseEntity<String> adddevice(RouterLogin router) {
		Optional<Routers> getdevice = routerRepository.findbyssid(router.getSsid());
		if(getdevice.isPresent()) {
			Routers exists = getdevice.get();
			//return (ResponseEntity<String>) ResponseEntity.ok("Login ");
			if(exists.getPassword().equals(router.getPassword())) {
				//first we set the paramaters for the device//
				Devices add_devicee = new Devices();
				add_devicee.setDeviceType(router.getDeviceType());
				
				add_devicee.setMac(router.getMac());
				add_devicee.setIsBlocked(false);
				add_devicee.setRouter(exists);
				//exists.getDevices().add(add_devicee);
				List<Devices> routerDevices= exists.getDevices(); 
//				if(routerDevices.contains(add_devicee.getMac())) {
//					System.out.println("hello");
//				}
				
				Boolean existing = false;
				Devices existing_device=new Devices();
				
				
				for (int i = 0; i < routerDevices.size(); i++) {
					 
		            if(routerDevices.get(i).getMac().equals(router.getMac())){
		            	existing_device = routerDevices.get(i); 
		            	existing =true;
//		            	System.out.println(existing_device.getIsBlocked());
//		            	System.out.println("MAC exists");
//						return (ResponseEntity<String>) ResponseEntity.ok("You are already connected");

		            }
				}
				
				if(existing) {
					if(existing_device.getIsBlocked() == true) {
						return (ResponseEntity<String>) ResponseEntity.ok("You have been blocked");
					}
					else {
						return (ResponseEntity<String>) ResponseEntity.ok("You are already connected");
					}
				}
				
				
				//Optional<Devices> macexists = deviceRepository.findbymac(router.getMac());
				int size;
				int activesize=0;
				if(routerDevices.isEmpty()) {
					size=1;
				}else {
					//size = routerDevices.size();
					size = routerDevices.size();
					System.out.println(size + "size");
					size+=1;
					System.out.println(size + "size");
					activesize = getActive(routerDevices);
					//activesize+=1;
					System.out.println(activesize);
					
					
					
				}
				
				if(activesize>=10) {		
					return (ResponseEntity<String>) ResponseEntity.ok("Sorry you have already added 10 devices please remove one");
				}
				String deviceid = Integer.toString(size); 
				add_devicee.setDeviceId(deviceid);
				
				//System.out.println(routerDevices.size());
				routerDevices.add(add_devicee);
				//System.out.println(routerDevices.size());
				deviceRepository.save(add_devicee);
				//System.out.println("Object ADDED");
				return (ResponseEntity<String>) ResponseEntity.ok("Object Added");
//				
				
			}
			else {
				return (ResponseEntity<String>) ResponseEntity.ok("Wrong password");
			}
		}	
		
		
		
		return (ResponseEntity<String>) ResponseEntity.ok("ssid not found");
	}


//	public ArrayList<Devices> getblockeddevices(Routers router) {
//		
//		///first we try to find the router using accountnumber 
//		//then we will try to access the list of devices and get every device that is blocked
//		Optional<Routers> getRouter = routerRepository.findbyaccount(router.getAccountNumber());
//		ArrayList<Devices> blockedDevices = new ArrayList<Devices>() ;
//		if(getRouter.isPresent()) {
//			Routers routerPresent = getRouter.get();
//			List<Devices> existingDevices = routerPresent.getDevices();
//			
//			for(int i=0;i<existingDevices.size();i++) {
//				if(existingDevices.get(i).getIsBlocked()==true) {
//					blockedDevices.add(existingDevices.get(i));
//				}	
//			}
//			return blockedDevices ;
//		}
//		// TODO Auto-generated method stub
//		return blockedDevices;
//		
//	}
	
	
	public	List<Devices> getblockedlistdevices(Routers router) {
		
		///first we try to find the router using accountnumber 
		//then we will try to access the list of devices and get every device that is blocked
		Optional<Routers> getRouter = routerRepository.findbyaccount(router.getAccountNumber());
		List<Devices> blockedDevices = new ArrayList<Devices>(); 
		if(getRouter.isPresent()) {
			Routers routerPresent = getRouter.get();
			List<Devices> existingDevices = routerPresent.getDevices();
			
			for(int i=0;i<existingDevices.size();i++) {
				if(existingDevices.get(i).getIsBlocked()==true) {
					blockedDevices.add(existingDevices.get(i));
				}	
			}
		}
		// TODO Auto-generated method stub
		return blockedDevices;
		
	}
	
	
	public List<Devices> getActiveDevices(Routers router){
		
		///first we try to find the router using accountnumber 
		//then we will try to access the list of devices and get every device that is not blockes
		Optional<Routers> getRouter = routerRepository.findbyaccount(router.getAccountNumber());
		List<Devices> activeDevices = new ArrayList<Devices>(); 
		if(getRouter.isPresent()){
			Routers routerPresent = getRouter.get();
			List<Devices> existingDevices = routerPresent.getDevices();
			
			for(int i=0;i<existingDevices.size();i++) {
				if(existingDevices.get(i).getIsBlocked()==false) {
					activeDevices.add(existingDevices.get(i));
				}	
			}
		}
		// TODO Auto-generated method stub
		return activeDevices;
	}
	
	public int getActive(List <Devices> routerDevices){
		
		int device=0;
		for(int i=0;i<routerDevices.size();i++) {
			if(routerDevices.get(i).getIsBlocked()==false) {
				System.out.println();
				device++;
			}	
		}
		
		
		// TODO Auto-generated method stub
		return device;
	}


	public List<Routers> findrouter(Address ad) {
		
		Optional<Address> findaddress= addressRepository.findbyarea(ad.getArea());
		if(findaddress.isPresent()) {
			Address existing = findaddress.get();
			return existing.getRouter();
		}
		// TODO Auto-generated method stub
		return null;
	}


	public Routers getconnected(RouterLogin router) {
		Optional<Routers> existing = routerRepository.findbyssid(router.getSsid());
		
		if(existing.isPresent()) {
			Routers isexisting = existing.get();
			
			Routers connected = new Routers();
			connected.setSsid(isexisting.getSsid());
			connected.setModel(isexisting.getModel());
			connected.setFirmwareVersion(isexisting.getFirmwareVersion());
			connected.setIpv4(isexisting.getIpv4());
			return connected;
		}
		
		return null;
	}

	@Transactional
	public Routers increaseUsage(RouterLogin router) {
		// TODO Auto-generated method stub
		Optional<Routers> existing = routerRepository.findbyssid(router.getSsid());
				
				if(existing.isPresent()) {
					Routers isexisting = existing.get();
					Plans upda = new Plans();
					if(isexisting.getPlans().isServiceTrue()) {
						String datause = isexisting.getPlans().getDataUsed().substring(0,isexisting.getPlans().getDataUsed().length()-2);
						System.out.println(datause);
						String datafromfront = router.getDatause();
						Long datafrom = Long.valueOf(datafromfront);
						
						
						Long add = Long.valueOf(datause);
						
						add=add+datafrom;
						System.out.println(add);
						String added = add.toString();
						added = added+"GB";
						System.out.println(added);
						upda = isexisting.getPlans();
						isexisting.getPlans().setDataUsed(added);
						//System.out.println(router.getDatause());
						upda.setDataUsed(added);
						System.out.println("updated");
						planRepository.save(upda);

					}
					else {
						System.out.println("user has been disconnected");
					}
										
					
				}
				
		
		
		return null;
	}
	
	
	
	
	
	
	

	
	
	

	

}
