package pl.braineatingzombies.application;

import pl.braineatingzombies.services.PersonService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Ezequiel Barboza
 */
@ApplicationPath("/services")
public class MyRestEasyApplication extends Application
{
	private final Set<Object> services;

	public MyRestEasyApplication()
	{
		services = new HashSet<>();
		services.add(new PersonService());
	}

	@Override
	public Set<Object> getSingletons()
	{
		return services;
	}
}
