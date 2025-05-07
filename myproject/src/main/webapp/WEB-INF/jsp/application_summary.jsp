<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Application Summary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        .card {
            border: none;
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        .section-title {
            border-bottom: 2px solid #59075F;
            padding-bottom: 5px;
            margin-bottom: 20px;
            color: #59075F;
            font-weight: bold;
        }
        .btn-custom {
            background-color: #59075F;
            color: white;
            border-radius: 25px;
            border: none;
        }
        .btn-custom:hover {
            background-color: #46064a;
        }
        .status-uploaded {
            background-color: #28a745;
            color: white;
            padding: 2px 10px;
            border-radius: 10px;
            font-size: 0.85rem;
        }
        .status-missing {
            background-color: #dc3545;
            color: white;
            padding: 2px 10px;
            border-radius: 10px;
            font-size: 0.85rem;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card p-4">
        <h5 class="section-title">Personal Details</h5>
        <div class="row">
            <div class="col-md-6">
                <p><strong>Full Name:</strong></p>
                <p><strong>Gender:</strong></p>
                <p><strong>Phone:</strong></p>
                <p><strong>Email:</strong></p>
                <p><strong>Campus:</strong></p>
                <p><strong>Funding:</strong></p>
            </div>
            <div class="col-md-6 text-end">
                <p>${application.fullName}</p>
                <p>${application.gender}</p>
                <p>${application.phone}</p>
                <p>${application.email}</p>
                <p>${application.campus}</p>
                <p>${application.funding}</p>
            </div>
        </div>
        <div class="text-start mt-2">
            <a href="/update-details/${application.id}" class="btn btn-custom">Update Personal Details</a>
        </div>

        <h5 class="section-title mt-4">Submitted Documents</h5>
        <c:forEach var="doc" items="${documents}">
            <div class="d-flex justify-content-between align-items-center mb-2">
                <span>${doc.documentType}</span>
                <div>
                    <span class="${doc.status == 'uploaded' ? 'status-uploaded' : 'status-missing'}">
                        ${doc.status == 'uploaded' ? 'Uploaded' : 'Missing'}
                    </span>
                    <a href="/reupload-document/${doc.id}" class="btn btn-sm btn-custom ms-2">
                        ${doc.status == 'uploaded' ? 'Re-upload' : 'Upload'}
                    </a>
                </div>
            </div>
        </c:forEach>

        <h5 class="section-title mt-4">Residence Details</h5>
        <p>${residence.name} - Room ${residence.roomNumber}</p>
        <a href="/change-residence/${application.id}" class="btn btn-custom">Change Residence</a>

        <!-- Next Button -->
        <div class="text-end mt-4">
            <a href="/next-step" class="btn btn-custom">Next</a>
        </div>
    </div>
</div>
</body>
</html>
