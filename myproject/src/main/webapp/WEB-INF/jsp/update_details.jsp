<!DOCTYPE html>
<html>
<head>
    <title>Update Personal Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h3>Update Your Personal Info</h3>
    <form action="/application/update-details/${application.id}" method="post">
        <input class="form-control mb-2" type="text" name="fullName" value="${application.fullName}" placeholder="Full Name" required>
        <select class="form-control mb-2" name="gender">
            <option ${application.gender == 'Male' ? 'selected' : ''}>Male</option>
            <option ${application.gender == 'Female' ? 'selected' : ''}>Female</option>
        </select>
        <input class="form-control mb-2" type="text" name="phone" value="${application.phone}" placeholder="Phone">
        <input class="form-control mb-2" type="email" name="email" value="${application.email}" placeholder="Email">
        <input class="form-control mb-2" type="text" name="campus" value="${application.campus}" placeholder="Campus">
        <input class="form-control mb-2" type="text" name="funding" value="${application.funding}" placeholder="Funding">
        <button class="btn btn-primary mt-2" type="submit">Save Changes</button>
    </form>
</div>
</body>
</html>
