<%@ page import="java.util.*" %>
<!DOCTYPE html>
<head>  
    <title>Reports</title>  
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
            padding: 10px;
            text-align: center;
            width: fit-content;
            align-self: center;
        }

        table, td, th{
            border-spacing: 30px 10px;
            text-align: right;
        }

        a{
            color: inherit;
            text-decoration: none;
        }

        table {
            width: 100%;
        }
    </style>
</head>  
<body>
    <div class = "container">
        <ul>
            <li><a href="/query">Query</a></li>
            <li style="color:black;background-color:white;">Reports</li>
        </ul>
        <div class = "table-div">
            <h2>Reports</h2>
            <table>
                <caption><b>Top 10 countries by vaccination total count</b></caption>
                <tr>
                    <th>Rank</th>
                    <th>Country Name</th>
                    <th>Total number of vaccinations</th>
                </tr>
                <%
                    int index = 1;
                    //store query result in list
                    ArrayList<ArrayList<String>> top10Count= (ArrayList<ArrayList<String>>)request.getAttribute("top10Count");
                    //create table rows from query result
                    for(List<String> entry : top10Count) {
                        out.println("<tr>"); 
                        out.println("<td>" + index++ + "</td>"); 
                        out.println("<td>" + entry.get(0) + "</td>"); 
                        out.println("<td>" + entry.get(1) + "</td>"); 
                        out.println("</tr>"); 
                    }
                %>               
            </table>
            <table>
                <caption><b>Bottom 10 countries by vaccination total count</b></caption>
                <tr>
                    <th>Rank</th>
                    <th>Country Name</th>
                    <th>Total number of vaccinations</th>
                </tr>
                <%
                    index = 1;
                    //store query result in list
                    ArrayList<ArrayList<String>> bot10Count= (ArrayList<ArrayList<String>>)request.getAttribute("bot10Count");
                    //create table rows from query result
                    for(List<String> entry : bot10Count) {
                        out.println("<tr>"); 
                        out.println("<td>" + index++ + "</td>"); 
                        out.println("<td>" + entry.get(0) + "</td>"); 
                        out.println("<td>" + entry.get(1) + "</td>"); 
                        out.println("</tr>"); 
                    }
                %>
            </table>
            <table>
                <caption><b>Top 10 countries by number of infections per 100k inhabitants</b></caption>
                <tr>
                    <th>Rank</th>
                    <th>Country Name</th>
                    <th>Total number of infections</th>
                </tr>
                <%
                    index = 1;
                    //store query result in list
                    ArrayList<ArrayList<String>> top10Percent= (ArrayList<ArrayList<String>>)request.getAttribute("top10Percent");
                    //create table rows from query result
                    for(List<String> entry : top10Percent) {
                        out.println("<tr>"); 
                        out.println("<td>" + index++ + "</td>"); 
                        out.println("<td>" + entry.get(0) + "</td>"); 
                        out.println("<td>" + entry.get(1) + "</td>"); 
                        out.println("</tr>"); 
                    }
                %>
            </table>
        </div>
    </div>
</body>