<!DOCTYPE html>
<html>
<head>
    <title>Re-upload Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h3>Re-upload a Document</h3>
    <form action="/application/reupload-document/${userId}" method="post" enctype="multipart/form-data">
        <label>Document Type</label>
        <input class="form-control mb-2" type="text" name="documentType" required>

        <label>Upload File</label>
        <input class="form-control mb-2" type="file" name="documentFile" required>

        <button class="btn btn-success" type="submit">Upload</button>
    </form>
</div>
</body>
</html>
