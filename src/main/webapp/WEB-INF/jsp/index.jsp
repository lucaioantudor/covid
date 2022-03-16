<!DOCTYPE html>
<head>  
    <title>Home</title>  
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

        a {
            color: inherit;
            text-decoration: none;
        }
    </style>
</head>  
<body>
    <div class = "container">
        <ul>
            <li><a href="/query">Query</a></li>
            <li><a href="/reports">Reports</a></li>
        </ul>
        <div class = "table-div">
            <h2>Covid Assignment</h2>
            <p>Click on the Query or Reports tab.</p>
        </div>
    </div>
</body>