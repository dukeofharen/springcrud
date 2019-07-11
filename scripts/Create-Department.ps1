$response = Invoke-WebRequest http://localhost:8080/api/department -Method POST -Body '{"name": "illegalDep"}' -ContentType "application/json"
Write-Host $response.RawContent