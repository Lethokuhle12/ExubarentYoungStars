<!DOCTYPE html>
<html>
<head>
    <title>Change Residence</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h3>Choose Another Residence</h3>
    <form action="/application/change-residence/${userId}" method="post">
        <select class="form-control mb-3" name="newResidenceName">
            <option value="Sunrise">Sunrise</option>
            <option value="Moonlight">Moonlight</option>
            <option value="Greenhall">Greenhall</option>
            <!-- Add more residences as needed -->
        </select>
        <button class="btn btn-primary" type="submit">Change Residence</button>
    </form>
</div>
</body>
</html>
