$response = Invoke-WebRequest http://localhost:8080/api/department -Method POST -Body '{"name": "DUCODUCODUCO"}' -ContentType "application/json"
Write-Host $response.RawContent