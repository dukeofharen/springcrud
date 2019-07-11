$response = Invoke-WebRequest http://localhost:8080/api/department
Write-Host $response.Content