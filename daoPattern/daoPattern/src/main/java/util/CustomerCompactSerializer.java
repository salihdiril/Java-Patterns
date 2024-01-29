package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.hazelcast.nio.serialization.compact.CompactReader;
import com.hazelcast.nio.serialization.compact.CompactSerializer;
import com.hazelcast.nio.serialization.compact.CompactWriter;
import models.Customer;

public class CustomerCompactSerializer implements CompactSerializer<Customer> {
	@Override
	public Customer read(CompactReader reader) {
		// Read binary json elements and create the custom object which is used for storing in the IMap object (Deserialization)
		int id = reader.readInt32("customerId");
		String email = reader.readString("email");
		String firstName = reader.readString("firstName");
		String lastName = reader.readString("lastName");
		String company = reader.readString("company");

		String dateString = reader.readString("createdAt");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date createdAt;
		try {
			createdAt = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			createdAt = null;
		}

		String country = reader.readString("country");

		return new Customer(id, email, firstName, lastName, company, createdAt, country);
	}

	@Override
	public void write(CompactWriter writer, Customer object) {
		// Convert the custom object to binary (Serialization)
		writer.writeInt32("customerId", object.getCustomerId());
		writer.writeString("email", object.getEmail());
		writer.writeString("firstName", object.getFirstName());
		writer.writeString("lastName", object.getLastName());
		writer.writeString("company", object.getCompany());

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		writer.writeString("createdAt", dateFormat.format(object.getCreatedAt()));

		writer.writeString("country", object.getCountry());
	}

	@Override
	public String getTypeName() {
		return "Customer";
	}

	@Override
	public Class<Customer> getCompactClass() {
		return Customer.class;
	}
}
