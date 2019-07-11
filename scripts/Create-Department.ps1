$response = Invoke-WebRequest http://localhost:8080/api/department -Method POST -Body '{"name": "aaa"}' -ContentType "application/json"
Write-Host $response.RawContent