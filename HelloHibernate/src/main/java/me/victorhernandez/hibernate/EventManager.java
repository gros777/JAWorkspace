package me.victorhernandez.hibernate;

import org.hibernate.Session;

import java.util.*;

import me.victorhernandez.hibernate.domain.Event;
import me.victorhernandez.hibernate.domain.Person;
import me.victorhernandez.hibernate.util.HibernateUtil;

public class EventManager {

	public static void main(String[] args) {
		EventManager mgr = new EventManager();

		if (args[0].equals("store")) {
			mgr.createAndStoreEvent("My Event", new Date());
		} else if (args[0].equals("list")) {
			List<Event> events = mgr.listEvents();
			for (int i = 0; i < events.size(); i++) {
				Event theEvent = (Event) events.get(i);
				System.out.println("Event: " + theEvent.getTitle() + " Time: "
						+ theEvent.getDate());
			}
		} else if (args[0].equals("listpersonsinevent")) {
			//getting the events
			List<Event> events = mgr.listEvents();
			for (int i = 0; i < events.size(); i++) {
				Event theEvent = (Event) events.get(i);
				//getting persons in each event
				List<Person> persons;
				if ( ( persons = mgr.listPersonsInEvents( theEvent.getId() ) ) == null )
						continue;
				//printing events
				System.out.println("Event: " + theEvent.getTitle() + " Time: "
						+ theEvent.getDate());
				for (int j = 0; j < persons.size(); j++) {
					//printing persons in each event
					Person thePerson = (Person) persons.get(j);
					System.out.println("Person: " + thePerson.getFirstname()
							+ " " + thePerson.getLastname());
				}
			}
		} else if (args[0].equals("addpersontoevent")) {
			Long eventId = mgr.createAndStoreEvent("My Event", new Date());
			Long personId = mgr.createAndStorePerson("Foo", "Bar");
			mgr.addPersonToEvent(personId, eventId);
			System.out.println("Added person " + personId + " to event "
					+ eventId);
		}

		HibernateUtil.getSessionFactory().close();
	}

	private Long createAndStoreEvent(String title, Date theDate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		Long eventId = (Long) session.save(theEvent);

		session.getTransaction().commit();

		return eventId;
	}

	private Long createAndStorePerson(String firstName, String lastName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person thePerson = new Person();
		thePerson.setFirstname(firstName);
		thePerson.setLastname(lastName);

		Long personId = (Long) session.save(thePerson);

		session.getTransaction().commit();

		return personId;

	}

	private List<Event> listEvents() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Event> result = session.createQuery("from Event").list();
		session.getTransaction().commit();
		return result;
	}

	private List<Person> listPersonsInEvents(Long eventId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Person> result = session
				.createQuery("from Person where Event = :eid")
				.setParameter("eid", eventId).list();
		session.getTransaction().commit();
		return result;
	}

	private void addPersonToEvent(Long personId, Long eventId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person aPerson = (Person) session.load(Person.class, personId);
		Event anEvent = (Event) session.load(Event.class, eventId);
		aPerson.getEvents().add(anEvent);

		session.getTransaction().commit();
	}
	
	private void addEmailToPerson(Long personId, String emailAddress) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        // adding to the emailAddress collection might trigger a lazy load of the collection
        aPerson.getEmailAddresses().add(emailAddress);

        session.getTransaction().commit();
    }
}