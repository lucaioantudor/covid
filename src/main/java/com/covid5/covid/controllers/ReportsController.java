package com.covid5.covid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class ReportsController {

    //Query top 10 countries by total vaccinations
    private static final String TOP_10_COUNT = "SELECT c.name as country ,v.total as total " +
        "FROM (SELECT SUM(daily_vaccinations) as total, iso_country " +
        "    FROM vaccinations " +
        "        GROUP BY iso_country " +
        "        ORDER BY SUM(daily_vaccinations) DESC) " +
        "    as v " +
        "JOIN countries as c " +
        "ON v.iso_country = c.code " +
        "ORDER BY v.total DESC " +
        "LIMIT 10 ";

    //Query bottom 10 countries by total vaccinations
    private static final String BOT_10_COUNT = "SELECT c.name as country ,v.total as total " +
        "FROM (SELECT SUM(daily_vaccinations) as total, iso_country " +
        "    FROM vaccinations " +
        "        GROUP BY iso_country " +
        "        ORDER BY SUM(daily_vaccinations) DESC) " +
        "    as v " +
        "JOIN countries as c " +
        "ON v.iso_country = c.code " +
        "ORDER BY v.total ASC " +
        "LIMIT 10 ";

    //Query top 10 countries by total infections per 100k inhabitants
    private static final String TOP_10_INF = "SELECT (inf.total * 100000 / c.population) as percent , c.name " +
        "FROM   (SELECT SUM(infections) as total, iso_country " +
		"        FROM cases " +
		"        GROUP BY iso_country) " +
	    "     as inf " +
        "JOIN countries as c " +
        "ON inf.iso_country = c.code " +
        "ORDER BY percent DESC " +
        "LIMIT 10 ";

    //Establish connection to the database
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql//:localhost:5432/lunatech_covid?useSSL=false", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    //Stores query result in apropriate object
    public List<List<String>> getTop10Count() {
        List<List<String>> vaccCount = new ArrayList <>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TOP_10_COUNT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("country");
                String total = rs.getString("total");
                vaccCount.add(new ArrayList<>(){{add(name); add(total);}});
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        System.out.println(vaccCount.toString());
        return vaccCount;
    }

    //Stores query result in apropriate object
    public List<List<String>> getBottom10Count() {
        List<List<String>> vaccCount = new ArrayList <>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(BOT_10_COUNT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("country");
                String total = rs.getString("total");
                vaccCount.add(new ArrayList<>(){{add(name); add(total);}});
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        System.out.println(vaccCount.toString());
        return vaccCount;
    }

    //Stores query result in apropriate object
    public List<List<String>> getTop10Inf() {
        List<List<String>> infPer100k = new ArrayList <>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TOP_10_INF);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String total = rs.getString("percent");
                infPer100k.add(new ArrayList<>(){{add(name); add(total);}});
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        System.out.println(infPer100k.toString());
        return infPer100k;
    }

    //Mock function to develop with no database connection
    public List<List<String>> getTop10CountDummy() {
        List<List<String>> count = new ArrayList<>();
        count.add(new ArrayList<>(){{add("China"); add("2825891952");}});
        count.add(new ArrayList<>(){{add("India"); add("1444446481");}});
        count.add(new ArrayList<>(){{add("United States"); add("521541453");}});
        count.add(new ArrayList<>(){{add("Brazil"); add("331875384");}});
        count.add(new ArrayList<>(){{add("Indonesia"); add("237268232");}});
        count.add(new ArrayList<>(){{add("Germany"); add("154499716");}});
        count.add(new ArrayList<>(){{add("Japan"); add("136757044");}});
        count.add(new ArrayList<>(){{add("Turkey"); add("134896241");}});
        count.add(new ArrayList<>(){{add("United Kingdom"); add("133260622");}});
        count.add(new ArrayList<>(){{add("France"); add("127857011");}});
        return count;
    }

    //Mock function to develop with no database connection
    public List<List<String>> getBottom10CountDummy() {
        List<List<String>> count = new ArrayList<>();
        count.add(new ArrayList<>(){{add("Nauru"); add("168");}});
        count.add(new ArrayList<>(){{add("Burundi"); add("214");}});
        count.add(new ArrayList<>(){{add("Anguilla"); add("331");}});
        count.add(new ArrayList<>(){{add("French Polynesia"); add("656");}});
        count.add(new ArrayList<>(){{add("Grenada"); add("677");}});
        count.add(new ArrayList<>(){{add("Equatorial Guinea"); add("834");}});
        count.add(new ArrayList<>(){{add("Congo (Brazzaville)"); add("969");}});
        count.add(new ArrayList<>(){{add("Andorra"); add("1115");}});
        count.add(new ArrayList<>(){{add("Gabon"); add("1460");}});
        count.add(new ArrayList<>(){{add("Bahamas"); add("1637");}});
        return count;
    }

    //Mock function to develop with no database connection
    public List<List<String>> getTop10InfDummy() {
        List<List<String>> count = new ArrayList<>();
        count.add(new ArrayList<>(){{add("Andorra"); add("94971");}});
        count.add(new ArrayList<>(){{add("Montenegro"); add("66675");}});
        count.add(new ArrayList<>(){{add("Luxembourg"); add("65275");}});
        count.add(new ArrayList<>(){{add("San Marino"); add("57369");}});
        count.add(new ArrayList<>(){{add("French Polynesia"); add("55599");}});
        count.add(new ArrayList<>(){{add("Czech Republic"); add("54312");}});
        count.add(new ArrayList<>(){{add("Belgium"); add("52613");}});
        count.add(new ArrayList<>(){{add("Bahrain"); add("52388");}});
        count.add(new ArrayList<>(){{add("Georgia"); add("51443");}});
        count.add(new ArrayList<>(){{add("Armenia"); add("50175");}});
        return count;
    }

    //Adds query results to model and redirects to appropiate page
    @RequestMapping("/reports")
    public String showReports(ModelMap model) {
        model.addAttribute("top10Count", getTop10Count());
        model.addAttribute("bot10Count", getBottom10Count());
        model.addAttribute("top10Percent", getTop10Inf());
        System.out.println("reports");
        return "reports";
	}
}