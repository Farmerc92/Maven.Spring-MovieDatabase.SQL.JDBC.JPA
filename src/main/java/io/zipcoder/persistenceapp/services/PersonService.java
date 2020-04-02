package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.jdbc.PersonMapper;
import io.zipcoder.persistenceapp.models.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PersonService {

    DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:testdb", "sa","");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public void createPerson(Person person){
        jdbcTemplate.execute("INSERT INTO PERSON(id, first_name, last_name, birthday, mobile, home_id)" +
                "VALUES ("+ person.getId() + ", '" + person.getFirst_name()+ "','" + person.getLast_name() + "','" +
                person.getBirthday() + "', '" + person.getMobile() + "', " + person.getHome_id() + ");");
    }

    public Person findById(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE ID = "+ id+ ";", new Object[]{id}, new PersonMapper());
    }

    public List<Person> findAll(){
        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonMapper());
    }

    public Person updatePerson(Person person){
        jdbcTemplate.execute("UPDATE PERSON SET first_name = '" + person.getFirst_name() + "', last_name = '" + person.getLast_name()
         + "', mobile = '" + person.getMobile() + "', birthday = '" + person.getBirthday() + "', home_id = " + person.getHome_id()
         + "WHERE id = " + person.getId());
        return findById(person.getId());
    }

    public boolean deletePerson(Integer id){
        if (jdbcTemplate.update("DELETE FROM PERSON WHERE id = " + id) == 1)
            return true;
        return false;
    }

    public boolean deleteListPerson(List<Person> people){
        boolean[] checks = new boolean[people.size()];
        int count = 0;
        for (Person p : people){
            int tempId = p.getId();
            checks[count++] = deletePerson(tempId);
        }
        for (boolean b : checks) {
            if (!b)
                return false;
        }
        return true;
    }

    public List<Person> findAllByFirst(String first){
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE first_name = " + first, new PersonMapper());
    }

    public List<Person> findAllByLast(String last){
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE last_name = " + last, new PersonMapper());
    }

    public List<Person> findAllByBirthday(String birthday){
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE birthday = " + birthday, new PersonMapper());
    }

    public Map<String, ArrayList<Person>> getSurnameMap(){
        Map<String, ArrayList<Person>> map = new HashMap<>();
        findAll().forEach(person -> {
            if (!map.containsKey(person.getLast_name()))
                map.put(person.getLast_name(), new ArrayList<>(Arrays.asList(person)));
            else
                map.get(person.getLast_name()).add(person);
        });
        return map;
    }

    public Map<String, Integer> getFirstNameCount(){
        Map<String, Integer> map = new HashMap<>();
        findAll().forEach(person -> map.compute(person.getFirst_name(), (name, count) -> (name == null) ? 1 : count++));
        return map;
    }

    public List<Person> findAllByMobile(String mobile){
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE mobile = " + mobile, new PersonMapper());
    }

}
