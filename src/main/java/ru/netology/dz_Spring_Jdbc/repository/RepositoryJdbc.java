package ru.netology.dz_Spring_Jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.dz_Spring_Jdbc.model.Customers;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RepositoryJdbc implements RepositoryInterface {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String myScriptFileName1 = "script1.sql";
    private String myScriptFileName2 = "script2.sql";

    public RepositoryJdbc(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<String> getProductName(String name) {
        final String sql = read(myScriptFileName1);
        System.out.println(namedParameterJdbcTemplate.queryForList(sql, Map.of("name", name), String.class));
        return namedParameterJdbcTemplate.queryForList(sql, Map.of("name", name), String.class);
    }

    @Override
    public List<Customers> getAllElementsName(String name) {
        final String sql1 = read(myScriptFileName2);
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        List<Customers> customers1 = namedParameterJdbcTemplate.query(sql1, params,
                (resultSet, rowNam) -> {
                    System.out.println("Номер строчки на которой находиться курсор: " + rowNam);
                    int id = resultSet.getInt("id");
                    String name1 = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    int age = resultSet.getInt("age");
                    String phone_namber = resultSet.getString(5);
                    return new Customers(id, name1, surname, age, phone_namber);
                });
        return customers1;
    }

    private String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}