package com.example.major.configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.major.entity.Address;
import com.example.major.entity.Bills;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Plans;
import com.example.major.entity.Routers;
import com.example.major.entity.paymentHistory;
import com.example.major.repository.AdressRepository;
import com.example.major.repository.BillRepository;
import com.example.major.repository.CustomerRepository;
import com.example.major.repository.DeviceRepository;
import com.example.major.repository.PlanRepository;
import com.example.major.repository.RouterRepository;
import com.example.major.repository.paymentHistoryRepository;

@Configuration
public class CustomersConfiguration {
	
	
	@Bean
	CommandLineRunner commandLineRunner33(CustomerRepository customerRepository,PlanRepository planRepository,
				RouterRepository routerRepository,DeviceRepository deviceRepository, BillRepository billRepository,paymentHistoryRepository historyrepository, AdressRepository addresRepository) {
		return args->{
			
		/*procedure to add a customer
		 * 1.Create a Customer
		 * 2. add plans and add it to the plan list of customer
		 * 3.Create one bill and one router for the customer(router is optional)
		 * 4.Add devices if the router exists and also set the router and device mapping.
		 * 
		 * */
			
		/*
		 * velu & isu = 3 plans 
		 * nivi and guru = defaulter
		 * srija and naveen = router explanation
		 * 
		 * */
			
		
			
			Address ambattur = new Address("ambattur");
			Address thirumulaivayol = new Address("thirumulaivayol");
			Address kovilambakkam = new Address("kovilambakkam");
			Address tambaram = new Address("tambaram");
			Address tiruvallikeni = new Address("tiruvallikeni");
			
			
			
			
			
			List<Routers> ambatturlist = new ArrayList();
			List<Routers> thirumulaivayolList = new ArrayList();
			List<Routers> kovilambakkamList = new ArrayList();
			List<Routers> tambaramlist = new ArrayList();
			List<Routers> tiruvallikenilist = new ArrayList();
			
			
			
		////////////////////THESE VALUES ARE FOR PRESENTING////////////////////////////////////////////	
//			Customers velu = new Customers(
//					"Pethachi PR",
//					"f-7 gr flats",
//					"velu@gmail.com",
//					"+919789876704",
//					1					
//					);
			
			Customers velu = new Customers(
					"Naveen PK",
					"f-7 gr flats",
					"naveen@gmail.com",
					"+917904482942",
					1					
					);
			
			
			Plans plan1 = new Plans("Basic",
						"100",
						"100GB",
						"0GB",
						500,
						true
					);
			plan1.setCustomer(velu);
			
			paymentHistory payment1 = new paymentHistory(500l
					,"UPI",
					LocalDate.of(2023,Month.JULY,30),
					"Basic",
					LocalDate.of(2023,Month.JUNE,30)
					,1l
					);
			
			
			
			paymentHistory payment2 = new paymentHistory(516l
					,"UPI"
					,LocalDate.of(2023,Month.AUGUST,30),
					"Basic",
					LocalDate.of(2023,Month.JULY,30),
					1l
					);
			
			paymentHistory payment3 = new paymentHistory(560l
					,"UPI",
					LocalDate.of(2023,Month.SEPTEMBER,29),
					"Basic"
					,LocalDate.of(2023,Month.AUGUST,29),
					1l
					);
			
			paymentHistory payment4 = new paymentHistory(500l
					,"UPI",
					LocalDate.of(2023,Month.OCTOBER,31),
					"Basic"
					,LocalDate.of(2023,Month.NOVEMBER,1),
					1l
					);
			
			
			List<paymentHistory> paymentvelu = new ArrayList();
			paymentvelu.add(payment1);
			paymentvelu.add(payment2);
			paymentvelu.add(payment3);
			paymentvelu.add(payment4);
			velu.setPayments(paymentvelu);
			payment1.setCustomerhistory(velu);
			payment2.setCustomerhistory(velu);
			payment3.setCustomerhistory(velu);
			payment4.setCustomerhistory(velu);
			
					
			Bills plan1bill  = new Bills(
					LocalDate.of(2023, Month.NOVEMBER,1),
					LocalDate.of(2023,Month.OCTOBER,1)
					);
			
			plan1bill.setPlans(plan1);
			plan1.setBills(plan1bill);
			
			List<Plans> Velulist = new ArrayList();
			Velulist.add(plan1);
			velu.setPlans(Velulist);
			
			
			
			

			Routers veluRouter = new Routers();
			veluRouter.setAccountNumber(1);
			veluRouter.setSerialNumber("22034F5000400");
			veluRouter.setModel("TP_link");
			veluRouter.setFirmwareVersion("V1.0.0");
			veluRouter.setIpv4("192.168.1.0");
			veluRouter.setSsid("Naveen's Cave");
			veluRouter.setPassword("hellorouter");
			veluRouter.setAddress(ambattur);
			veluRouter.setPlans(plan1);
			plan1.setRouter(veluRouter);
			
			ambatturlist.add(veluRouter);
			ambattur.setRouter(ambatturlist);

			
			
			
			Devices device1 = new Devices();
			device1.setDeviceId("1");
			device1.setDeviceType("Android");
			device1.setMac("velu's phone");
			device1.setIsBlocked(false);
			device1.setRouter(veluRouter);
			
			
			Devices device2 = new Devices();
			device2.setDeviceId("2");
			device2.setDeviceType("Android");
			device2.setMac("guru's phone");
			device2.setIsBlocked(true);
			device2.setRouter(veluRouter);
			
			
			Devices device3 = new Devices();
			device3.setDeviceId("3");
			device3.setDeviceType("Android");
			device3.setMac("naveen's phone");
			device3.setIsBlocked(false);
			device3.setRouter(veluRouter);
			
			
			
			Devices device4trial = new Devices();
			device4trial.setDeviceId("4");
			device4trial.setDeviceType("Android");
			device4trial.setMac("Mom phone");
			device4trial.setIsBlocked(false);
			device4trial.setRouter(veluRouter);
			
			Devices device5trial = new Devices();
			device5trial.setDeviceId("5");
			device5trial.setDeviceType("Android");
			device5trial.setMac("dad phone");
			device5trial.setIsBlocked(false);
			device5trial.setRouter(veluRouter);
			
			
			
			List<Devices> veluDevice = new ArrayList();
			//veluDevice.add((Devices) List.of(device1,device2,device3));
			veluDevice.add(device1);
			veluDevice.add(device2);
			veluDevice.add(device3);
			veluDevice.add(device4trial);
			veluDevice.add(device5trial);
			
			
			
			veluRouter.setDevices(veluDevice);
			
			
			

			
			
			
			
			
////////////////////////////customer velu ends here//////////////////////////
			
			
			Customers guru = new Customers(
					"guru",
					"f-7 gr flats",
					"guru@gmail.com",
					"+919344062366",
					2										
					);
			
			
			
			List<Plans> GuruList = new ArrayList();
			
			Plans plan6 = new Plans("Premium",
					"150",
					"250GB",
					"90GB",
					800,
					false
				);
			plan6.setCustomer(guru);
			
			
			
			
			
			paymentHistory payment2_1 = new paymentHistory(800l
					,"UPI"
					,LocalDate.of(2023,Month.AUGUST,24),
					"Premium",
					LocalDate.of(2023,Month.JULY,25),
					2l
					);
			List<paymentHistory> paymentguru = new ArrayList();
			paymentguru.add(payment2_1);
			guru.setPayments(paymentguru);
			payment2_1.setCustomerhistory(guru);
			
			Bills plan6bill  = new Bills(
					LocalDate.of(2023,Month.AUGUST,24),
					LocalDate.of(2023, Month.JULY,30)
					);

			plan6bill.setPlans(plan6);
			plan6.setBills(plan6bill);
			
			
			GuruList.add(plan6);
			guru.setPlans(GuruList);
			
			
			
			/*
			 
			  
			  Plans plan1 = new Plans("Basic",
						"100",
						"100GB",
						"60GB",
						500
					);
			plan1.setCustomer(velu);
			
			paymentHistory payment1 = new paymentHistory(433l
					,"UPI"
					,LocalDate.now()
					,LocalDate.now()
					,1l
					);
			
			
			List<paymentHistory> paymentvelu = new ArrayList();
			paymentvelu.add(payment1);
			velu.setPayments(paymentvelu);
			payment1.setCustomerhistory(velu);

			
			//////////////////////////////////////////////////
			
			Bills plan1bill  = new Bills(
					LocalDate.of(2023,Month.OCTOBER,22),
					LocalDate.of(2023, Month.SEPTEMBER,22)
					);
			
			plan1bill.setPlans(plan1);
			plan1.setBills(plan1bill);
			
			List<Plans> Velulist = new ArrayList();
			Velulist.add(plan1);
			velu.setPlans(Velulist);
			  
			  
			 */
			
			

			Routers guruRouter = new Routers(
			2,
			"22034F5000410",
			"TP_link",
			"V1.0.0",
			"127.0.30.146",
			"Superman's Cave",
			"hellorouter"		
			);
			guruRouter.setPlans(plan6);
			guruRouter.setAddress(thirumulaivayol);
			plan6.setRouter(guruRouter);
			
			thirumulaivayolList.add(guruRouter);
			
			thirumulaivayol.setRouter(thirumulaivayolList);

			
			Devices device4 = new Devices();
			device4.setDeviceId("1");
			device4.setDeviceType("Android");
			device4.setMac("naveen's phone");
			device4.setIsBlocked(true);
			device4.setRouter(guruRouter);
			
			
			Devices device5 = new Devices();
			device5.setDeviceId("2");
			device5.setDeviceType("Android");
			device5.setMac("guru's phone");
			device5.setIsBlocked(true);
			device5.setRouter(guruRouter);
			
			List<Devices> guruDevice = new ArrayList();
			guruDevice.add(device4);
			guruDevice.add(device5);
			guruRouter.setDevices(guruDevice);
			
			
			

			
	/////////////////////////////////guru ends here////////////////////////////////////////////////////		
			
			//change nivi wifi address.
			
			Customers nivi = new Customers(
					"nivedha",
					"f-7 gr flats",
					"nivi@gmail.com",
					"+919789096749",
					4										
					);
			
			
			
			List<Plans> niviList = new ArrayList();
			
			Plans plannivi = new Plans("Premium",
					"150",
					"250GB",
					"100GB",
					800,
					false
				);
			plannivi.setCustomer(nivi);
			
			

			niviList.add(plannivi);
			nivi.setPlans(niviList);
			
			
			paymentHistory niviPayment = new paymentHistory(800l
					,"UPI"
					,LocalDate.of(2023,Month.AUGUST,30),
					"Premium",
					LocalDate.of(2023,Month.JULY,30),
					6l
					);
			List<paymentHistory> paymnetNivi = new ArrayList();
			paymnetNivi.add(niviPayment);
			nivi.setPayments(paymnetNivi);
			niviPayment.setCustomerhistory(nivi);
			
			Bills nivibill  = new Bills(
					LocalDate.of(2023,Month.AUGUST,30),
					LocalDate.of(2023, Month.JULY,30)
					);

			nivibill.setPlans(plannivi);
			plannivi.setBills(nivibill);
			
			
			
			
			
			Routers niviRouter = new Routers(
					4,
					"22034F5000425",
					"TP_link",
					"V1.0.0",
					"127.0.30.146",
					"Nivi Home",
					"hellorouter"		
					);
			niviRouter.setPlans(plannivi);
			niviRouter.setAddress(tambaram);
			plannivi.setRouter(niviRouter);
					
			tambaramlist.add(niviRouter);
					
			tambaram.setRouter(tambaramlist);

					
			Devices device10 = new Devices();
			device10.setDeviceId("1");
			device10.setDeviceType("Android");
			device10.setMac("mom phone");
			device10.setIsBlocked(false);
			device10.setRouter(niviRouter);
			
			
			Devices device11 = new Devices();
			device11.setDeviceId("2");
			device11.setDeviceType("Android");
			device11.setMac("nivi phone");
			device11.setIsBlocked(true);
			device11.setRouter(niviRouter);
			
			List<Devices> niviDevice = new ArrayList();
			niviDevice.add(device10);
			niviDevice.add(device11);
			niviRouter.setDevices(niviDevice);


			
			
	////////////////////////////////// nivi ends here///////////////////////////////////////////////////

			
			
			
			
			
			Customers srija = new Customers(
					"Srija G",
					"f-7 gr flats",
					"srija@gmail.com",
					"+919361675460",
					5				
					);
			
			Plans plansrija = new Plans("Basic",
					"100",
					"100GB",
					"0GB",
					500,
					true
				);
			plansrija.setCustomer(srija);
			
			paymentHistory paymentsrija1 = new paymentHistory(500l
					,"UPI",
					LocalDate.of(2023,Month.JULY,30),
					"Basic",
					LocalDate.of(2023,Month.JUNE,30)
					,7l
					);
			
			
			
			paymentHistory paymentsrija2 = new paymentHistory(516l
					,"UPI"
					,LocalDate.of(2023,Month.AUGUST,30),
					"Basic",
					LocalDate.of(2023,Month.JULY,30),
					7l
					);
			
			paymentHistory paymentsrija3 = new paymentHistory(560l
					,"UPI",
					LocalDate.of(2023,Month.SEPTEMBER,29),
					"Basic"
					,LocalDate.of(2023,Month.AUGUST,29),
					7l
					);
			
			paymentHistory paymentsrija4 = new paymentHistory(500l
					,"UPI",
					LocalDate.of(2023,Month.OCTOBER,31),
					"Basic"
					,LocalDate.of(2023,Month.NOVEMBER,1),
					7l
					);
			
			
			List<paymentHistory> paymentsrija = new ArrayList();
			paymentsrija.add(paymentsrija1);
			paymentsrija.add(paymentsrija2);
			paymentsrija.add(paymentsrija3);
			paymentsrija.add(paymentsrija4);
			srija.setPayments(paymentsrija);
			paymentsrija1.setCustomerhistory(srija);
			paymentsrija2.setCustomerhistory(srija);
			paymentsrija3.setCustomerhistory(srija);
			paymentsrija4.setCustomerhistory(srija);
			
					
			Bills planbillssrija  = new Bills(
					LocalDate.of(2023, Month.NOVEMBER,1),
					LocalDate.of(2023,Month.OCTOBER,1)
					);
			
			planbillssrija.setPlans(plansrija);
			plansrija.setBills(planbillssrija);
			
			List<Plans> srijalist = new ArrayList();
			srijalist.add(plansrija);
			srija.setPlans(srijalist);
			
			
			
			Routers srijaRouter = new Routers();
			srijaRouter.setAccountNumber(1);
			srijaRouter.setSerialNumber("22034F5000122");
			srijaRouter.setModel("TP_link");
			srijaRouter.setFirmwareVersion("V1.0.0");
			srijaRouter.setIpv4("192.168.1.0");
			srijaRouter.setSsid("Srija Cave");
			srijaRouter.setPassword("hellorouter");
			srijaRouter.setAddress(tiruvallikeni);
			srijaRouter.setPlans(plansrija);
			plansrija.setRouter(srijaRouter);
			
			tiruvallikenilist.add(srijaRouter);
			tiruvallikeni.setRouter(tiruvallikenilist);

			
			
			
			Devices devicesrija1 = new Devices();
			devicesrija1.setDeviceId("1");
			devicesrija1.setDeviceType("Android");
			devicesrija1.setMac("velu's phone");
			devicesrija1.setIsBlocked(false);
			devicesrija1.setRouter(srijaRouter);
			
			
			Devices devicesrija2 = new Devices();
			devicesrija2.setDeviceId("2");
			devicesrija2.setDeviceType("Android");
			devicesrija2.setMac("guru's phone");
			devicesrija2.setIsBlocked(true);
			devicesrija2.setRouter(srijaRouter);
			
			
			Devices devicesrija3 = new Devices();
			devicesrija3.setDeviceId("3");
			devicesrija3.setDeviceType("Android");
			devicesrija3.setMac("naveen's phone");
			devicesrija3.setIsBlocked(false);
			devicesrija3.setRouter(srijaRouter);
			
			
			
//			Devices device4trial = new Devices();
//			device4trial.setDeviceId("4");
//			device4trial.setDeviceType("Android");
//			device4trial.setMac("Mom phone");
//			device4trial.setIsBlocked(false);
//			device4trial.setRouter(veluRouter);
//			
//			Devices device5trial = new Devices();
//			device5trial.setDeviceId("5");
//			device5trial.setDeviceType("Android");
//			device5trial.setMac("dad phone");
//			device5trial.setIsBlocked(false);
//			device5trial.setRouter(veluRouter);
			
			
			
			List<Devices> srijaDevice = new ArrayList();
			//veluDevice.add((Devices) List.of(device1,device2,device3));
			srijaDevice.add(devicesrija1);
			srijaDevice.add(devicesrija2);
			srijaDevice.add(devicesrija3);
			//veluDevice.add(device4trial);
			//veluDevice.add(device5trial);
			
			
			
			srijaRouter.setDevices(srijaDevice);
			
			
			
			
			
	//////////////////////////////////srija ends here//////////////////////////////////////////////////////
			
//			Customers isu = new Customers(
//					"iswarya",
//					"f-7 gr flats",
//					"isu@gmail.com",
//					"+918428984718",
//					3										
//					);
			
			Customers isu = new Customers(
					"Pethachi PR",
					"f-7 gr flats",
					"velu@gmail.com",
					"+919789876704",
					3										
					);
			
			Plans planisu = new Plans("Basic",
					"100",
					"100GB",
					"30GB",
					500,
					true
				);
			planisu.setCustomer(isu);
			
			
			Plans planisuexpiry = new Plans("Premium",
					"100",
					"250GB",
					"50GB",
					800,
					true
				);
			planisuexpiry.setCustomer(isu);
			
			
			Plans planisuexpired = new Plans("Basic",
					"100",
					"100GB",
					"90GB",
					500,
					false
					);
			planisuexpired.setCustomer(isu);

			
			
			
			
			
			
			
			
			
			
			paymentHistory paymentisu1 = new paymentHistory(500l
					,"Card",
					LocalDate.of(2023,Month.NOVEMBER,20),
					"Basic",
					LocalDate.of(2023,Month.OCTOBER,20)
					,3l
					);
			
			
			paymentHistory paymentisuexpiry1 = new paymentHistory(800l
					,"Card",
					LocalDate.of(2023,Month.NOVEMBER,4),
					"Premium",
					LocalDate.of(2023,Month.OCTOBER,4)
					,4l
					);
			
			paymentHistory paymentisuexpired = new paymentHistory(500l
					,"Card",
					LocalDate.of(2023,Month.OCTOBER,7),
					"Basic",
					LocalDate.of(2023,Month.SEPTEMBER,7)
					,5l
					);
			
			
			List<paymentHistory> paymentisu = new ArrayList();
			paymentisu.add(paymentisu1);
			paymentisu.add(paymentisuexpiry1);
			paymentisu.add(paymentisuexpired);
			
			
			isu.setPayments(paymentisu);
			paymentisu1.setCustomerhistory(isu);
			paymentisuexpiry1.setCustomerhistory(isu);
			paymentisuexpired.setCustomerhistory(isu);
			
			
			
			
			
			Bills planISUbill  = new Bills(
					LocalDate.of(2023,Month.NOVEMBER,20),
					LocalDate.of(2023, Month.OCTOBER,20)
					);
			planISUbill.setPlans(planisu);
			planisu.setBills(planISUbill);
			
			Bills planISU2bill  = new Bills(
					LocalDate.of(2023,Month.NOVEMBER,4),
					LocalDate.of(2023, Month.OCTOBER,4)
					);
			planISU2bill.setPlans(planisuexpiry);
			planisuexpiry.setBills(planISU2bill);
			
			
			Bills planISUexpire2bill  = new Bills(
					LocalDate.of(2023,Month.OCTOBER,7),
					LocalDate.of(2023, Month.SEPTEMBER,7)
					);
			planISUexpire2bill.setPlans(planisuexpired);
			planisuexpired.setBills(planISUexpire2bill);
			
			
			
			List<Plans> isuList = new ArrayList();
						
						isuList.add(planisu);
						isuList.add(planisuexpiry);
						isuList.add(planisuexpired);
						isu.setPlans(isuList);
			
			
			


						
			Routers isuRouter = new Routers();
			isuRouter.setAccountNumber(3);
			isuRouter.setSerialNumber("22034F5000500");
			isuRouter.setModel("TP_link");
			isuRouter.setFirmwareVersion("V1.0.0");
			isuRouter.setIpv4("192.168.1.0");
			isuRouter.setSsid("Batman's Cave");
			isuRouter.setPassword("hellorouter");
			isuRouter.setAddress(kovilambakkam);
			isuRouter.setPlans(planisu);
			planisu.setRouter(isuRouter);
			
			
			
			Devices isudevice = new Devices();
			isudevice.setDeviceId("1");
			isudevice.setDeviceType("Android");
			isudevice.setMac("isu's phone");
			isudevice.setIsBlocked(false);
			isudevice.setRouter(isuRouter);
			
			
			Devices isudevice2 = new Devices();
			isudevice2.setDeviceId("2");
			isudevice2.setDeviceType("Android");
			isudevice2.setMac("isu's sister phone");
			isudevice2.setIsBlocked(false);
			isudevice2.setRouter(isuRouter);
			
			Devices isudevice3 = new Devices();
			isudevice3.setDeviceId("3");
			isudevice3.setDeviceType("Android");
			isudevice3.setMac("neighbour phone");
			isudevice3.setIsBlocked(true);
			isudevice3.setRouter(isuRouter);
			
			
			List<Devices> isuRouterdevices = new ArrayList();
			isuRouterdevices.add(isudevice);
			isuRouterdevices.add(isudevice2);
			isuRouterdevices.add(isudevice3);
			
			
			
			
			isuRouter.setDevices(isuRouterdevices);

			
			
			
			

			
			
			
			Routers isuRouter2 = new Routers();
			isuRouter2.setAccountNumber(3);
			isuRouter2.setSerialNumber("22034F5000700");
			isuRouter2.setModel("TP_link");
			isuRouter2.setFirmwareVersion("V1.0.0");
			isuRouter2.setIpv4("192.168.1.0");
			isuRouter2.setSsid("velu Router 2");
			isuRouter2.setPassword("hellorouter");
			isuRouter2.setAddress(kovilambakkam);
			isuRouter2.setPlans(planisuexpiry);
			planisuexpiry.setRouter(isuRouter2);
			
			
			
			Devices isudevice4 = new Devices();
			isudevice4.setDeviceId("1");
			isudevice4.setDeviceType("Android");
			isudevice4.setMac("isu's dad phone");
			isudevice4.setIsBlocked(false);
			isudevice4.setRouter(isuRouter2);
			
			
			Devices isudevice5 = new Devices();
			isudevice5.setDeviceId("2");
			isudevice5.setDeviceType("Android");
			isudevice5.setMac("isu's mom phone");
			isudevice5.setIsBlocked(false);
			isudevice5.setRouter(isuRouter2);
			
			Devices isudevice6 = new Devices();
			isudevice6.setDeviceId("3");
			isudevice6.setDeviceType("Android");
			isudevice6.setMac("neighbour phone");
			isudevice6.setIsBlocked(true);
			isudevice6.setRouter(isuRouter2);
			
			List<Devices> isuRouterdevices2 = new ArrayList();
			isuRouterdevices2.add(isudevice4);
			isuRouterdevices2.add(isudevice5);
			isuRouterdevices2.add(isudevice6);
			
			isuRouter2.setDevices(isuRouterdevices2);

			
			
			
			
			Routers isuRouter3 = new Routers();
			isuRouter3.setAccountNumber(3);
			isuRouter3.setSerialNumber("22034F5000900");
			isuRouter3.setModel("TP_link");
			isuRouter3.setFirmwareVersion("V1.0.0");
			isuRouter3.setIpv4("192.168.1.0");
			isuRouter3.setSsid("Velu Router 3");
			isuRouter3.setPassword("hellorouter");
			isuRouter3.setAddress(kovilambakkam);
			isuRouter3.setPlans(planisuexpired);
			planisuexpired.setRouter(isuRouter3);
			
			
			
			
			
			Devices isudevice7 = new Devices();
			isudevice7.setDeviceId("1");
			isudevice7.setDeviceType("Android");
			isudevice7.setMac("nivi phone");
			isudevice7.setIsBlocked(false);
			isudevice7.setRouter(isuRouter3);
			
			
			Devices isudevice8 = new Devices();
			isudevice8.setDeviceId("2");
			isudevice8.setDeviceType("Android");
			isudevice8.setMac("velu phone");
			isudevice8.setIsBlocked(false);
			isudevice8.setRouter(isuRouter3);
			
			Devices isudevice9 = new Devices();
			isudevice9.setDeviceId("3");
			isudevice9.setDeviceType("Android");
			isudevice9.setMac("guru's phone");
			isudevice9.setIsBlocked(true);
			isudevice9.setRouter(isuRouter3);
			
			
			
			List<Devices> isuRouterdevices3 = new ArrayList();
			isuRouterdevices3.add(isudevice7);
			isuRouterdevices3.add(isudevice8);
			isuRouterdevices3.add(isudevice9);
			
			isuRouter3.setDevices(isuRouterdevices3);

			
			
			
			
			kovilambakkamList.add(isuRouter);			
			kovilambakkamList.add(isuRouter2);
			kovilambakkamList.add(isuRouter3);
			kovilambakkam.setRouter(kovilambakkamList);
		
			
			
/////////////////////////    THESE VALUES ARE FOR PRESENTATION  ////////////////////////////////////////////////////////////////			
		
			
			customerRepository.saveAll(List.of(velu,guru,isu,nivi,srija));
			//customerRepository.save(velu);
			
//			Customers temp = plan1.getCustomer();
//			System.out.println(temp);
			
			
			
			
//			Plans plan2 = new Plans("Premium",
//					"130",
//					"120GB",
//					"10GB",
//					700
//				);
//			plan2.setCustomer(velu);
//			
//			Plans plan3 = new Plans("Basic",
//					"140",
//					"120GB",
//					"80GB",
//					500
//				);
//			plan3.setCustomer(velu);
//			
//			
//			Plans plan4 = new Plans("Basic",
//					"140",
//					"120",
//					60
//				);
//			plan4.setCustomer(velu);
//			
//			
//			Plans plan5 = new Plans("Basic",
//					"140",
//					"120",
//					60
//				);
//			plan5.setCustomer(velu);
			
			
			
			
			//Velulist.add(plan2);
			//Velulist.add(plan3);
			
			
//			Velulist.add(plan4);
//			Velulist.add(plan5);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			
//			Routers veluRouter2 = new Routers();
//			veluRouter2.setAccountNumber(1);
//			veluRouter2.setSerialNumber("22034F5000440");
//			veluRouter2.setModel("TP_link");
//			veluRouter2.setFirmwareVersion("V1.1.0");
//			veluRouter2.setIpv4("127.0.30.196");
//			veluRouter2.setSsid("Batman's Cave2");
//			veluRouter2.setPassword("hellorouter");
//			
//			veluRouter2.setPlans(plan3);
//			plan3.setRouter(veluRouter2);
//			
			
			

			
			
		
			
			

			
			
			
//			
//			
//			Plans plan7 = new Plans("Basic",
//					"140",
//					"120",
//					500
//				);
//			plan7.setCustomer(guru);
//			
//			//			GuruList.add(plan7);

		
//			
//			
//			
//			
////		GuruList.add(plan3);
////		GuruList.add(plan4);
////		GuruList.add(plan5);
//
//			
			
			
			
			
			//customerRepository.save(velu);
			
			///////////////////////////////////////////////////////////////////////////////////
			
			//System.out.println(srija.getPlans().get(0).getRouter().getDevices().get(0).getMac());
			
			/*This is a testing cde to get all the details we want and load them into the customer object*/
			
//			Customers temp = new Customers();
//			temp.setAddress(plan1.getCustomer().getAddress());
//			temp.setEmail(plan1.getCustomer().getEmail());
//			temp.setName(plan1.getCustomer().getName());
//			temp.setphonenumber(plan1.getCustomer().getphonenumber());
//			System.out.println(temp);
			
			//System.out.println(velu.getPlans().get(0).getRouter().getSsid());
			
		};
	}

}
