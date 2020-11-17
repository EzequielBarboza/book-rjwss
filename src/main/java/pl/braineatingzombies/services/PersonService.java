package pl.braineatingzombies.services;

import pl.braineatingzombies.entities.Person;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Ezequiel Barboza
 */
@Path("person")
public class PersonService
{
	private final Map<Integer, Person> dataInMemory = new HashMap<>();
	private final AtomicInteger idGenerator = new AtomicInteger();

	@POST
	@Consumes("application/xml")
	public Response save(final Person person)
	{
		int id = idGenerator.incrementAndGet();
		person.setId(id);
		dataInMemory.put(id, person);
		return Response.created(URI.create("/person/" + id)).build();
	}

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public Person findById(@PathParam("id") final int id)
	{
		return Optional.ofNullable(dataInMemory.get(id)).orElseThrow(() -> new WebApplicationException(Status.NOT_FOUND));
	}
}
