package com.example.major.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.major.entity.Devices;
import com.example.major.entity.Routers;
import com.example.major.repository.RouterRepository;
import com.example.major.repository.DeviceRepository;



@Configuration
public class RouterConfiguration {
	
	
	
	
	
	@Bean
	CommandLineRunner commandLineRunnerRouters(RouterRepository routerRepository,DeviceRepository deviceRepository) {
		
		return args ->{
			
		
			
			
//			
//			Routers velu = new Routers();
//			velu.setAccountNumber(1);
//			velu.setSerialNumber("22034F5000400");
//			velu.setModel("TP_link");
//			velu.setFirmwareVersion("V1.0.0");
//			velu.setIpv4("127.0.30.146");
//			velu.setSsid("Batman's Cave");
//			velu.setPassword("hellorouter");
////			velu.set
//			
//			
//			Devices device1 = new Devices();
//			device1.setDeviceId("1");
//			device1.setDeviceType("Android");
//			device1.setMac("velu's phone");
//			device1.setIsBlocked(false);
//			device1.setRouter(velu);
//			
//			
//			Devices device2 = new Devices();
//			device2.setDeviceId("2");
//			device2.setDeviceType("Android");
//			device2.setMac("guru's phone");
//			device2.setIsBlocked(true);
//			device2.setRouter(velu);
//			
//			
//			Devices device3 = new Devices();
//			device3.setDeviceId("3");
//			device3.setDeviceType("Android");
//			device3.setMac("naveen's phone");
//			device3.setIsBlocked(false);
//			device3.setRouter(velu);
//			
//			
//			
//			
//			
//			
//			List<Devices> veluDevice = new ArrayList();
//			//veluDevice.add((Devices) List.of(device1,device2,device3));
//			veluDevice.add(device1);
//			veluDevice.add(device2);
//			veluDevice.add(device3);
//			
//			velu.setDevices(veluDevice);
//			
//			
//
//			
//			
//			
//			
//			
////			1,
////			"22034F5000400",
////			"TP_link",
////			"V1.0.0",
////			"127.0.30.146",
////			"Batman's Cave",
////			"hellorouter",
//			
//			
//			Routers guru = new Routers(
//					2,
//					"22034F5000410",
//					"TP_link",
//					"V1.0.0",
//					"127.0.30.146",
//					"Superman's Cave",
//					"hellorouter"		
//					);
//			
//			Devices device4 = new Devices();
//			device4.setDeviceId("1");
//			device4.setDeviceType("Android");
//			device4.setMac("naveen's phone");
//			device4.setIsBlocked(true);
//			device4.setRouter(guru);
//			
//			
//			Devices device5 = new Devices();
//			device5.setDeviceId("2");
//			device5.setDeviceType("Android");
//			device5.setMac("guru's phone");
//			device5.setIsBlocked(false);
//			device5.setRouter(guru);
//			
//			
//			List<Devices> guruDevice = new ArrayList();
//			guruDevice.add(device4);
//			guruDevice.add(device5);
//			guru.setDevices(guruDevice);
//			
//			routerRepository.saveAll(List.of(velu,guru));
//			
////			System.out.println(device3.getRouter().getAccountNumber());
////			System.out.println(device3.getRouter().getIpv4());
////			System.out.println(device3.getRouter().getSsid());
//			
////			deviceRepository.save(new Devices("1trial","1trial" , "2trial", "hello", velu));
////			deviceRepository.save(new Devices("2trial","2trial" , "3trial", "hello", velu));
////			deviceRepository.save(new Devices("3trial","3trial" , "4trial", "hello", velu));
			
		};

	}
	

}
