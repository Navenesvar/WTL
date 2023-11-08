<!DOCTYPE html>
<html>
<head>
    <title>Indian States and Places</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            background-color: #ffffff;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Indian States and Well-Known Places</h1>

    <?php
    // Load and parse the XML file
    $xml = simplexml_load_file('indian_states.xml');

    if ($xml === false) {
        die('Error loading XML file');
    }

    echo '<table>';
    echo '<tr><th>State</th><th>Well-Known Places</th></tr>';
    
    foreach ($xml->state as $state) {
        echo '<tr>';
        echo '<td>' . $state->name . '</td>';
        echo '<td>';
        
        foreach ($state->places->place as $place) {
            echo $place . '<br>';
        }
        
        echo '</td>';
        echo '</tr>';
    }

    echo '</table>';
    ?>
</body>
</html>
