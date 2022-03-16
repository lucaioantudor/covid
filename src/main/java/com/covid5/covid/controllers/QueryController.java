package com.covid5.covid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QueryController {

    //Returns SQL query to get daily infections and deaths
    //for given country up and including to the given date
    public String sqlQuery(String name, String date) {
        return "SELECT c.infections, c.deaths, c.recorded_date, cc.name " +
        "FROM cases as c " +
        "JOIN countries as cc ON cc.code = c.iso_country " +
        "WHERE c.recorded_date < \'" + date + "\' AND cc.name = \'" + name + "\' " +
        "ORDER BY c.recorded_date DESC";
    }

    //Establish connection to the database
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql//:localhost:5432/lunatech_covid", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //Stores query result in apropriate object
    public List<List<String>> getQuery(String country, String date) {
        List<List<String>> result = new ArrayList <>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery(country, date));
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String infections = rs.getString("infections");
                String deaths = rs.getString("deaths");
                String recorded_date = rs.getString("recorded_date");
                result.add(new ArrayList<>(){{add(infections); add(deaths); add(recorded_date);}});
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        System.out.println(result.toString());
        return result;
    }

    //Mock function to develop with no database connection
    public List<List<String>> getQueryDummy(String country, String date) {
        List<List<String>> result = new ArrayList<>();
        if(!country.equals("France")) return result;
        result.add(new ArrayList<>(){{add("4861"); add("509"); add("2020-04-02");}});
        result.add(new ArrayList<>(){{add("7578"); add("499"); add("2020-04-01");}});
        result.add(new ArrayList<>(){{add("4376"); add("418"); add("2020-03-31");}});
        result.add(new ArrayList<>(){{add("2599"); add("292"); add("2020-03-30");}});
        result.add(new ArrayList<>(){{add("4611"); add("319"); add("2020-03-29");}});
        result.add(new ArrayList<>(){{add("3809"); add("299"); add("2020-03-28");}});
        result.add(new ArrayList<>(){{add("3922"); add("365"); add("2020-03-27");}});
        result.add(new ArrayList<>(){{add("2931"); add("231"); add("2020-03-26");}});
        result.add(new ArrayList<>(){{add("2446"); add("240"); add("2020-03-25");}});
        result.add(new ArrayList<>(){{add("3838"); add("186"); add("2020-03-24");}});
        result.add(new ArrayList<>(){{add("1559"); add("112"); add("2020-03-23");}});
        result.add(new ArrayList<>(){{add("1847"); add("112"); add("2020-03-22");}});
        result.add(new ArrayList<>(){{add("1617"); add("78"); add("2020-03-21");}});
        result.add(new ArrayList<>(){{add("1861"); add("128"); add("2020-03-20");}});
        result.add(new ArrayList<>(){{add("1404"); add("69"); add("2020-03-19");}});
        result.add(new ArrayList<>(){{add("1097"); add("27"); add("2020-03-18");}});
        result.add(new ArrayList<>(){{add("1210"); add("21"); add("2020-03-17");}});
        result.add(new ArrayList<>(){{add("924"); add("36"); add("2020-03-16");}});
        result.add(new ArrayList<>(){{add("838"); add("12"); add("2020-03-15");}});
        result.add(new ArrayList<>(){{add("785"); add("18"); add("2020-03-14");}});
        result.add(new ArrayList<>(){{add("595"); add("13"); add("2020-03-13");}});
        result.add(new ArrayList<>(){{add("497"); add("15"); add("2020-03-12");}});
        result.add(new ArrayList<>(){{add("372"); add("3"); add("2020-03-11");}});
        result.add(new ArrayList<>(){{add("286"); add("11"); add("2020-03-10");}});
        result.add(new ArrayList<>(){{add("410"); add("9"); add("2020-03-09");}});
        result.add(new ArrayList<>(){{add("103"); add("1"); add("2020-03-08");}});
        result.add(new ArrayList<>(){{add("190"); add("2"); add("2020-03-07");}});
        result.add(new ArrayList<>(){{add("138"); add("3"); add("2020-03-06");}});
        result.add(new ArrayList<>(){{add("73"); add("0"); add("2020-03-05");}});
        result.add(new ArrayList<>(){{add("34"); add("1"); add("2020-03-04");}});
        result.add(new ArrayList<>(){{add("48"); add("1"); add("2020-03-03");}});
        result.add(new ArrayList<>(){{add("30"); add("0"); add("2020-03-02");}});
        result.add(new ArrayList<>(){{add("43"); add("0"); add("2020-03-01");}});
        result.add(new ArrayList<>(){{add("19"); add("0"); add("2020-02-29");}});
        result.add(new ArrayList<>(){{add("21"); add("0"); add("2020-02-28");}});
        result.add(new ArrayList<>(){{add("3"); add("1"); add("2020-02-27");}});
        result.add(new ArrayList<>(){{add("2"); add("0"); add("2020-02-26");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-25");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-24");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-23");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-22");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-21");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-20");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-19");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-18");}});
        result.add(new ArrayList<>(){{add("1"); add("0"); add("2020-02-17");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-16");}});
        result.add(new ArrayList<>(){{add("0"); add("1"); add("2020-02-15");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-14");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-13");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-12");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-11");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-10");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-09");}});
        result.add(new ArrayList<>(){{add("5"); add("0"); add("2020-02-08");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-07");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-06");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-05");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-04");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-03");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-02");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-02-01");}});
        result.add(new ArrayList<>(){{add("1"); add("0"); add("2020-01-31");}});
        result.add(new ArrayList<>(){{add("1"); add("0"); add("2020-01-30");}});
        result.add(new ArrayList<>(){{add("1"); add("0"); add("2020-01-29");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-28");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-27");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-26");}});
        result.add(new ArrayList<>(){{add("3"); add("0"); add("2020-01-25");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-24");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-23");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-22");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-21");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-20");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-19");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-18");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-17");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-16");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-15");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-14");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-13");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-12");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-11");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-10");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-09");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-08");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-07");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-06");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-05");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-04");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-03");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-02");}});
        result.add(new ArrayList<>(){{add("0"); add("0"); add("2020-01-01");}});
        return result;
    }

    //Adds query results to model and redirects to appropiate page
    @RequestMapping("/query")
    public String showReports(@RequestParam(required = false) String country, @RequestParam(required = false)
    String date, ModelMap model) {
        System.out.println("query");
        if(country != null && date != null) {
            model.addAttribute("infectionsAndDeaths", getQuery(country, date));
        }
        return "query";
	}
}
