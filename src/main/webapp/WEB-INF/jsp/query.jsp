<%@ page import="java.util.*" %>
<!DOCTYPE html>
<head>  
    <title>Query</title>  
    <style>
        body {
            background-color:dimgrey;
        }
        .container {
            margin: auto;
            align-self: center;
            margin-top: 10%;
            width: fit-content;
        }

        ul {
            padding: 0px;
            padding-bottom: 5px;
            margin-bottom: 0px;
            width: fit-content;
            text-align: center;
            background-color: black;
            color: white;
        }

        li {
            align-self: center;
            display: inline; 
            font-weight: bold;
            padding: 5px;
            padding-top: 0px;
            cursor: pointer;
        }

        li:hover {
            text-decoration: underline;
        }

        .table-div {
            background-color: white;
            width: fit-content;
            padding: 10px;
            text-align: center;
            align-self: center;
            margin: auto;
        }

        table, td, th{
            border-spacing: 30px 10px;
            text-align: center;
        }

        a{
            color: inherit;
            text-decoration: none;
        }

        input[type=submit]{
            font-weight: bold;
            background-color: black;
            border: none;
            color: white;
            text-decoration: none;
            padding: 4px;
            cursor: pointer;
        }


    </style>
</head>  
<body>
    <div class = "container">
        <ul>
            <li style="color:black;background-color:white;">Query</li>
            <li><a href="/reports">Reports</a></li>
        </ul>
        <div class = "table-div">
            <h2>Query</h2>
            <p>Get the daily number of cases and deaths in a given country up to and includting to a given date</p>
            <form>
                <label for="country">Country:</label>
                <input type="search" name="country" placeholder="Enter country name">
                <label for="date">Date:</label>
                <input type="date" name="date" style="height: 16px;">
                <input type="submit" value="Search"  style="margin-left: 15px;">
            </form>
            <br>
             <%
                if(request.getParameter("country") == "" && request.getParameter("date") == "") {
                    out.println("<p>You have to enter a country name and date</p>"); 
                } else if (request.getParameter("country") == ""){
                    out.println("<p>You have to enter a country name.</p>"); 
                } else if (request.getParameter("date") == ""){
                    out.println("<p>You have to enter a date.</p>"); 
                } else {
                    if(request.getParameter("country") != null && request.getParameter("date") != null) {
                        if(request.getAttribute("infectionsAndDeaths") != null) {
                            ArrayList<ArrayList<String>> infectionsAndDeaths= (ArrayList<ArrayList<String>>)request.getAttribute("infectionsAndDeaths");
                            if(infectionsAndDeaths.size() > 0) {
                                out.println("<div class = \"table-div\"><table><caption><b>" + request.getParameter("country") +
                                "</b></caption><tr><th>Date</th><th>Infections</th><th>Deaths</th></tr>");
                                for(List<String> entry : infectionsAndDeaths) {
                                    out.println("<tr>"); 
                                    out.println("<td>" + entry.get(2) + "</td>"); 
                                    out.println("<td>" + entry.get(0) + "</td>"); 
                                    out.println("<td>" + entry.get(1) + "</td>"); 
                                    out.println("</tr>"); 
                                }
                                out.println("</table></div>");
                            } else {
                                out.println("<p>Invalid country name or date too early</p>"); 
                            }
                        } else {
                            out.println("<p>Invalid country name or date too early</p>"); 
                        }
                    }
                }
            %>
        </div>
    </div>
</body>