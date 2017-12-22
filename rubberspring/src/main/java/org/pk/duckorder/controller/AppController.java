/*package org.pk.duckorder.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.pk.duckorder.Greeting;
import org.pk.duckorder.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
//	@Autowired
//    OrderServiceImpl orderService;
     
//    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
//    public String prepareProduct(ModelMap model) {
//        return "index";
//    }
// 
//    @RequestMapping(value = { "/newOrder" }, method = RequestMethod.GET)
//    public String prepareOrder(ModelMap model) {
//        Order order = new Order();
//        model.addAttribute("order", order);
//        return "order";
//    }
 
    @RequestMapping(value = "/newOrder/{clientId}/{quantity}/" , method = RequestMethod.POST)
    public String printWelcome() {
		System.out.println("client Id : " + "7");
		System.out.println("clientId : " + "8");
		return "hello";
	}
    
    @RequestMapping(value = "/newOrder1/" , method = RequestMethod.GET)
    public String printWelcome1() {
		System.out.println("client Id : " + "2");
		System.out.println("clientId : " + "3");
		return "hello";
	}
    
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
     
//    @RequestMapping(value = { "/checkStatus" }, method = RequestMethod.GET)
//    public String checkOrderStatus(ModelMap model) {
//        model.addAttribute("orders", orderService.getAllOrders());
//        return "orderStatus";
//    }
}

*/