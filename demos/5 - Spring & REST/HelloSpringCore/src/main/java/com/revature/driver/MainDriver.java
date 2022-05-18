package com.revature.driver;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Pokemon;
import com.revature.service.PokemonService;
import com.revature.service.PokemonServiceImpl;

/* What is Spring?
 *  Spring is an ecosystem of various open-source projects and modules that help ease the process of building Java apps
 *  
 *  What is a Spring module?
 *   - is a grouping of libraries put together to achieve some goal
 *   - each of these modules can be interchanged to fit the developer's needs of infrastructure in any project
 *   
 *  What is a Spring Bean?
 *  - a class that its dependencies will be managed by Spring's IOC container
 *  
 *  What is IOC?
 *  - inversion of control
 *  - when you give up control or functionality and give that responsibility to another framework or entity
 *  
 *  What is Dependency Injection?
 *  - when you give up the instantiation of your dependencies to the framework or entity
 * 
 * How do we define our IOC container in Spring?
 * - 2 ways:
 * 	1) BeanFactory (the old way <- it doesn't allow annotation configuration of spring beans)
 * 	2) ApplicationContext (newer way <- more framework-oriented way to configure beans through annotations)
 * 
 * - In-class exercise:
 * - change my beans.xml to use Autowiring (using @Autowired annotation)
 */
public class MainDriver {

	//1. set up my ApplicationContext so I can define the IOC container
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		// 2. need an instance of my service
		PokemonService pokeService = appContext.getBean(PokemonServiceImpl.class);
		
		// 3. print out the contents that I get back from my fake db
		List<Pokemon> list = pokeService.getAll();
		
		System.out.println("Amazing Pokemon Roster: ");
		for(Pokemon pokemon : list) {
			System.out.println(pokemon);
		}
	}

}
